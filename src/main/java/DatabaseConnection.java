import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    public static void main(String[] args) {
        // URL koneksi ke database Oracle
        String jdbcURL = "jdbc:oracle:thin@localhost:1521:xe"; // Gantilah dengan konfigurasi database Anda
        String username = "hr"; // Gantilah dengan username database Anda
        String password = "audri8802997"; // Gantilah dengan password database Anda

        // Register driver
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver berhasil terdaftar!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Connection connection = null;

        try {
            // Membuat koneksi ke database
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Koneksi ke database berhasil!");

            // Membuat statement dan menjalankan query
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Categories"; // Contoh query, sesuaikan dengan tabel di database Anda
            ResultSet resultSet = statement.executeQuery(sql);

            // Memproses hasil query
            while (resultSet.next()) {
                int categoryId = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("category_name");
                String description = resultSet.getString("description");

                System.out.println(categoryId + " | " + categoryName + " | " + description);
            }

            // Menutup ResultSet dan Statement
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
