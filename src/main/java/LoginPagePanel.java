import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginPagePanel extends JFrame {
    private Image backgroundImage;

    public LoginPagePanel() {
        setTitle("Login Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame

        // Background image
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/images/Login_PageImage.jpg")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Panel utama dengan override paintComponent
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        mainPanel.setLayout(new BorderLayout());

        // Panel judul dengan layout BorderLayout
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setOpaque(false);

        // Label ODDIV di pojok kiri atas
        ImageIcon logoOddiv = new ImageIcon(getClass().getResource("/images/Logo_Oddiv.png"));
        // Mengubah ukuran ImageIcon
        Image originalImage = logoOddiv.getImage();
        Image scaledImage = originalImage.getScaledInstance(110, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel oddivLabel = new JLabel(scaledIcon);
        titlePanel.add(oddivLabel, BorderLayout.WEST);

        // Tombol Create Account di pojok kanan atas tanpa background dan dengan font Arial
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 12));
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.setContentAreaFilled(false);
        createAccountButton.setBorderPainted(false);
        titlePanel.add(createAccountButton, BorderLayout.EAST);

        // Panel form login
        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Margin

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 24));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JTextField userField = new JTextField(15);
        userField.setBackground(Color.WHITE);
        userField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JPasswordField passField = new JPasswordField(15);
        passField.setBackground(Color.WHITE);
        passField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JCheckBox showPassword = new JCheckBox();
        showPassword.setOpaque(false);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 12));
        loginButton.setBackground(new Color(255, 179, 212));
        loginButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(loginLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(userLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        formPanel.add(passLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(passField, gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        formPanel.add(showPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(loginButton, gbc);

        // Tambahkan panel ke frame utama
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passField.setEchoChar((char) 0); // Tampilkan kata sandi
                } else {
                    passField.setEchoChar('*');
                }
            }
        });

        // Add focus listener for hover effect
        userField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                userField.setBackground(new Color(230, 230, 230));
            }

            @Override
            public void focusLost(FocusEvent e) {
                userField.setBackground(Color.WHITE);
            }
        });
        passField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                passField.setBackground(new Color(230, 230, 230));
            }

            @Override
            public void focusLost(FocusEvent e) {
                passField.setBackground(Color.WHITE);
            }
        });

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginPagePanel loginPage = new LoginPagePanel();
            loginPage.setVisible(true);
        });
    }
}
