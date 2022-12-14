package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword;
    
    Login() {
        
     
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(150, 65, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(250, 65, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(150, 125, 100, 30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(250, 125, 150, 30);
        add(tfpassword);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(200, 190, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1270, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1270, 700);
        add(image);
        
        setSize(1280, 680);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
