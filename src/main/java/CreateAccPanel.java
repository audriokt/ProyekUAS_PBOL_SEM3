import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
public class CreateAccPanel extends JFrame{
        private Image backgroundImage;

        public CreateAccPanel() {
            setTitle("Create Account");
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);  // Center the frame

            // Background image
            try {
                backgroundImage = new ImageIcon(getClass().getResource("/images/Create_Account_PageImage.jpg")).getImage();
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

            // Label Create Account di tengah
            JLabel createLabel = new JLabel("Create Account");
            createLabel.setForeground(Color.BLACK);
            createLabel.setFont(new Font("Arial", Font.BOLD, 24));
            createLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // Panel form create account
            JPanel formPanel = new JPanel();
            formPanel.setOpaque(false);
            formPanel.setLayout(new GridBagLayout());
            formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 50, 10);  // Margin

            JLabel userLabel = new JLabel("Username:");
            userLabel.setFont(new Font("Arial", Font.BOLD, 12));

            JTextField userField = new JTextField(15);
            userField.setBackground(Color.WHITE);
            userField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            userField.setBorder(new LineBorder(Color.BLACK, 1));


            JLabel emailLabel = new JLabel("Email:");
            emailLabel.setFont(new Font("Arial", Font.BOLD, 12));

            JTextField emailField = new JTextField(15);
            emailField.setBackground(Color.WHITE);
            emailField.setBorder(new LineBorder(Color.BLACK, 1));

            JLabel passLabel = new JLabel("Password:");
            passLabel.setFont(new Font("Arial", Font.BOLD, 12));

            JPasswordField passField = new JPasswordField(15);
            passField.setBackground(Color.WHITE);
            passField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            passField.setBorder(new LineBorder(Color.BLACK, 1));

            JCheckBox showPassword = new JCheckBox();
            showPassword.setOpaque(false);

            JButton createAccountButton = new JButton("Create Account");
            createAccountButton.setFont(new Font("Arial", Font.BOLD, 12));
            createAccountButton.setBackground(new Color(255, 179, 212));
            createAccountButton.setForeground(Color.WHITE);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(0, 0, 10, 10);
            formPanel.add(createLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.insets = new Insets(10, 0, 10, 30);
            gbc.anchor = GridBagConstraints.LINE_END;
            formPanel.add(userLabel, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            formPanel.add(userField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.LINE_END;
            formPanel.add(emailLabel, gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            formPanel.add(emailField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
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
            gbc.gridy = 4;
            gbc.anchor = GridBagConstraints.CENTER;
            formPanel.add(createAccountButton, gbc);

            // Tambahkan panel ke frame utama
            mainPanel.add(titlePanel, BorderLayout.NORTH);
            mainPanel.add(formPanel, BorderLayout.EAST);

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
            emailField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    emailField.setBackground(new Color(230, 230, 230));
                }

                @Override
                public void focusLost(FocusEvent e) {
                    emailField.setBackground(Color.WHITE);
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
                CreateAccPanel createAccPage = new CreateAccPanel();
                createAccPage.setVisible(true);
            });
        }
    }

