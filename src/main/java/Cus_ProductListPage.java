import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cus_ProductListPage extends JFrame{
    //ada panel yang nampilin logo, pencarian, dan cart
    //ada panel yang nampilin promo yang bakal geser
    //ada panel yang nampilin kategori barang dan gambar yang ada nama dan harga yang diambil dari data base
    // gambar dapat di pencet dan akan menuju ke list barang pada kategori tersebut


    private JLabel imageLabel;
    private int imageIndex = 0;
    private final String[] imagePaths = {
            "/images/Image_Promo_Gucci.png",
            "/images/Image_Promo_H&M.png",
            "/images/Image_Promo_Uniqlo.png",
            "/images/Image_promo_Zara.png"
    };

    //setup frame
    public Cus_ProductListPage() {
        setTitle("Product List Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //panel logo, pencarian, cart
        // Label ODDIV di pojok kiri atas
        ImageIcon logoOddiv = new ImageIcon(getClass().getResource("/images/Logo_Oddiv.png"));
        // Mengubah ukuran ImageIcon
        Image originalImage = logoOddiv.getImage();
        Image scaledImage = originalImage.getScaledInstance(110, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        //gambar cart
        ImageIcon cartIcon = new ImageIcon(getClass().getResource("/images/cart_Logo.png"));

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel logoLabel = new JLabel(scaledIcon);
        JTextField searchField = new JTextField("Topi Zara", 15);
        JButton cartButton = new JButton(cartIcon);

        topPanel.add(logoLabel, BorderLayout.WEST);
        topPanel.add(searchField, BorderLayout.CENTER);
        topPanel.add(cartButton, BorderLayout.EAST);

        //Panel untuk promo yang
        JPanel promoPanel = new JPanel();
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        updateImage();

        promoPanel.add(imageLabel, BorderLayout.CENTER);

        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageIndex = (imageIndex + 1) % imagePaths.length;
                updateImage();
            }
        });
        timer.start();

        // Panel untuk kategori barang dan gambar yang ada nama dan harga
        JPanel categoryPanel = new JPanel(new GridLayout(0, 3));
        String[] categories = {"Elektronik", "Fashion", "Makanan"};
        String[] images = {"image1.jpg", "image2.jpg", "image3.jpg"};
        String[] prices = {"$100", "$50", "$20"};

        for (int i = 0; i < categories.length; i++) {
            JPanel itemPanel = new JPanel(new BorderLayout());
            JLabel imageLabel = new JLabel(new ImageIcon(getClass().getResource(images[i])));
            JLabel nameLabel = new JLabel(categories[i]);
            JLabel priceLabel = new JLabel(prices[i]);
            itemPanel.add(imageLabel, BorderLayout.CENTER);
            itemPanel.add(nameLabel, BorderLayout.NORTH);
            itemPanel.add(priceLabel, BorderLayout.SOUTH);

            // Menambahkan listener untuk mengklik gambar
            imageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(null, "Menuju ke list barang dari kategori: " + nameLabel.getText());
                    // Implementasi lebih lanjut untuk menampilkan list barang dari kategori tersebut
                }
            });

            categoryPanel.add(itemPanel);
        }
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(promoPanel,BorderLayout.CENTER);
        add(categoryPanel,BorderLayout.SOUTH);
    }

    private void updateImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePaths[imageIndex]));
        imageLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            Cus_ProductListPage productListPage = new Cus_ProductListPage();
            productListPage.setVisible(true);
        });
    }
}
