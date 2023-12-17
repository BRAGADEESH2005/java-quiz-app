import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz2 implements ActionListener {
    static int count;
    JFrame frame = new JFrame();
    JLabel Title = new JLabel("Quiz Question 2");
    JLabel question2 = new JLabel("2) Which is the container that doesn't contain a title bar and MenuBars but it can have other components like button, textfield, etc?");
    JCheckBox answer1 = new JCheckBox("a. Window");
    JCheckBox answer2 = new JCheckBox("b. Frame");
    JCheckBox answer3 = new JCheckBox("c. Panel");
    JCheckBox answer4 = new JCheckBox("d. Container");
    JButton submitButton = new JButton("Submit");

    Quiz2(int count) {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
        this.count = count;
    }

    public void createWindow() {
        frame.setTitle("Question 2");
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

        question2.setBounds(50, 60, 1200, 40);
        question2.setBackground(Color.white);
        question2.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));

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
        frame.add(question2);
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
                answer = "a. Window";
            }
            if (answer2.isSelected()) {
                answer = "b. Frame";
            }
            if (answer3.isSelected()) {
                answer = "c. Panel";
            }
            if (answer4.isSelected()) {
                answer = "d. Container";
            }

            if ("c. Panel".equals(answer)) {
                JOptionPane.showMessageDialog(null, "Correct Answer");
                count++;
                Quiz3 q3 = new Quiz3(count); // Uncomment if you have a Quiz3 class
                frame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Answer");
                Quiz3 q3 = new Quiz3(count); // Uncomment if you have a Quiz3 class
                frame.setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        Quiz2 q2 = new Quiz2(count);
    }
}
