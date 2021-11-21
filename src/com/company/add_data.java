package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class add_data {
    private JPanel mainPanal;
    private JButton addDataButton;
    public JTextField txtname;
    private JLabel namefeild;
    private JTextField txtFather;
    private JLabel labFather;
    private JTextField txtRollno;
    private JLabel Rollno;
    private JTextField txtDepartment;
    private JLabel samster;
    private JTextField txtSem;
    private JLabel titalmain;

    public add_data() {
        addDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = txtname.getText();
                String fatherName = txtFather.getText();
                String rolNo = txtRollno.getText();
                String department = txtDepartment.getText();
                String semester = txtSem.getText();
//                 int  rolNo1 = Integer.parseInt(rolNo);
//                  int semester2 = Integer.parseInt(semester);



                JOptionPane.showMessageDialog(null,name + " "+ fatherName+" "+ rolNo +" "+ department +" "+semester);
                JOptionPane.showMessageDialog(null,"subminted");

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineattandance", "root", "admin@kumar18");
                    System.out.println("connected succesfuly");
                    Statement stmt = conn.createStatement();
                    String muk = "INSERT INTO registration(st_id,name,fatherName,department,rolNo,semester) VALUES(null,'"+name+"','"+fatherName+"','"+department+"',"+rolNo+","+semester+")";
                    stmt.executeUpdate(muk);
                    System.out.println("table insert succesfully");
//                    ResultSet resultSet = stmt.executeQuery("select * from student_data");
//                    while (resultSet.next()){
//                        System.out.println("--------------------------------");
//
//                        System.out.println("--------------------------------");
//
//                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("add_data");
        frame.setContentPane(new add_data().mainPanal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
