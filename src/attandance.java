import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;

public class attandance extends JFrame {
    private JPanel attandancePanal;
    private JTextField aRollNO;
    private JButton attand;
    private JLabel statusOfStudent;
    private JComboBox statusofstudent;
    private JLabel subjects;
    private JComboBox slectSubject;


    public attandance() {
        attand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String rolNO  = aRollNO.getText();
                String studentStauts = statusofstudent.getSelectedItem().toString();
                String slectedsubject = slectSubject.getSelectedItem().toString();
                int  rolNo1 = Integer.parseInt(rolNO);

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineattandance", "root", "admin@kumar18");
                    System.out.println("connected succesfuly");
                    Statement stmt = conn.createStatement();


                    ResultSet resultSet = stmt.executeQuery("select * from registration");
                    while (resultSet.next()){
                        if(resultSet.getInt("rolNo")== rolNo1 ) {

                            String studentName = resultSet.getString("name");
                            String studentfatherName = resultSet.getString("fatherName");
                            String studentDep = resultSet.getString("department");
                            int studentRollno = resultSet.getInt("rolNo");
                            int studentSam = resultSet.getInt("semester");

                            LocalDate dateof = LocalDate.now();
                            System.out.println(studentName);
                            System.out.println(studentfatherName);
                            System.out.println(studentDep);
                            System.out.println(studentRollno);
                            System.out.println(studentSam);
                            System.out.println(java.time.LocalDate.now());


//                            add new table

                            try {
                                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineattandance", "root", "admin@kumar18");
                                System.out.println("connected succesfuly");
                                Statement statement = connection.createStatement();
                                String updatedata = "INSERT INTO attandancestatus VALUES("+studentRollno+",'"+studentName+"','"+studentfatherName+"','"+studentStauts+"','"+dateof+"','"+studentDep+"','"+slectedsubject    +"')";
                                statement.executeUpdate(updatedata);
                                System.out.println("table insert succesfully");
                            }
                            catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }



                            System.out.println("--------------------------------");
                            System.out.println("Student id " + resultSet.getInt("st_id"));
                            System.out.println("Name of student " + resultSet.getString("name"));
                            System.out.println("father Name of student " + resultSet.getString("fatherName"));
                            System.out.println("Department " + resultSet.getString("department"));
                            System.out.println("Roll no " + resultSet.getInt("rolNo"));
                            System.out.println("Semester " + resultSet.getInt("semester"));
                            System.out.println("--------------------------------");



                        }



                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
      attandance attand = new attandance();
        attand.setContentPane(new attandance().attandancePanal);
        attand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        attand.setVisible(true);
        attand.pack();
    }

}
