package hust.soict.globalict.aims.screen;

import hust.soict.ICT.aims.cart.Cart;
import hust.soict.ICT.aims.media.Media;
import hust.soict.ICT.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        container.add(addCartBtn(media));
        if (media instanceof Playable) {
            container.add(getPlayBtn(media));
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private JButton getPlayBtn(Media media) {
        JButton button = new JButton("Play");
        button.addActionListener(e -> {
            JDialog dialog = new JDialog(new JFrame(), "Media player");
            dialog.setLayout(new FlowLayout());
            dialog.add(new JLabel(media.getTitle() + " is playing"));
            dialog.setSize(new Dimension(200, 100));
            dialog.setVisible(true);
        });
        return button;
    }

    private JButton addCartBtn(Media media){
        JButton button = new JButton("Add to cart");
        button.addActionListener(e -> {
             cart.addMedia(media);
        });
        return button;
    }
}
