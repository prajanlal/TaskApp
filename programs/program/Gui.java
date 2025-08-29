package programs.program;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui {
    public static void main(String[] args) {
      JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,550);
        frame.setVisible(true);
        
        JPanel panel = new JPanel();
        panel.setBounds(20, 020, 040, 0150);
        

        JTextField textField = new JTextField();
        textField.setBounds(20, 40, 50, 50);
        panel.add(textfield);
    }
}

