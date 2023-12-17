import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Experiment10 implements ActionListener {
    JFrame frame;
    JLabel Title = new JLabel("Registration Form");
    JLabel prnLabel = new JLabel("PRN");
    JLabel nameLabel = new JLabel("UserName");
    JLabel addressLabel = new JLabel("Address");
    JLabel emailLabel = new JLabel("Email");
    JLabel contactLabel = new JLabel("Contact No");
    JLabel classLabel = new JLabel("Class");
    JLabel passwordLabel = new JLabel("Password");
    JLabel branchLabel = new JLabel("Branch");
    JTextField prnTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField contactTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextArea addressTextArea = new JTextArea();
    JPasswordField passwordField = new JPasswordField();
    String[] branch = {"CSIT", "CSE", "ETC", "Electrical", "Mechanical", "Civil", "Automobile", "Mechatronics"};
    String[] Class = {"FY", "SY", "TY", "Final"};
    JComboBox<String> className = new JComboBox<>(Class);
    JComboBox<String> branchname = new JComboBox<>(branch);
    JButton SubmitButton = new JButton("Submit");
    JButton ResetButton = new JButton("Reset");
    JScrollPane scrollPane;

    Experiment10() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Student Details Form");
        frame.setBounds(50, 10, 1000, 500);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setLocationAndSize() {
        Title.setBounds(300, 2, 400, 40);
        Title.setBackground(Color.white);
        Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
        prnLabel.setBounds(300, 50, 400, 40);
        prnLabel.setBackground(Color.white);
        prnLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        prnTextField.setBounds(300, 100, 400, 40);
        prnTextField.setBackground(Color.white);
        prnTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 15));
        nameLabel.setBounds(300, 150, 400, 40);
        nameLabel.setBackground(Color.white);
        nameLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 16));
        nameTextField.setBounds(300, 200, 400, 40);
        nameTextField.setBackground(Color.white);
        nameTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        emailLabel.setBounds(300, 250, 400, 40);
        emailLabel.setBackground(Color.white);
        emailLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        emailTextField.setBounds(300, 300, 400, 40);
        emailTextField.setBackground(Color.white);
        emailTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        passwordLabel.setBounds(300, 350, 400, 40);
        passwordLabel.setBackground(Color.white);
        passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 10));
        passwordField.setBounds(300, 400, 400, 40);
        passwordField.setBackground(Color.white);
        passwordField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 10));
        classLabel.setBounds(300, 450, 400, 40);
        classLabel.setBackground(Color.white);
        classLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        className.setBounds(300, 500, 400, 40);
        className.setBackground(Color.white);
        className.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        branchLabel.setBounds(300, 550, 400, 40);
        branchLabel.setBackground(Color.white);
        branchLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        branchname.setBounds(300, 600, 400, 40);
        branchname.setBackground(Color.white);
        branchname.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        contactLabel.setBounds(300, 650, 400, 40);
        contactLabel.setBackground(Color.white);
        contactLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 10));
        contactTextField.setBounds(300, 700, 400, 40);
        contactTextField.setBackground(Color.white);
        contactTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        SubmitButton.setBounds(300, 750, 100, 40);
        SubmitButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
        ResetButton.setBounds(430, 750, 100, 40);
        ResetButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    }

    public void addComponentsToFrame() {
        frame.add(Title);
        frame.add(prnLabel);
        frame.add(prnTextField);
        frame.add(nameLabel);
        frame.add(nameTextField);
        frame.add(emailLabel);
        frame.add(emailTextField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(branchLabel);
        frame.add(branchname);
        frame.add(contactLabel);
        frame.add(contactTextField);
        frame.add(SubmitButton);
        frame.add(ResetButton);
        frame.add(classLabel);
        frame.add(className);
    }

    public void actionEvent() {
        SubmitButton.addActionListener(this);
        ResetButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SubmitButton) {
            try {
                // Creating Connection Object
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizapp", "root", "viswanathan@38");

                // Prepared Statement
                PreparedStatement Pstatement = conn.prepareStatement("insert into User values (?, ?, ?, ?, ?, ?, ?)");

                // Specifying the values of its parameter
                Pstatement.setString(1, prnTextField.getText());
                Pstatement.setString(4, nameTextField.getText());
                Pstatement.setString(2, emailTextField.getText());
                Pstatement.setString(6, passwordField.getText());
                Pstatement.setString(7, className.getSelectedItem().toString());
                Pstatement.setString(5, branchname.getSelectedItem().toString());
                Pstatement.setString(3, contactTextField.getText());
               

                // Checking for the Password match
                String prn = prnTextField.getText();
                String pass = passwordField.getText();
                String email = emailTextField.getText();

                if (prn.equals("")) {
                    JOptionPane.showMessageDialog(null, "PRN is Missing");
                } else if (pass.equals("")) {
                    JOptionPane.showMessageDialog(null, "Password is Missing");
                } else if (email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Email is Missing");
                } else {
                    // Executing query
                    System.out.println("hello"+ pass);
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "User Registered Successfully");
                    frame.setVisible(false);
                }
            } catch (SQLException el) {
                el.printStackTrace();
            }
        }

        if (e.getSource() == ResetButton) {
            prnTextField.setText("");
            nameTextField.setText("");
            addressTextArea.setText("");
            contactTextField.setText("");
            className.setSelectedItem("");
            branchname.setSelectedItem("");
            passwordField.setText("");
            emailTextField.setText("");
        }
    }
}

class Main {
    public static void main(String args[]) {
        Experiment10 e = new Experiment10();
    }
}
