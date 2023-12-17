import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login implements ActionListener {

    JFrame frame;
    JLabel PRNLabel, passwordLabel, Title;
    JTextField PRNTextField;
    JPasswordField passwordField;
    JButton loginButton;
    JLabel image;

    public Login() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        addActionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Login Form");
        frame.setBounds(50, 10, 800, 900);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void setLocationAndSize() {
        Title = new JLabel("LOGIN FORM");
        Title.setBounds(300, 30, 300, 30);
        Title.setFont(new Font("Arial", Font.BOLD, 20));
        Title.setForeground(Color.RED);

        PRNLabel = new JLabel("PRN");
        PRNLabel.setBounds(30, 70, 200, 30);
        PRNLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        PRNLabel.setForeground(Color.RED);

        PRNTextField = new JTextField();
        PRNTextField.setBounds(250, 70, 200, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 110, 200, 30);
        passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        passwordLabel.setForeground(Color.RED);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 110, 200, 30);
        passwordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 20));
        passwordField.setBackground(Color.WHITE);

        loginButton = new JButton("Login");
        loginButton.setBounds(30, 150, 200, 30);

        image = new JLabel();
        image.setBounds(300, 200, 200, 200);
        // Assuming 'p' is an ImageIcon
        // image.setIcon(p);
    }

    public void addComponentsToFrame() {
        frame.add(Title);
        frame.add(PRNLabel);
        frame.add(PRNTextField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(image);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == loginButton) {
        try {
            // Add your database connection and authentication logic here
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizapp", "root", "viswanathan@38");
            Statement stmt = conn.createStatement();

            String prn = PRNTextField.getText();
            String pass = new String(passwordField.getPassword());

            String query = "SELECT * FROM User"; // Adjust query as per your table structure

            ResultSet rs = stmt.executeQuery(query);

            boolean userFound = false;

            while (rs.next()) {
                String userId = rs.getString("PRN");
                String password = rs.getString("Password_hash");
                System.out.println(userId + " " + password+"-----"+prn+" "+pass);

                if (userId.equals(prn) && password.equals(pass)) {
                    // Password matched, perform login actions
                    JOptionPane.showMessageDialog(null, "Logged In Successfully");
                    PreparedStatement ps = conn.prepareStatement("insert into login values(?,?)");
                    ps.setString(1, prn);
                    ps.setString(2, pass);
                    ps.executeUpdate();
                    userFound = true;
                    break;  // exit the loop when user is found
                }
            }

            if (userFound) {
                // Open the new frame outside of the loop
                SwingUtilities.invokeLater(() -> {
                    HomePage h = new HomePage();
                    frame.setVisible(false);
                });
            } else {
                // Incorrect credentials
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
        });
    }
}
