import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz5 implements ActionListener {
    static int count;
    JFrame frame = new JFrame();
    JLabel Title = new JLabel("Quiz Question 5");
    JLabel question3 = new JLabel("5) What is the purpose of the 'super' keyword in Java?");
    JCheckBox answer1 = new JCheckBox("a. To call the superclass constructor");
    JCheckBox answer2 = new JCheckBox("b. To access the superclass's static members");
    JCheckBox answer3 = new JCheckBox("c. To refer to the current object");
    JCheckBox answer4 = new JCheckBox("d. To indicate that a method is overridden");
    JButton submitButton = new JButton("Submit");

    Quiz5(int count) {
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
                answer = "a. To call the superclass constructor";
            }
            if (answer2.isSelected()) {
                answer = "b. To access the superclass's static members";
            }
            if (answer3.isSelected()) {
                answer = "c. To refer to the current object";
            }
            if (answer4.isSelected()) {
                answer = "d. To indicate that a method is overridden";
            }

            if ("a. To call the superclass constructor".equals(answer)) {
                JOptionPane.showMessageDialog(null, "Correct Answer");
                count++;
                JOptionPane.showMessageDialog(null, "Your Score is " + count);
                frame.dispose();
                HomePage h = new HomePage();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Answer");
                JOptionPane.showMessageDialog(null, "Your Score is " + count);
                frame.dispose();
                HomePage h = new HomePage();
            }
        }
    }

    public static void main(String[] args) {
        Quiz5 q5 = new Quiz5(count);
    }
}
