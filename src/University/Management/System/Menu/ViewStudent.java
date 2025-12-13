package University.Management.System.Menu;

import University.Management.System.ConnectDb;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewStudent extends JFrame implements ActionListener {
    Choice choice;
    JTable table;
    JButton search, addS, update, cancel, print;

    public ViewStudent(){
        getContentPane().setBackground(new Color(210,232,218));

        JLabel heading = new JLabel( "Student Details");
        heading.setBounds(570,35,500, 50);
        heading.setFont(new Font("serif",Font.BOLD,50));
        add(heading);

        JLabel queryHeading = new JLabel( "Search by Roll no.");
        queryHeading.setBounds(1070,150,200, 30);
        queryHeading.setFont(new Font("serif",Font.BOLD,20));
        add(queryHeading);

        choice = new Choice();
        choice.setBounds(1270,158,200, 30);
        add(choice);

        try {
            ConnectDb connect = new ConnectDb();
            ResultSet resultSet = connect.statement.executeQuery("Select * from student");

            while (resultSet.next()) {
                choice.add(resultSet.getString("sId"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            ConnectDb connect = new ConnectDb();
            ResultSet resultSet = connect.statement.executeQuery("Select * from student");

            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(10,200,1510,574);
        add(jScrollPane);

        search = new JButton(">");
        search.setBounds(1460,158,45, 20);
        search.addActionListener(this);
        add(search);

        addS = new JButton("Add");
        addS.setBounds(50,170,100, 20);
        addS.addActionListener(this);
        add(addS);

        print = new JButton("Print");
        print.setBounds(200,170,100, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(350,170,100, 20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(500,170,100, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(1530,784);
        setLocation(67,97);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            String query = "Select * from student where sId='" + choice.getSelectedItem() + "'";
            try {
                ConnectDb connect = new ConnectDb();
                ResultSet resultSet = connect.statement.executeQuery(query);

                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource() == print){
            try {
                table.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == addS) {
            setVisible(false);
            new AddStudent();
        } else if (e.getSource() == update) {
            JOptionPane.showMessageDialog(null, "Still working on this button.");
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewFaculty();
    }
}
