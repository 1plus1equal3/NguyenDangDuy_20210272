package hust.soict.globalict.aims.screen;

import hust.soict.ICT.aims.cart.Cart;
import hust.soict.ICT.aims.media.Book;
import hust.soict.ICT.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }

    //test cart screen
    public static void main(String[] args) {
        Cart cart1 = new Cart();

        //Test data
        Book book = new Book("Tan gai dai cuong", "Sach Giao Khoa Quan Trong", 0.01f);

        DigitalVideoDisc[] disc = new DigitalVideoDisc[5];
        disc[0] = new DigitalVideoDisc("Nhac Vang", "DVD", "Duy", 120, 9.99f);
        disc[1] = new DigitalVideoDisc("Nhac Tre", "DVD", "LL", 90, 7.99f);
        disc[2] = new DigitalVideoDisc("Nhac Tinh Ca", "DVD", "Khanh", 150, 12.99f);
        disc[3] = new DigitalVideoDisc("Nhac Rap", "DVD", "Allen", 105, 8.99f);
        disc[4] = new DigitalVideoDisc("Nhac Rock", "DVD", "Jackson", 135, 10.99f);
        cart1.addMedia(disc);
        cart1.addMedia(book);

        //Run application
        new CartScreen(cart1);
    }
}
