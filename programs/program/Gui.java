package programs.program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame {
public static void main(String[] args) {
    
    TaskManager taskManager;
    JTextField nameField;
    JComboBox<String> statusBox;
    JCheckBox importantBox;
    JTextArea taskDisplayArea;
    JTextField deleteField;

    public void TaskManagerGUI() {
        TaskManager taskmanager = new TaskManager();

        setTitle("Task Manager GUI");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        nameField = new JTextField();
        statusBox = new JComboBox<>(new String[]{"Pending", "In Progress", "Completed"});
        importantBox = new JCheckBox("Important");

        inputPanel.add(new JLabel("Task Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(statusBox);
        inputPanel.add(new JLabel("Important:"));
        inputPanel.add(importantBox);

        JButton addButton = new JButton("Add Task");
        inputPanel.add(addButton);

        
        taskDisplayArea = new JTextArea();
        taskDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taskDisplayArea);

        
        JPanel deletePanel = new JPanel(new FlowLayout());
        deleteField = new JTextField(15);
        JButton deleteButton = new JButton("Delete Task");
        deletePanel.add(new JLabel("Task Name to Delete:"));
        deletePanel.add(deleteField);
        deletePanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(deletePanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String status = (String) statusBox.getSelectedItem();
            boolean important = importantBox.isSelected();

            if (!name.isEmpty()) {
                taskManager.tasks.add(new Task(name, status, important));
                updateTaskDisplay();
                nameField.setText("");
                importantBox.setSelected(false);
            } else {
                JOptionPane.showMessageDialog(this, "Task name cannot be empty.");
            }
        });

        deleteButton.addActionListener(e -> {
            String nameToDelete = deleteField.getText().trim();
            if (!nameToDelete.isEmpty()) {
                boolean removed = taskManager.tasks.removeIf(task -> task.getName().equalsIgnoreCase(nameToDelete));
                if (removed) {
                    JOptionPane.showMessageDialog(this, "Task deleted.");
                } else {
                    JOptionPane.showMessageDialog(this, "Task not found.");
                }
                updateTaskDisplay();
                deleteField.setText("");
            }
        });

        updateTaskDisplay();
    }

    private void updateTaskDisplay() {
        StringBuilder sb = new StringBuilder();
        for (Task task : taskManager.tasks) {
            sb.append("Name: ").append(task.getName()).append("\n");
            sb.append("Status: ").append(task.getStatus()).append("\n");
            sb.append("Important: ").append(task.getimportant()).append("\n");
            sb.append("-----------------------------\n");
        }
        taskDisplayArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Gui().setVisible(true));
    }
}
}