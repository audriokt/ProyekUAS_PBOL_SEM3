import javax.swing.*;
import java.awt.*;

public class Cus_ProductDetailPage extends JFrame {

    public Cus_ProductDetailPage(String productName, String productImage, double productPrice, int productStock, String productDescription) {
        setTitle("Detail Produk: " + productName);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label judul
        JLabel titleLabel = new JLabel(productName, JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel untuk gambar produk
        JPanel imagePanel = new JPanel();
        ImageIcon productIcon = new ImageIcon(getClass().getResource(productImage));
        JLabel imageLabel = new JLabel(productIcon);
        imagePanel.add(imageLabel);
        mainPanel.add(imagePanel, BorderLayout.WEST);

        // Panel untuk detail produk
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        JLabel priceLabel = new JLabel("Harga: Rp " + productPrice);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        detailsPanel.add(priceLabel);

        JLabel stockLabel = new JLabel("Stok: " + productStock + " pcs");
        stockLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        detailsPanel.add(stockLabel);

        JLabel descriptionLabel = new JLabel("<html><body style='width: 200px;'>" + productDescription + "</body></html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        detailsPanel.add(descriptionLabel);

        mainPanel.add(detailsPanel, BorderLayout.CENTER);

        // Tombol kembali
        JButton backButton = new JButton("Kembali");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cus_ProductDetailPage productDetailPage = new Cus_ProductDetailPage(
                    "Gucci T-Shirt",
                    "/path/to/image/gucci_tshirt.png",
                    1500000,
                    10,
                    "T-Shirt high-end dari Gucci yang nyaman dan bergaya."
            );
            productDetailPage.setVisible(true);
        });
    }
}
