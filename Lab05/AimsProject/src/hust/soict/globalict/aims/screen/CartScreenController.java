package hust.soict.globalict.aims.screen;

import hust.soict.ICT.aims.cart.Cart;
import hust.soict.ICT.aims.media.Media;
import hust.soict.ICT.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.awt.*;
import java.util.function.Predicate;

public class CartScreenController {
    private Cart cart;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton getRadioBtnFilterTitle;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private Button placeOrderBtn;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, String> colMediaCost;
    @FXML
    private Label totalCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize(){
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, String>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        totalCost.setText(String.valueOf(cart.totalCost()));

        tblMedia.getItems().addListener(new ListChangeListener<Media>() {
            @Override
            public void onChanged(Change<? extends Media> change) {
                totalCost.setText(String.valueOf(cart.totalCost()));
            }
        });

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observableValue, Media media, Media newValue) {
                if(newValue!=null){
                    updateButtonBar(newValue);
                }
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if(media instanceof Playable){
            btnPlay.setVisible(true);
            btnPlay.setOnAction(event -> {
                JDialog dialog = new JDialog(new JFrame(), "Media player");
                dialog.setLayout(new FlowLayout());
                dialog.add(new JLabel(media.getTitle() + " is playing"));
                dialog.setSize(new Dimension(200, 100));
                dialog.setVisible(true);
            });
        }
        else btnPlay.setVisible(false);
    }

    void showFilteredMedia(String key){
        Predicate<Media> predicate = new Predicate<Media>() {
            @Override
            public boolean test(Media s) {
                return s.getTitle().contains(key);
            }
        };
        FilteredList<Media> filteredList = cart.getItemsOrdered().filtered(predicate);
        tblMedia.setItems(filteredList);
    }
    @FXML
    void btnRemovePressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnPlaceOrderClick(ActionEvent event){
        JDialog dialog = new JDialog(new JFrame(), "Place order");
        dialog.setLayout(new FlowLayout());
        dialog.add(new JLabel("The total cost is: " + totalCost.getText()));
        dialog.add(new JLabel("Place order successfully!"));
        dialog.setSize(new Dimension(200, 100));
        dialog.setVisible(true);
    }

}
