import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class PassChange implements ActionListener {
    JFrame frame;
    JLabel prnLabel = new JLabel("PRN");
    JLabel passwordLabel = new JLabel("Password");
    JLabel changePassLabel = new JLabel("New Password");
    JLabel Title = new JLabel("Change Your Password If You Don't Remember!");
    JLabel repassLabel = new JLabel("Re-Type New Password");
    JPasswordField passwordField = new JPasswordField();
    JPasswordField changePassField = new JPasswordField();
    JPasswordField rePasswordField = new JPasswordField();
    JTextField prnTextField = new JTextField();
    JButton ChangeButton = new JButton("Change");

    PassChange() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("TPO Details Form");
        frame.setBounds(50, 10, 850, 850);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {
        Title.setBounds(200, 5, 600, 40);
        Title.setBackground(Color.white);
        Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        prnLabel.setBounds(200, 60, 400, 40);
        prnLabel.setBackground(Color.white);
        prnLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        prnTextField.setBounds(200, 110, 400, 40);
        prnTextField.setBackground(Color.white);
        prnTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        passwordLabel.setBounds(200, 160, 400, 40);
        passwordLabel.setBackground(Color.white);
        passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 15));
        passwordField.setBounds(200, 210, 400, 40);
        passwordField.setBackground(Color.white);
        passwordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 19));
        changePassLabel.setBounds(200, 260, 400, 40);
        changePassLabel.setBackground(Color.white);
        changePassLabel.setFont(new Font("Campria", Font.CENTER_BASELINE, 19));
        changePassField.setBounds(200, 310, 400, 40);
        changePassField.setBackground(Color.white);
        changePassField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        repassLabel.setBounds(200, 360, 400, 40);
        repassLabel.setBackground(Color.white);
        repassLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        rePasswordField.setBounds(200, 410, 400, 40);
        rePasswordField.setBackground(Color.white);
        rePasswordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        ChangeButton.setBounds(300, 490, 200, 40);
        ChangeButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    }

    public void addComponentsToFrame() {
        frame.add(prnLabel);
        frame.add(prnTextField);
        frame.add(Title);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(changePassLabel);
        frame.add(changePassField);
        frame.add(repassLabel);
        frame.add(rePasswordField);
        frame.add(ChangeButton);
    }

    public void actionEvent() {
        ChangeButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ChangeButton) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizapp", "root", "viswanathan@38");
                String prn = prnTextField.getText();
                String pass = passwordField.getText();
                String changePass = changePassField.getText();
                String re_pass = rePasswordField.getText();

                if (prn.equals("")) {
                    JOptionPane.showMessageDialog(null, "UserId Is Missing");
                } else if (pass.equals("")) {
                    JOptionPane.showMessageDialog(null, "Password Is Missing");
                } else if (changePass.equals("")) {
                    JOptionPane.showMessageDialog(null, "New Password is Missing");
                } else if (!changePass.equals(re_pass)) {
                    JOptionPane.showMessageDialog(null, "Password Doesn't Match");
                }

                Statement stmt = conn.createStatement();
                String query = "SELECT * FROM user";
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String UserId = rs.getString("PRN");
                    String Password = rs.getString("Password_hash");

                    if (UserId.equals(prn)) {
                        PreparedStatement Pstatement = conn.prepareStatement("update user set Password_hash = ? where PRN = ?");
                        Pstatement.setString(1, changePassField.getText());
                        Pstatement.setString(2, prnTextField.getText());
                        Pstatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Password Updated Successfully");
                    }else{
                        JOptionPane.showMessageDialog(null, "User Does not Exists");
                    }
                }
                frame.setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        PassChange pc = new PassChange();
    }
}
