package programs.program;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Gui extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskNameField;
    private JTextArea taskDescArea;

    public void TaskManagerGUI() {
        setTitle("Task Management System");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);

        taskNameField = new JTextField(20);
        taskDescArea = new JTextArea(3, 20);
        taskDescArea.setLineWrap(true);
        taskDescArea.setWrapStyleWord(true);

        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Selected");

        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());

        JPanel inputPanel = new JPanel(new GridLayout(5, 1));
        inputPanel.add(new JLabel("Task Name:"));
        inputPanel.add(taskNameField);
        inputPanel.add(new JLabel("Task Description:"));
        inputPanel.add(new JScrollPane(taskDescArea));
        inputPanel.add(addButton);

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        listPanel.add(deleteButton, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);
    }

    private void addTask() {
        String name = taskNameField.getText().trim();
        String desc = taskDescArea.getText().trim();
        if (!name.isEmpty()) {
            taskListModel.addElement(name + " - " + desc);
            taskNameField.setText("");
            taskDescArea.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Task name cannot be empty.");
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Gui().setVisible(true));
    }
}
   