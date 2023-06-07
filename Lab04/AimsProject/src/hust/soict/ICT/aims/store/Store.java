package hust.soict.ICT.aims.store;

import hust.soict.ICT.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {


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

    }
}
