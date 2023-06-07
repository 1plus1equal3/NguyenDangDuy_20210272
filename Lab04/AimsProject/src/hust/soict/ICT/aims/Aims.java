package hust.soict.ICT.aims;

import hust.soict.ICT.aims.disc.DigitalVideoDisc;
import hust.soict.ICT.aims.cart.Cart;

public class Aims {
    public static void main( String[] args) {
        //Create new cart
        Cart anOrder = new Cart();
        //Create new DVD Objects and add them to cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc[] dvds = {dvd1,dvd2,dvd3};
        anOrder.addDigitalVideoDisc(dvds);
        //anOrder.addDigitalVideoDisc(dvd1,dvd2,dvd3);
        //print total cost of the items in the cart
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.println("Total cost of remained items is: ");
        System.out.println(anOrder.totalCost());


    }
}
