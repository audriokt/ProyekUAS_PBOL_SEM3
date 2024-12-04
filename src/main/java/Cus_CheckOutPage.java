import javax.swing.*;
import java.awt.*;

public class Cus_CheckOutPage extends JFrame {

    public Cus_CheckOutPage() {
        setTitle("Checkout");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label judul
        JLabel titleLabel = new JLabel("Checkout", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel untuk informasi pembayaran
        JPanel paymentPanel = new JPanel(new GridBagLayout());
        paymentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Nama lengkap
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel nameLabel = new JLabel("Nama Lengkap:");
        paymentPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        paymentPanel.add(nameField, gbc);

        // Alamat pengiriman
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel addressLabel = new JLabel("Alamat Pengiriman:");
        paymentPanel.add(addressLabel, gbc);

        gbc.gridx = 1;
        JTextField addressField = new JTextField(20);
        paymentPanel.add(addressField, gbc);

        // Nomor telepon
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel phoneLabel = new JLabel("Nomor Telepon:");
        paymentPanel.add(phoneLabel, gbc);

        gbc.gridx = 1;
        JTextField phoneField = new JTextField(20);
        paymentPanel.add(phoneField, gbc);

        // Metode pembayaran
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel paymentLabel = new JLabel("Metode Pembayaran:");
        paymentPanel.add(paymentLabel, gbc);

        gbc.gridx = 1;
        String[] paymentMethods = {"Kartu Kredit", "Transfer Bank", "COD (Cash on Delivery)"};
        JComboBox<String> paymentComboBox = new JComboBox<>(paymentMethods);
        paymentPanel.add(paymentComboBox, gbc);

        mainPanel.add(paymentPanel, BorderLayout.CENTER);

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton confirmButton = new JButton("Konfirmasi");
        confirmButton.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmButton.setBackground(Color.BLACK);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFocusPainted(false);

        buttonPanel.add(confirmButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cus_CheckOutPage checkOutPage = new Cus_CheckOutPage();
            checkOutPage.setVisible(true);
        });
    }
}
