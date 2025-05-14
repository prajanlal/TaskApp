package java;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(450, 450);
        frame.setTitle("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        frame.setVisible(true);

        frame.setLayout(null);

        JTextField textfield = new JTextField();
        textfield.setBounds(20, 30, 400, 300);
        panel.add(textfield);
    }
}
