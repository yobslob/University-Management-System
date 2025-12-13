package University.Management.System.Menu;

import University.Management.System.ConnectDb;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {
    JTextField textName, textParent,textAdd, textPhone, textEmail;
    Font inputFont = new Font("serif", Font.PLAIN, 20);

    JLabel fIdValue;
    Random rd = new Random();
    long f4 = Math.abs((rd.nextLong() % 9000L) + 1000L);

    JDateChooser calender;
    JComboBox courseBox, departmentBox;
    JButton submit,cancel;

    public AddFaculty(){
        getContentPane().setBackground(new Color(146,142,202));

        JLabel heading = new JLabel( "New Teacher Details");
        heading.setBounds(570,35,500, 50);
        heading.setFont(new Font("serif",Font.BOLD,50));
        add(heading);

        JLabel fId = new JLabel("Faculty Id: ");
        fId.setBounds(850,94,100,30);
        fId.setFont(new Font("serif",Font.BOLD,20));
        add(fId);

        fIdValue = new JLabel("25"+f4);
        fIdValue.setBounds(952,94,100,30);
        fIdValue.setFont(inputFont);
        add(fIdValue);

        JLabel fName = new JLabel("Faculty Name: ");
        fName.setBounds(170,250,350,40);
        fName.setFont(new Font("serif",Font.BOLD,30));
        add(fName);

        textName = new JTextField();
        textName.setBounds(400,252,300,40);
        textName.setFont(inputFont);
        add(textName);

        JLabel fpName = new JLabel("Parent name: ");
        fpName.setBounds(170,350,350,35);
        fpName.setFont(new Font("serif",Font.BOLD,30));
        add(fpName);

        textParent = new JTextField();
        textParent.setBounds(400,352,300,40);
        textParent.setFont(inputFont);
        add(textParent);

        JLabel fEmail = new JLabel("Email: ");
        fEmail.setBounds(170,450,350,35);
        fEmail.setFont(new Font("serif",Font.BOLD,30));
        add(fEmail);

        textEmail = new JTextField();
        textEmail.setBounds(400,452,300,35);
        textEmail.setFont(inputFont);
        add(textEmail);

        JLabel fAdd = new JLabel("Address: ");
        fAdd.setBounds(950,250,350,35);
        fAdd.setFont(new Font("serif",Font.BOLD,30));
        add(fAdd);

        textAdd = new JTextField();
        textAdd.setBounds(1100,252,300,40);
        textAdd.setFont(inputFont);
        add(textAdd);

        JLabel fPhone = new JLabel("Phone no: ");
        fPhone.setBounds(950,350,350,35);
        fPhone.setFont(new Font("serif",Font.BOLD,30));
        add(fPhone);

        textPhone = new JTextField();
        textPhone.setBounds(1100,352,300,40);
        textPhone.setFont(inputFont);

        textPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || textPhone.getText().length() >= 10) {
                    e.consume();
                }
            }
        });

        add(textPhone);

        JLabel fDob = new JLabel("D.O.B. : ");
        fDob.setBounds(950,450,350,35);
        fDob.setFont(new Font("serif",Font.BOLD,30));
        add(fDob);

        calender = new JDateChooser();
        calender.setBounds(1100,452,300,40);
        calender.setFont(inputFont);
        add(calender);

        JLabel fProg = new JLabel("Programme: ");
        fProg.setBounds(170,550,350,40);
        fProg.setFont(new Font("serif",Font.BOLD,30));
        add(fProg);

        String[] courses = {"BTech","BArch","BDes","BBA","BCom","MTech","MArch","MDes","MBA","MCom"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(400,552,300,35);
        add(courseBox);

        JLabel fDept = new JLabel("Dept: ");
        fDept.setBounds(950,550,350,40);
        fDept.setFont(new Font("serif",Font.BOLD,30));
        add(fDept);

        String[] departments = {"AI-DS","AI-ML","IIOT","AR","Arch","Industrial Des.","Graphic Des.","Accounts","Psychology","Finance"};
        departmentBox = new JComboBox<>(departments);
        departmentBox.setBounds(1100,552,300,40);
        add(departmentBox);

        submit = new JButton("Submit");
        submit.setBounds(400,680,300,40);
        submit.addActionListener(this);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(900,680,300,40);
        cancel.addActionListener(this);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        add(cancel);

        setSize(1530,784);
        setLocation(67,97);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String name = textName.getText();
            String pName = textParent.getText();
            String email = textEmail.getText();
            String address = textAdd.getText();
            String phone = textPhone.getText();
            String fId = fIdValue.getText();
            String dob = ((JTextField) calender.getDateEditor().getUiComponent()).getText();
            String course = (String) courseBox.getSelectedItem();
            String dept = (String) departmentBox.getSelectedItem();
            if (name.isEmpty() || pName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name fields cannot be empty");
                return;
            }
            try{
                String query = "insert into teacher values ('"+name+"','"+pName+"','"+email+"','"+address+"','"+phone+"','"+fId+"','"+dob+"','"+course+"','"+dept+"')";
                ConnectDb connect = new ConnectDb();
                connect.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"New Faculty Created: "+name);
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddFaculty();
    }
}