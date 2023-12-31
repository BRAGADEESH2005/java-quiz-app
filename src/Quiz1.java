import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz1 implements ActionListener {
    static int count;
    JFrame frame = new JFrame();
    JLabel Title = new JLabel("Quiz Question 1");
    JLabel question1 = new JLabel("1) What is the correct way to declare a constant variable in Java?");
    JCheckBox answer1 = new JCheckBox("a. final int constantVar = 10;");
    JCheckBox answer2 = new JCheckBox("b. const int constantVar = 10;");
    JCheckBox answer3 = new JCheckBox("c. static final int constantVar = 10;");
    JCheckBox answer4 = new JCheckBox("d. final static int constantVar = 10;");
    JButton submitButton = new JButton("Submit");

    Quiz1() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame.setTitle("Question 1");
        frame.setBounds(300, 100, 1200, 900);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setLocationAndSize() {
        Title.setBounds(350, 10, 600, 40);
        Title.setBackground(Color.white);
        Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));

        question1.setBounds(50, 60, 1200, 40);
        question1.setBackground(Color.white);
        question1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        answer1.setBounds(50, 130, 400, 40);
        answer1.setBackground(Color.white);
        answer1.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        answer2.setBounds(50, 180, 400, 40);
        answer2.setBackground(Color.white);
        answer2.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        answer3.setBounds(50, 230, 400, 40);
        answer3.setBackground(Color.white);
        answer3.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        answer4.setBounds(50, 280, 400, 40);
        answer4.setBackground(Color.white);
        answer4.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

        submitButton.setBounds(50, 330, 100, 40);
        submitButton.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
    }

    public void addComponentsToFrame() {
        frame.add(Title);
        frame.add(question1);
        frame.add(answer1);
        frame.add(answer2);
        frame.add(answer3);
        frame.add(answer4);
        frame.add(submitButton);
    }

    public void actionEvent() {
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String answer = null;
            if (answer1.isSelected()) {
                answer = "a. final int constantVar = 10;";
            }
            if (answer2.isSelected()) {
                answer = "b. const int constantVar = 10;";
            }
            if (answer3.isSelected()) {
                answer = "c. static final int constantVar = 10;";
            }
            if (answer4.isSelected()) {
                answer = "d. final static int constantVar = 10;";
            }

            if ("c. static final int constantVar = 10;".equals(answer)) { // Use .equals() for string comparison
                JOptionPane.showMessageDialog(null, "Correct Answer");
                count++;
                Quiz2 q2 = new Quiz2(count); // Uncomment if you have a Quiz2 class
                frame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Answer");
                Quiz2 q2 = new Quiz2(count); // Uncomment if you have a Quiz2 class
                frame.setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        Quiz1 q1 = new Quiz1();
    }
}
