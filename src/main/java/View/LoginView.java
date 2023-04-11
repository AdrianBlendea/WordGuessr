package View;



import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginView extends JFrame  {

    private JPanel contentPane;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JLabel welcomeLabel;
    private JPasswordField passwordField;
    private JButton loginButton;





    public LoginView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 658, 468);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameLabel.setBounds(38, 184, 91, 29);
        contentPane.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(139, 190, 328, 19);
        contentPane.add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        passwordLabel.setBounds(38, 242, 91, 29);
        contentPane.add(passwordLabel);

        welcomeLabel = new JLabel("WELCOME");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        welcomeLabel.setBounds(229, 332, 145, 89);
        contentPane.add(welcomeLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(139, 248, 328, 19);
        contentPane.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(241, 299, 121, 21);
        contentPane.add(loginButton);

        JLabel iconLabel = new JLabel("");
        iconLabel.setIcon(new ImageIcon("Images\\loginIcon.jfif"));
        iconLabel.setBounds(200, 0, 360, 181);
        contentPane.add(iconLabel);
    }
    public String getUsername() {
        return this.usernameTextField.getText();

    }

    public String getPassword() {
        return this.passwordField.getText();
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
