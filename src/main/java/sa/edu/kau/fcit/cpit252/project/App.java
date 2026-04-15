package sa.edu.kau.fcit.cpit252.project;
import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        //Task task1 = TaskFactory.createTask("Study","cpit252","solve Lab3 Factory Method",3,LocalDateTime.of(2023,3,4,12,30));
        //Task task2 = TaskFactory.createTask("Break","FreeTime","3-4hours free",4,LocalDateTime.of(2026,3,4,1,4));
        //Task task3 = TaskFactory.createTask("Entertainment","Gaming","Beat The Boss",1,LocalDateTime.of(2025,3,4,4,6));
        TaskManager manager = new TaskManager();
        //TaskManager manager = new TaskManager();
        //manager.addTask(task1);
        //manager.addTask(task2);
        //manager.addTask(task3);

        System.out.println(LocalDateTime.now().getYear());

        //manager.displayAllTasks();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        // Main App frame
        JFrame mainFrame = new JFrame("SmartPlanner");
        mainFrame.setSize(800,600);

        JButton addTask = new JButton("+");
        addTask.setBounds(1340,20,60,20);

        JButton deleteTask = new JButton("-");
        deleteTask.setBounds(1260,20,60,20);

        JButton editTask = new JButton("Edit Task");
        editTask.setBounds(1150,20,80,20);

        addTask.addActionListener(e -> {
            JFrame newTask = new JFrame("New Task");
            newTask.setSize(600,600);

            String[] taskTypes = {"Study", "Break", "Entertainment"};
            JComboBox<String> typeComboBox = new JComboBox<>(taskTypes);
            typeComboBox.setBounds(105, 50, 150, 25);
            String selectedType = (String) typeComboBox.getSelectedItem();
            JLabel taskType = new JLabel("Task Type");
            taskType.setBounds(15,45,100,30);

            JTextField description = new JTextField(10);
            description.setBounds(105,130,300,60);

            JLabel taskName = new JLabel("Task Name");
            taskName.setBounds(15,85,100,30);

            JTextField nameField = new JTextField();
            nameField.setBounds(105,90,150,20);

            JLabel descriptionLabel = new JLabel("Description");
            descriptionLabel.setBounds(15,125,100,30);

            JLabel priority = new JLabel("Priority");
            priority.setBounds(15,200,100,30);

            JTextField priorityField = new JTextField();
            priorityField.setBounds(105,200,100,30);

            JLabel dueDate = new JLabel("Due Date");
            dueDate.setBounds(15,240,100,30);

            JTextField dueDateField = new JTextField();
            dueDateField.setBounds(105,240,100,30);

            JButton create = new JButton("Create");
            create.setBounds(450,500,100,30);



            newTask.add(create);
            newTask.add(dueDateField);
            newTask.add(dueDate);
            newTask.add(priorityField);
            newTask.add(priority);
            newTask.add(taskType);
            newTask.add(typeComboBox);
            newTask.add(descriptionLabel);
            newTask.add(taskName);
            newTask.add(nameField);
            newTask.add(description);
            newTask.setLayout(null);
            newTask.setResizable(false);
            newTask.setVisible(true);

            create.addActionListener(e1 -> {
                LocalDateTime date = LocalDateTime.parse(dueDateField.getText(), formatter);
                Task task = TaskFactory.createTask((String)typeComboBox.getSelectedItem(),nameField.getText(),description.getText(),Integer.parseInt(priorityField.getText()),date);

                manager.addTask(task);
                manager.displayAllTasks();

            });
        });

        mainFrame.add(addTask);
        mainFrame.add(deleteTask);
        mainFrame.add(editTask);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setResizable(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
