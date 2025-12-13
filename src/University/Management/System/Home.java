package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Home extends JFrame implements ActionListener {
    Home(){
        getContentPane().setBackground(Color.black);

        ImageIcon homeBg1 = new ImageIcon(ClassLoader.getSystemResource("Public/uniBg.jpg"));
        Image homeBg2 = homeBg1.getImage().getScaledInstance(1540,780,Image.SCALE_DEFAULT);
        ImageIcon homeBg3 = new ImageIcon(homeBg2);
        JLabel img = new JLabel(homeBg3);
        add(img);

        JMenuBar mb = new JMenuBar();


        //Add Details
        JMenu newInfo = new JMenu("New ›");
        mb.add(newInfo);

        JMenuItem addFaculty = new JMenuItem("Add Faculty");
        addFaculty.setBackground(Color.white);
        newInfo.add(addFaculty);
        addFaculty.addActionListener(this);

        JMenuItem addStudent = new JMenuItem("Add Student");
        addStudent.setBackground(Color.white);
        newInfo.add(addStudent);
        addStudent.addActionListener(this);

        JMenuItem addLeave = new JMenuItem("Apply Leave");
        addLeave.setBackground(Color.white);
        newInfo.add(addLeave);
        addLeave.addActionListener(this);

        //View Details
        JMenu viewInfo = new JMenu("View ›");
        mb.add(viewInfo);

        JMenuItem viewFaculty = new JMenuItem("View Faculty");
        viewFaculty.setBackground(Color.white);
        viewInfo.add(viewFaculty);
        viewFaculty.addActionListener(this);

        JMenuItem viewStudent = new JMenuItem("View Student");
        viewStudent.setBackground(Color.white);
        viewInfo.add(viewStudent);
        viewStudent.addActionListener(this);

        //Leave Details
        JMenu viewLeave = new JMenu("View Leave");
        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        JMenuItem studentLeave = new JMenuItem("Student Leave");
        viewLeave.setBackground(Color.white);
        facultyLeave.setBackground(Color.white);
        studentLeave.setBackground(Color.white);
        viewInfo.add(viewLeave);
        viewLeave.add(facultyLeave);
        viewLeave.add(studentLeave);
        facultyLeave.addActionListener(this);
        studentLeave.addActionListener(this);

        //Update details
        JMenu updateInfo = new JMenu("Update ›");
        mb.add(updateInfo);

        JMenuItem updateFaculty = new JMenuItem("Update Faculty");
        updateFaculty.setBackground(Color.white);
        updateInfo.add(updateFaculty);
        updateFaculty.addActionListener(this);

        JMenuItem updateStudent = new JMenuItem("Update Student");
        updateStudent.setBackground(Color.white);
        updateInfo.add(updateStudent);
        updateStudent.addActionListener(this);

        //Exams
        JMenu exams = new JMenu("Examinations ›");
        mb.add(exams);

        JMenuItem addResult = new JMenuItem("Add Result");
        addResult.setBackground(Color.white);
        exams.add(addResult);
        addResult.addActionListener(this);

        JMenuItem viewResult = new JMenuItem("View Result");
        viewResult.setBackground(Color.white);
        exams.add(viewResult);
        viewResult.addActionListener(this);

        JMenuItem updateResult = new JMenuItem("Update Result");
        updateResult.setBackground(Color.white);
        exams.add(updateResult);
        updateResult.addActionListener(this);

        //Fees
        JMenu fees = new JMenu("Fees ›");
        mb.add(fees);

        JMenuItem feeForm = new JMenuItem("Student fees form");
        feeForm.setBackground(Color.white);
        fees.add(feeForm);
        feeForm.addActionListener(this);

        JMenuItem feeStructure = new JMenuItem("Fees Structure");
        feeStructure.setBackground(Color.white);
        fees.add(feeStructure);
        feeStructure.addActionListener(this);

        //Utilities
        JMenu utilities = new JMenu("Utilities ›");
        mb.add(utilities);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.white);
        utilities.add(calculator);
        calculator.addActionListener(this);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        utilities.add(notepad);
        notepad.addActionListener(this);

        //Exit
        JMenu exit = new JMenu("Exit");
        mb.add(exit);

        JMenuItem exitApp = new JMenuItem("Exit App");
        exitApp.setBackground(Color.white);
        exit.add(exitApp);
        exitApp.addActionListener(this);


        setJMenuBar(mb);

        setSize(1540,850);
        setLocation(60,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd){
            case "Calculator":
                try {
                    Runtime.getRuntime().exec("calc.exe");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Notepad":
                try {
                    Runtime.getRuntime().exec("notepad.exe");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Exit App":
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
