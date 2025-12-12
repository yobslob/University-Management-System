package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;
    JButton login,cancel;

    Login(){
        JLabel labelName = new JLabel("Username");
        labelName.setBounds(40,40,100,20);
        add(labelName);

        textField1 = new JTextField();
        textField1.setBounds(130,41,150,20);
        add(textField1);

        JLabel passName = new JLabel("Password");
        passName.setBounds(40,90,100,20);
        add(passName);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(130,91,150,20);
        add(passwordField1);

        login = new JButton("Login");
        login.setBounds(40,150,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(170,150,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon person1 = new ImageIcon(ClassLoader.getSystemResource("Public/Person.png"));
        Image person2 = person1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon person3 = new ImageIcon(person2);
        JLabel img = new JLabel(person3);
        img.setBounds(350,20,200,200);
        add(img);

        setSize(600,300);
        setLocation(500,250);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String username = textField1.getText();
            String password = new String(passwordField1.getPassword());

            String query = "SELECT * from login where username = '"+username+"'  and password = '"+password+"'";

            try{
                ConnectDb cdb = new ConnectDb();
                ResultSet set = cdb.statement.executeQuery(query);
                if(set.next()){
                    JOptionPane.showMessageDialog(null,"Login Successful.");
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    passwordField1.setText("");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
