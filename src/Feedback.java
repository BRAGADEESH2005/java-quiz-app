import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Feedback implements ActionListener {
    JFrame frame;
    JLabel PRNLabel = new JLabel("USERID");
    JLabel Title = new JLabel("Your Feedback Improve Us. Kindly Give your 5 Minutes to Give your Feedback.");
    JTextField PRNTextField = new JTextField();
    JLabel feedback = new JLabel("Feedback");
    JTextArea fd = new JTextArea();
    JButton submitButton = new JButton("Submit");
    JLabel image = new JLabel();
    Icon p;

    Feedback() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Feedback");
        frame.setBounds(50, 10, 1500, 700);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setLocationAndSize() {
       Title.setBounds(100, 50, 800, 40);
Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
Title.setBackground(Color.white);
Title.setForeground(Color.red);

PRNLabel.setBounds(100, 150, 200, 40);
PRNLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
PRNLabel.setBackground(Color.white); // Background color here
PRNLabel.setForeground(Color.red); // Text color here

PRNTextField.setBounds(300, 150, 300, 40);
PRNTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 20));
PRNTextField.setBackground(Color.WHITE);

feedback.setBounds(100, 200, 400, 40);
feedback.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
feedback.setBackground(Color.white); // Background color here
feedback.setForeground(Color.red); // Text color here

fd.setBounds(300, 200, 800, 80);
fd.setFont(new Font("Cambria", Font.CENTER_BASELINE, 20));
fd.setBackground(Color.GRAY);

// Placeholder for actual image path
p = new ImageIcon("path_to_your_image.jpg");

image.setBounds(5, 5, 1254, 836);
image.setIcon(p);
submitButton.setBounds(400, 350, 200, 40);
    }

    public void addComponentsToFrame() {
        frame.add(Title);
        frame.add(PRNLabel);
        frame.add(PRNTextField);
        frame.add(feedback);
        frame.add(fd);
        frame.add(submitButton);
        frame.add(image);
    }

    public void actionEvent() {
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                // Specify your database connection details
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizapp", "root", "viswanathan@38");
                Statement stmt = conn.createStatement();
                String prn = PRNTextField.getText();
                String query = "SELECT * FROM User";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String userId = rs.getString("PRN");

                    if (userId.equals(prn)) {
                        JOptionPane.showMessageDialog(null, "Thank You for your Valued Valuable Feedback!");
                        PreparedStatement Pstatement = conn.prepareStatement("insert into feedback values(?,?)");
                        Pstatement.setString(1, PRNTextField.getText());
                        Pstatement.setString(2, fd.getText());
                        Pstatement.executeUpdate();
                        HomePage h = new HomePage();
                        frame.setVisible(false);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid PRN");
        }
    }
}

class Main9 {
    public static void main(String args[]) {
        Feedback fb = new Feedback();
    }
}
