import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class Cus_OrderHisPage extends JFrame {

    public Cus_OrderHisPage() {
        setTitle("Riwayat Pemesanan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label judul
        JLabel titleLabel = new JLabel("Riwayat Pemesanan", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Tabel untuk menampilkan riwayat pemesanan
        String[] columnNames = {"ID Pemesanan", "Tanggal", "Total", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable orderTable = new JTable(model);

        // Mengatur gaya tabel
        orderTable.setFont(new Font("Arial", Font.PLAIN, 14));
        orderTable.setRowHeight(30);
        orderTable.setFillsViewportHeight(true);

        // Panel untuk tabel dengan scrollbar
        JScrollPane tableScrollPane = new JScrollPane(orderTable);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Tombol kembali
        JButton backButton = new JButton("Kembali");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(100, 40));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Mengambil data dari database dan menambahkannya ke tabel
        fetchAndDisplayOrders(model);
    }

    private void fetchAndDisplayOrders(DefaultTableModel model) {
        // Koneksi ke database
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        String query = "SELECT order_id, order_date, total_amount, status FROM orders";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String orderId = rs.getString("order_id");
                String orderDate = rs.getString("order_date");
                String totalAmount = rs.getString("total_amount");
                String status = rs.getString("status");
                model.addRow(new Object[]{orderId, orderDate, totalAmount, status});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cus_OrderHisPage orderHisPage = new Cus_OrderHisPage();
            orderHisPage.setVisible(true);
        });
    }
}
