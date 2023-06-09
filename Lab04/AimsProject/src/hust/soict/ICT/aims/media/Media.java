package hust.soict.ICT.aims.media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Media {

    public static final Comparator<Media> COMPARE_BY_TITLE = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST = new MediaComparatorByCostTitle();
    public Media() {
    }

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title) {
        this.title = title;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isMatchTitle(String title) {
        return this.getTitle().contains(title);
    }

    public boolean isMatchId(int id) {
        return this.getId() == id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Media) return title.equals(((Media) obj).getTitle());
        else return false;
    }

    public void displayMediaItem(){
        System.out.println(title + " " + category + " " + cost);
    }

    //Test toString() method
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<>();
        DigitalVideoDisc dvd = new DigitalVideoDisc("Yellow");
        Book book = new Book();
        CompactDisc cd = new CompactDisc("Red");
        mediae.add(dvd);
        mediae.add(book);
        mediae.add(cd);

        for(Media media: mediae){
            System.out.println(media.toString());
        }
    }
}
