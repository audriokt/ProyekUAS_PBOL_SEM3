import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CustomerPage_Product extends JFrame{

    private JLabel imageLabel;
    private int imageIndex = 0;
    private final String[] imagePaths = {
            "/images/1.jpg",
            "/images/2.jpg",
            "/images/3.jpeg"
    };

    public CustomerPage_Product() {
        setTitle("Image Slideshow");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        updateImage();

        add(imageLabel, BorderLayout.CENTER);

        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageIndex = (imageIndex + 1) % imagePaths.length;
                updateImage();
            }
        });
        timer.start();
    }

    private void updateImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePaths[imageIndex]));
        imageLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomerPage_Product slideshow = new CustomerPage_Product();
            slideshow.setVisible(true);
        });
    }
}


