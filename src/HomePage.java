import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class HomePage implements ActionListener {
    static String prn =null;

    JFrame frame;
   JLabel welcome = new JLabel("<html>Welcome to Online Quiz<br>Application that accelerates your learning</html>");
    JMenuBar menuBar=new JMenuBar();
    JMenu menu1=new JMenu("File");
    JMenu menu2=new JMenu("Help");
    JMenu menu3=new JMenu("Feedback");

    JMenuItem menuItem1=new JMenuItem("New User Registration");
    JMenuItem menuItem2=new JMenuItem("Login");
    JMenuItem menuItem3=new JMenuItem("Take Quiz");
    JMenuItem menuItem4=new JMenuItem("Logout");

    JMenuItem menuItem5=new JMenuItem("Change Password");
    JMenuItem menuItem6=new JMenuItem("Give Feedback");

    JTextArea feedbackTextArea = new JTextArea();
    JLabel help = new JLabel();
    ImageIcon quiz;
    JLabel image = new JLabel();


    HomePage() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Online Quiz Application");
        frame.setBounds(150, 10, 1000, 750);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setLocationAndSize(){
        menuBar.setBounds(0, 0, 1200, 30);

        menu1.setBounds(2, 2, 100, 30);
        menu1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        menuItem1.setBounds(2,2,100,40);
        menuItem1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        menuItem2.setBounds(2,8,100,40);
        menuItem2.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        menuItem3.setBounds(2,14,100,40);
        menuItem3.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        menuItem4.setBounds(2,20,100,40);
        menuItem4.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        menu2.setBounds(30, 2, 100, 30);
        menu2.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        menuItem5.setBounds(30,2,100,40);
        menuItem5.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        menu3.setBounds(60, 2, 100, 30);
        menu3.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        menuItem6.setBounds(60,2,100,40);
        menuItem6.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu1.add(menuItem4);

        menu2.add(menuItem5);

        menu3.add(menuItem6);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        welcome.setBounds(250, 120, 800, 90);
        welcome.setBackground(Color.white);
        welcome.setFont(new Font("Cambria", Font.CENTER_BASELINE, 30));
        java.net.URL imgUrl = getClass().getResource("quiz.jpg");

        quiz = new ImageIcon(imgUrl);
        image.setBounds(250, 100, 900, 761);
        image.setIcon(quiz);
    }

    public void addComponentsToFrame() {
        frame.add(menuBar);
        frame.add(welcome);
        frame.add(image);
    }

    public void actionEvent() {
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        menuItem5.addActionListener(this);
        menuItem6.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItem1) {
           Experiment10 e1 = new Experiment10();
        }
        if (e.getSource() == menuItem2) {
            Login l1 = new Login();
        }

        if (e.getSource() == menuItem3) {
    prn = JOptionPane.showInputDialog("Enter your PRN");
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizapp", "root", "viswanathan@38");
        Statement stmt = conn.createStatement();

        String query = "SELECT PRN FROM user";
        ResultSet rs = stmt.executeQuery(query);

        boolean validPRN = false;

        while (rs.next()) {
            String userId = rs.getString("PRN");
            if (userId.equals(prn)) {
                validPRN = true;
                break;
            }
        }

        if (validPRN) {
            JOptionPane.showMessageDialog(null, "All the Best");
            Quiz1 q1 = new Quiz1();
            frame.setVisible(false); // Assuming 'frame' is the correct frame to hide
        } else {
            JOptionPane.showMessageDialog(null, "Invalid PRN");
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        System.out.println(ex);
    }
}
        if(e.getSource() == menuItem4){
        try{
           Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizapp", "root", "viswanathan@38");
              Statement stmt = conn1.createStatement();

              String query = "SELECT PRN FROM login";
                ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                prn = rs.getString("PRN");
                PreparedStatement ps = conn1.prepareStatement("delete from login where PRN ='"+prn+"'");
                ps.execute();
                JOptionPane.showMessageDialog(null, "Logged Out Successfully");
                frame.setVisible(false);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex);
        }

        frame.setVisible(false);
        
    }

    if(e.getSource() == menuItem5){
      PassChange pc = new PassChange();

    }

    if(e.getSource() == menuItem6){
      Feedback fb = new Feedback();
    }


}
public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomePage h1 = new HomePage();
        });
    }
}