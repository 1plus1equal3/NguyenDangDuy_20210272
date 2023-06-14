package hust.soict.ICT.aims.cart;

import hust.soict.ICT.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media){
        itemsOrdered.add(media);
        System.out.println("Add to cart: " + media.getTitle());
    }

    public void addMedia(Media... media){
        itemsOrdered.addAll(List.of(media));
    }

    public void removeMedia(Media media){
        if(itemsOrdered.remove(media)) System.out.println("Remove " + media.getTitle() + "successful");
        else System.out.println("No " + media.getTitle() + "found");
    }

    public void removeMedia(Media... media){
        itemsOrdered.removeAll(List.of(media));
    }

    public float totalCost() {
        float sum = 0f;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
   }

    public void print() {
        if(itemsOrdered.size() == 0) {
            System.out.println("No item has been ordered");
            return;
        }
        System.out.println("***********************CART***********************\n" +
                "Ordered Items:");
        for(Media media : itemsOrdered) {
            if(media == null) break;
            System.out.println(media.getTitle());
        }
        System.out.println("Total cost:" + this.totalCost() + "\n***************************************************");
    }
    public void searchByTitle(String title) {
        int count = 0;
        System.out.println("***********************CART***********************\n" +
                "Items with Title:");
        for(Media item : itemsOrdered) {
            if(item == null) break;
            if(item.isMatchTitle(title)) {
                count++;
                System.out.println(item.getTitle());
            }
        }
        if(count == 0) System.out.println("No item has that title");
        System.out.println("***************************************************");
    }
    public void searchById(int id) {
        int count = 0;
        System.out.println("***********************CART***********************\n" +
                "Items with ID:");
        for(Media item : itemsOrdered) {
            if(item == null) break;
            if(item.isMatchId(id)) {
                count++;
                System.out.println(item.getTitle());
                break;
            }
        }
        if(count == 0) System.out.println("No item has that id");
        System.out.println("***************************************************");
    }

    public Media getByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item.isMatchTitle(title)) return item;
        }
        System.out.println("Can't find item " + title);
        return null;
    }

    public void sortByCost(){
        itemsOrdered.sort(Media.COMPARE_BY_COST);
    }

    public void sortByTitle(){
        itemsOrdered.sort(Media.COMPARE_BY_TITLE);
    }

}