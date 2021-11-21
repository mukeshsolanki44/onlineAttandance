import com.company.add_data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class attandanceChacker extends JFrame{
    private JPanel attaPanal;
    private JLabel titalLabal;
    private JLabel rolNoChacker;
    private JTextField txtRollNoCheck;
    private JLabel selectSubject;
    private JComboBox subSelecter;
    private JButton chckButton;

    public attandanceChacker() {
        chckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String srolNO  = txtRollNoCheck.getText();
                String slectedsubject = subSelecter.getSelectedItem().toString();
                int  rolNoStudent = Integer.parseInt(srolNO);
                System.out.println(slectedsubject);


                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineattandance", "root", "admin@kumar18");
                    System.out.println("connected succesfuly");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from attandancestatus");
                    while (resultSet.next()) {
                        String sub = resultSet.getString("slectSubject");
                        System.out.println("====> "+sub);
                        if (sub == slectedsubject) {


                                String studentName = resultSet.getString("SName");
                                String studentSub = resultSet.getString("slectSubject");
                                System.out.println(studentName);
                                System.out.println(studentSub);
                                                  }

                    }

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }









//                end
                JOptionPane.showMessageDialog(null,"subminted");
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("add_data");
        frame.setContentPane(new attandanceChacker().attaPanal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
