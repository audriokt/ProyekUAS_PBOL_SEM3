import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Cus_CartPage extends JFrame {

    public Cus_CartPage() {
        setTitle("Shopping Cart");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label judul
        JLabel titleLabel = new JLabel("Shopping Cart", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Tabel untuk menampilkan produk di shopping cart
        String[] columnNames = {"Nama Produk", "Jumlah", "Harga per Unit", "Total"};
        Object[][] data = {
                {"Gucci T-Shirt", 1, "Rp 1.500.000", "Rp 1.500.000"},
                {"H&M Hoodie", 2, "Rp 750.000", "Rp 1.500.000"},
                {"Uniqlo Jacket", 1, "Rp 1.000.000", "Rp 1.000.000"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable cartTable = new JTable(model);

        // Mengatur gaya tabel
        cartTable.setFont(new Font("Arial", Font.PLAIN, 14));
        cartTable.setRowHeight(30);
        cartTable.setFillsViewportHeight(true);

        // Panel untuk tabel dengan scrollbar
        JScrollPane tableScrollPane = new JScrollPane(cartTable);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Panel untuk tombol dan total harga
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // Label total harga
        JLabel totalLabel = new JLabel("Total: Rp 4.000.000", JLabel.RIGHT);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        footerPanel.add(totalLabel, BorderLayout.NORTH);

        // Tombol checkout dan kembali
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(new Font("Arial", Font.PLAIN, 14));
        checkoutButton.setBackground(Color.BLACK);
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setFocusPainted(false);
        checkoutButton.setPreferredSize(new Dimension(120, 40));

        JButton backButton = new JButton("Kembali");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(120, 40));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(checkoutButton);
        footerPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cus_CartPage cartPage = new Cus_CartPage();
            cartPage.setVisible(true);
        });
    }
}
