package employeemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfeducation, tfLastName, tfStartDate, tfphone, tfEndDate, tfemail, tfsalary, tfTitle;
    JLabel lblkerId;
    JButton add, back;
    String kerId;
    
    UpdateEmployee(String kerId) {
        this.kerId = kerId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelFirstName = new JLabel("First Name");
        labelFirstName.setBounds(50, 150, 150, 30);
        labelFirstName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelFirstName);
        
        JLabel lblFirstName = new JLabel();
        lblFirstName.setBounds(200, 150, 150, 30);
        add(lblFirstName);
        
        JLabel labelLastName = new JLabel("Last Name");
        labelLastName.setBounds(400, 150, 150, 30);
        labelLastName.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelLastName);
        
        JLabel lblLastName = new JLabel();
        lblLastName.setBounds(200, 200, 150, 30);
        add(lblLastName);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        JLabel labelStartDate = new JLabel("Start Date");
        labelStartDate.setBounds(50, 250, 150, 30);
        labelStartDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelStartDate);
        
        JLabel lblStartDate = new JLabel();
        lblStartDate.setBounds(200, 200, 150, 30);
        add(lblStartDate);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);
        
        JLabel labelTitle = new JLabel("Title");
        labelTitle.setBounds(50, 350, 150, 30);
        labelTitle.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelTitle);
        
        tfTitle = new JTextField();
        tfTitle.setBounds(200, 350, 150, 30);
        add(tfTitle);
        
        JLabel labelEndDate = new JLabel("End Date");
        labelEndDate.setBounds(400, 350, 150, 30);
        labelEndDate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEndDate);
        
        tfEndDate = new JTextField();
        tfEndDate.setBounds(600, 350, 150, 30);
        add(tfEndDate);
        
        JLabel labelkerId = new JLabel("Kerberos id");
        labelkerId.setBounds(50, 400, 150, 30);
        labelkerId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelkerId);
        
        lblkerId = new JLabel();
        lblkerId.setBounds(200, 400, 150, 30);
        lblkerId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblkerId);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+kerId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblFirstName.setText(rs.getString("FirstName"));
                tfLastName.setText(rs.getString("LastName"));
                lbldob.setText(rs.getString("dob"));
                tfStartDate.setText(rs.getString("StartDate"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfEndDate.setText(rs.getString("EndDate"));
                lblkerId.setText(rs.getString("kerId"));
                tfTitle.setText(rs.getString("Title"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(1280, 680);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String Title = tfTitle.getText();
            String EndDate = tfEndDate.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update employee set salary = '"+salary+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', Title = '"+Title+"', EndDate = '"+EndDate+"' where kerId = '"+kerId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
