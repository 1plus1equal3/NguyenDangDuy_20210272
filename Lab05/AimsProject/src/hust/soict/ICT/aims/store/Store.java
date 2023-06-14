package hust.soict.ICT.aims.store;

import hust.soict.ICT.aims.media.CompactDisc;
import hust.soict.ICT.aims.media.DigitalVideoDisc;
import hust.soict.ICT.aims.media.Media;
import hust.soict.ICT.aims.media.Track;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public Store() {
        populateStore();
    }

    private final ArrayList<Media> itemInStore = new ArrayList<>();

    public void addMedia(Media... media) {
        itemInStore.addAll(List.of(media));
        System.out.println("Added " + itemInStore.size() + " items");
    }

    public void removeMedia(Media... media) {
        itemInStore.removeAll(List.of(media));
    }

    public void displayStore() {
        System.out.println("Items currently in store: \n");
        for (Media m : itemInStore) {
            System.out.println(m.getTitle() + " "
                    + m.getCategory() + " "
                    + m.getCost() + " "
                    + m.getId());
        }
    }

    private void populateStore(){
        DigitalVideoDisc[] disc = new DigitalVideoDisc[5];
        disc[0] = new DigitalVideoDisc("Nhac Vang", "DVD", "Duy", 120, 9.99f);
        disc[1] = new DigitalVideoDisc("Nhac Tre", "DVD", "LL", 90, 7.99f);
        disc[2] = new DigitalVideoDisc("Nhac Tinh Ca", "DVD", "Khanh", 150, 12.99f);
        disc[3] = new DigitalVideoDisc("Nhac Rap", "DVD", "Allen", 105, 8.99f);
        disc[4] = new DigitalVideoDisc("Nhac Rock", "DVD", "Jackson", 135, 10.99f);

        List<Track> tracks1 = new ArrayList<>();
        tracks1.add(new Track("Track Tieng Anh 1", 180));
        tracks1.add(new Track("Track Tieng Anh 2", 200));
        tracks1.add(new Track("Track Tieng Anh 3", 150));
        CompactDisc cd1 = new CompactDisc("Dia hoc Tieng Anh", "CD", 9.99f, "Cambridge", tracks1);

        List<Track> tracks2 = new ArrayList<>();
        tracks2.add(new Track("Cho", 220));
        tracks2.add(new Track("Meo", 190));
        CompactDisc cd2 = new CompactDisc("The gioi DV", "CD", 7.99f, "Unknown", tracks2);

        List<Track> tracks3 = new ArrayList<>();
        tracks3.add(new Track("GT lofi cuc chill", 170));
        tracks3.add(new Track("DSTT tren nen nhac Kha Banh", 210));
        CompactDisc cd3 = new CompactDisc("SVBK", "CD", 12.99f, "SV nam 8", tracks3);

        itemInStore.addAll(List.of(disc));
        itemInStore.add(cd1);
        itemInStore.add(cd2);
        itemInStore.add(cd3);
    }

    public Media getByTitle(String title) {
        for (Media item : itemInStore) {
            if (item.isMatchTitle(title)) return item;
        }
        System.out.println("Can't find item " + title);
        return null;
    }
}
