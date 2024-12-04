import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class Cus_ProductListPage extends JFrame {

    private JLabel imageLabel;
    private int imageIndex = 0;
    private final String[] imagePaths = {
            "/images/Image_Promo_Gucci.png",
            "/images/Image_Promo_H&M.png",
            "/images/Image_Promo_Uniqlo.png",
            "/images/Image_Promo_Zara.png"
    };

    // Setup frame
    public Cus_ProductListPage() {
        setTitle("Product List Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel logo, pencarian, cart
        ImageIcon logoOddiv = new ImageIcon(getClass().getResource("/images/Logo_Oddiv.png"));
        if (logoOddiv.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.err.println("Logo image not found: /images/Logo_Oddiv.png");
        }
        Image originalImage = logoOddiv.getImage();
        Image scaledImage = originalImage.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Gambar cart
        ImageIcon cartIcon = new ImageIcon(getClass().getResource("/images/cart_Logo.png"));
        if (cartIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.err.println("Cart image not found: /images/cart_Logo.png");
        }
        Image cartImage = cartIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledCartIcon = new ImageIcon(cartImage);

        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel logoLabel = new JLabel(scaledIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10);
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(logoLabel, gbc);

        // Search bar lebih kecil dan minimalis
        JTextField searchField = new JTextField();
        Dimension searchFieldSize = new Dimension(80, 25); // Ukuran lebih pendek
        searchField.setPreferredSize(searchFieldSize);
        searchField.setMinimumSize(searchFieldSize);
        searchField.setMaximumSize(searchFieldSize);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        searchField.setMargin(new Insets(2, 5, 2, 5));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 10); // Menambahkan jarak antara logo dan search bar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        topPanel.add(searchField, gbc);

        // Tombol "Cari" yang minimalis
        JButton searchButton = new JButton("Cari");
        searchButton.setPreferredSize(new Dimension(60, 25));
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 10); // Menambahkan jarak antara search bar dan tombol cari
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        topPanel.add(searchButton, gbc);

        // Cart button lebih kecil dan minimalis
        JButton cartButton = new JButton(scaledCartIcon);
        cartButton.setPreferredSize(new Dimension(30, 30));
        cartButton.setContentAreaFilled(false);
        cartButton.setBorderPainted(false);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        topPanel.add(cartButton, gbc);

        // Panel untuk promo yang
        JPanel promoPanel = new JPanel(new BorderLayout());
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        updateImage();

        promoPanel.add(imageLabel, BorderLayout.NORTH);

        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageIndex = (imageIndex + 1) % imagePaths.length;
                updateImage();
            }
        });
        timer.start();

        // Product List panel
        JPanel productListPanel = new JPanel(new GridLayout(1, 0, 10, 10));
        JScrollPane scrollPane = new JScrollPane(productListPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        // Mengambil data dari database dan menambahkannya ke panel produk
        fetchAndDisplayProducts(productListPanel,"1");

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(promoPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void fetchAndDisplayProducts(JPanel productListPanel, String cate) {
        // Koneksi ke database
        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String username = "hr";
        String password = "audri8802997";


        String query = "SELECT name, image, price FROM products WHERE category = cate";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            ArrayList<String> names = new ArrayList<>();
            ArrayList<String> images = new ArrayList<>();
            ArrayList<String> prices = new ArrayList<>();

            while (rs.next()) {
                names.add(rs.getString("product_name"));
                images.add(rs.getString("product_image"));
                prices.add(rs.getString("product_price"));
            }

            for (int i = 0; i < names.size(); i++) {
                JPanel productPanel = new JPanel(new BorderLayout());
                ImageIcon productIcon = new ImageIcon(getClass().getResource(images.get(i)));
                if (productIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                    System.err.println("Product image not found: " + images.get(i));
                }
                JLabel productImageLabel = new JLabel(productIcon);
                JLabel productNameLabel = new JLabel(names.get(i), JLabel.CENTER);
                productNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
                JLabel productPriceLabel = new JLabel(prices.get(i), JLabel.CENTER);
                productPriceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                productPanel.add(productImageLabel, BorderLayout.CENTER);
                productPanel.add(productNameLabel, BorderLayout.NORTH);
                productPanel.add(productPriceLabel, BorderLayout.SOUTH);

                productListPanel.add(productPanel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePaths[imageIndex]));
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            imageLabel.setIcon(icon);
        } else {
            System.err.println("Promo image not found: " + imagePaths[imageIndex]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cus_ProductListPage productListPage = new Cus_ProductListPage();
            productListPage.setVisible(true);
        });
    }
}
