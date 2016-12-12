package GUI;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import DB.*;

public class LoginGUI extends JFrame {
    public LoginGUI() {
        // basic login frame
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setLayout(new FlowLayout());
        
        // create login panel
        JPanel loginPanel = new JPanel();
        // create labels and text fields
        JLabel lblUserName = new JLabel("Login: ");
        JLabel lblPassword = new JLabel("Password: ");
        JTextField txtUserName = new JTextField(10);
        JTextField txtPassword = new JTextField(10);
        // create buttons
        JButton btnLogin = new JButton("Login");
        JButton btnExit = new JButton("Exit");
        
        // add components to login panel
        loginPanel.add(lblUserName);
        loginPanel.add(txtUserName);
        loginPanel.add(lblPassword);
        loginPanel.add(txtPassword);
        loginPanel.add(btnLogin);
        loginPanel.add(btnExit);
        
        add(loginPanel);
    }
    
    // method that will send data to DB to check if user is existing
    public void login() {
        //DBConnection.systemLogin(txtUserName.getText(), txtPassword.getText());
    }
}
