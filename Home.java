package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton search, add, update, remove,filter;
    
    Home() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Hom.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1270, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1270, 650);
        add(image);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(750, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);
        
        add = new JButton("Add Employee");
        add.setBounds(750, 100, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        search = new JButton("Search Employees");
        search.setBounds(920, 100, 150, 40);
        search.addActionListener(this);
        image.add(search);
        
        update = new JButton("Update Employee");
        update.setBounds(750, 150, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(920, 150, 150, 40);
        remove.addActionListener(this);
        image.add(remove);
        
        filter = new JButton("Filter Employee");
        filter.setBounds(840, 200, 150, 40);
        filter.addActionListener(this);
        image.add(filter);
        
        setSize(1280, 680);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == search) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else if(ae.getSource() == remove){
            setVisible(false);
            new RemoveEmployee();
        }
        else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}

