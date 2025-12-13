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

public class ViewFaculty extends JFrame implements ActionListener {
    Choice choice;
    JTable table;
    JButton search, addF, update, cancel, print;

    public ViewFaculty(){
        getContentPane().setBackground(new Color(192,164,212));

        JLabel heading = new JLabel( "Faculty Details");
        heading.setBounds(570,35,500, 65);
        heading.setFont(new Font("serif",Font.BOLD,50));
        add(heading);

        JLabel queryHeading = new JLabel( "Search by Employee Id");
        queryHeading.setBounds(1020,150,200, 30);
        queryHeading.setFont(new Font("serif",Font.BOLD,20));
        add(queryHeading);

        choice = new Choice();
        choice.setBounds(1250,158,200, 30);
        add(choice);

        try {
            ConnectDb connect = new ConnectDb();
            ResultSet resultSet = connect.statement.executeQuery("Select * from teacher");

            while (resultSet.next()) {
                choice.add(resultSet.getString("fId"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            ConnectDb connect = new ConnectDb();
            ResultSet resultSet = connect.statement.executeQuery("Select * from teacher");

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

        addF = new JButton("Add");
        addF.setBounds(50,170,100, 20);
        addF.addActionListener(this);
        add(addF);

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
            String query = "Select * from teacher where fId='" + choice.getSelectedItem() + "'";
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
        } else if (e.getSource() == addF) {
            setVisible(false);
            new AddFaculty();
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