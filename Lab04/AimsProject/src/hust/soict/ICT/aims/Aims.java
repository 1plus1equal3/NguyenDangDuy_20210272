package hust.soict.ICT.aims;

import hust.soict.ICT.aims.media.CompactDisc;
import hust.soict.ICT.aims.media.DigitalVideoDisc;
import hust.soict.ICT.aims.cart.Cart;
import hust.soict.ICT.aims.media.Media;
import hust.soict.ICT.aims.store.Store;

import java.util.Scanner;

public class Aims {

    //Create new store & cart
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main( String[] args) {
        //Showing menu
        showMenu();

    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int opt = getOption();
        switch (opt){
            case 1:
                store.displayStore();
                storeMenu();
                break;
            case 2:
                break;
            case 3:
                cart.print();
                cartMenu();
                break;
            default:
                showMenu();
                return;
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int opt;
        opt = getOption();
        switch (opt){
            case 1:
                Scanner sc = new Scanner(System.in);
                String title = sc.next();
                mediaDetailsMenu(title);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                showMenu();
                break;
            default:
                storeMenu();
                return;
        }

    }

    public static void mediaDetailsMenu(String title) {
        Media item = cart.getByTitle(title);
        if(item == null) {
            storeMenu();
            return;
        }

        item.displayMediaItem();

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int opt = getOption();

        switch (opt){
            case 0:
                storeMenu();
                return;
            case 1:
                cart.addMedia(item);
                break;
            case 2:
                if(item instanceof DigitalVideoDisc)
                    ((DigitalVideoDisc) item).play();
                else if(item instanceof CompactDisc)
                    ((CompactDisc) item).play();
                break;
            default:
                mediaDetailsMenu(title);
                return;
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static int getOption(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
