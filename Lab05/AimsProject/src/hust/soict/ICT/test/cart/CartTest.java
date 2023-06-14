package hust.soict.ICT.test.cart;

import hust.soict.ICT.aims.media.DigitalVideoDisc;
import hust.soict.ICT.aims.cart.Cart;

public class CartTest {
    public static void main(String[] args) {
        //Create cart
        Cart cart = new Cart();
        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87,19.95f);
        cart.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87,24.95f);
        cart.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        //Test the print method
        cart.print();

        //To-do: Test the search methods here
        cart.searchByTitle("The Lion King");
        cart.searchById(1);

    }
}
