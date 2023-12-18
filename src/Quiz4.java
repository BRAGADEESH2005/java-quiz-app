import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz4 implements ActionListener {
    static int count;
    JFrame frame = new JFrame();
    JLabel Title = new JLabel("Quiz Question 4");
    JLabel question3 = new JLabel("4)In Java, which keyword is used to implement multiple inheritances of interfaces?");
    JCheckBox answer1 = new JCheckBox("a. extends");
    JCheckBox answer2 = new JCheckBox("b. implements");
    JCheckBox answer3 = new JCheckBox("c. inherits");
    JCheckBox answer4 = new JCheckBox("d. interface");
    JButton submitButton = new JButton("Submit");

    Quiz4(int count) {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
        this.count = count;
    }

    public void createWindow() {
        frame.setTitle("Question 3");
        frame.setBounds(300, 100, 1200, 900);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setLocationAndSize() {
        Title.setBounds(350, 10, 600, 40);
        Title.setBackground(Color.white);
        Title.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));

        question3.setBounds(50, 60, 1200, 40);
        question3.setBackground(Color.white);
        question3.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

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
        frame.add(question3);
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
                answer = "a. extends";
            }
            if (answer2.isSelected()) {
                answer = "b. implements";
            }
            if (answer3.isSelected()) {
                answer = "c. inherits";
            }
            if (answer4.isSelected()) {
                answer = "d. interface";
            }

            if ("b. implements".equals(answer)) {
                JOptionPane.showMessageDialog(null, "Correct Answer");
                count++;
                Quiz5 q5 = new Quiz5(count); // Uncomment if you have a Quiz4 class
                frame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Answer");
                Quiz5 q5 = new Quiz5(count); // Uncomment if you have a Quiz4 class
                frame.setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        Quiz4 q4 = new Quiz4(count);
    }
}
