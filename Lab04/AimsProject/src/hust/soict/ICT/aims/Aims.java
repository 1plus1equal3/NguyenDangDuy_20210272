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
                System.out.println("Pls enter the media's title: ");
                Scanner sc = new Scanner(System.in);
                String title = sc.next();
                Media item = store.getByTitle(title);
                if(item == null) {
                    System.out.println("No media item found");
                    storeMenu();
                    return;
                }
                item.displayMediaItem();
                mediaDetailsMenu(item);
                break;
            case 2:
                System.out.println("Pls enter the media's title: ");
                Scanner sc1 = new Scanner(System.in);
                String title1 = sc1.next();
                Media item1 = store.getByTitle(title1);
                if(item1 == null) {
                    System.out.println("No media item found");
                    storeMenu();
                    return;
                }
                cart.addMedia(item1);
                cart.print();
                storeMenu();
                break;
            case 3:
                System.out.println("Pls enter the media's title: ");
                Scanner sc2 = new Scanner(System.in);
                String title2 = sc2.next();
                Media item2 = store.getByTitle(title2);
                if(item2 == null) {
                    System.out.println("No media item found");
                    storeMenu();
                    return;
                }
                if(item2 instanceof DigitalVideoDisc)
                    ((DigitalVideoDisc) item2).play();
                else if(item2 instanceof CompactDisc)
                    ((CompactDisc) item2).play();
                storeMenu();
                break;
            case 4:
                cart.print();
                storeMenu();
                break;
            case 0:
                showMenu();
                break;
            default:
                storeMenu();
                return;
        }

    }

    public static void mediaDetailsMenu(Media item){
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
                mediaDetailsMenu(item);
                break;
            case 2:
                if(item instanceof DigitalVideoDisc)
                    ((DigitalVideoDisc) item).play();
                else if(item instanceof CompactDisc)
                    ((CompactDisc) item).play();
                mediaDetailsMenu(item);
                break;
            default:
                mediaDetailsMenu(item);
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
        int opt = getOption();

        switch (opt){
            case 0:
                showMenu();
                return;
            case 1:
                int optFilter;
                System.out.println("Filter by title/id (1/2): ");
                optFilter = getOption();
                if(optFilter==1) {
                    String title;
                    System.out.println("Pls enter the title: ");
                    Scanner sc = new Scanner(System.in);
                    title = sc.next();
                    cart.searchByTitle(title);
                }else if(optFilter==2){
                    int id;
                    System.out.println("Pls enter the id: ");
                    Scanner sc = new Scanner(System.in);
                    id = sc.nextInt();
                    cart.searchById(id);
                }
                else System.out.println("Wrong option!");
                cartMenu();
                break;
            case 2:
                int optSort;
                System.out.println("Sort by title/cost (1/2): ");
                optSort = getOption();
                if(optSort==1) cart.sortByTitle();
                else if(optSort==2) cart.sortByCost();
                else System.out.println("Wrong option!");
                cartMenu();
                break;
            case 3:

                cartMenu();
                break;

            case 4:

                cartMenu();
                break;

            case 5:

                cartMenu();
                break;
            default:
                cartMenu();
        }
    }

    private static int getOption(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
