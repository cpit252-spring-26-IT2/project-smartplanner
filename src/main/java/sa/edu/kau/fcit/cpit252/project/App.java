package sa.edu.kau.fcit.cpit252.project;
import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;

/**
 * Hello world!
 */
public class App {
    private static JPanel selectedTaskCard = null;
    private static Task selectedTaskObject = null;

    public static void main(String[] args) {

        try {
            FlatDarkLaf.setup();
            UIManager.put("Button.arc", 25);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        TaskFacade manager = new TaskFacade();


        //System.out.println(LocalDateTime.now().getYear());



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

        // Main App frame   --------------------------------------------------------------------------------------------
        JFrame mainFrame = new JFrame("SmartPlanner");
        mainFrame.setSize(800,600);
        mainFrame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        topPanel.setBackground(new Color(30, 30, 30));

        JButton addTask = new JButton("+");
        addTask.setPreferredSize(new Dimension(60, 25));
        addTask.setBackground(new Color(46, 204, 113));
        addTask.setForeground(Color.WHITE);

        JButton deleteTask = new JButton("-");
        deleteTask.setPreferredSize(new Dimension(60, 25));
        deleteTask.setBackground(new Color(180, 50, 50));
        deleteTask.setForeground(Color.WHITE);

        JButton editTask = new JButton("Edit Task");
        editTask.setPreferredSize(new Dimension(100, 25));
        editTask.setBackground(new Color(15, 128, 255));
        editTask.setForeground(Color.WHITE);

        topPanel.add(editTask);
        topPanel.add(deleteTask);
        topPanel.add(addTask);
        mainFrame.add(topPanel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(350, 0));
        leftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(60, 60, 60)));

        JPanel tasksContainer = new JPanel();
        tasksContainer.setLayout(new BoxLayout(tasksContainer, BoxLayout.Y_AXIS));
        tasksContainer.setBackground(new Color(43, 43, 43));
        tasksContainer.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(tasksContainer);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        leftPanel.add(scrollPane, BorderLayout.CENTER);
        mainFrame.add(leftPanel, BorderLayout.WEST);

        // End of Main App frame ---------------------------------------------------------------------------------------


        // Add Task Button (frame & Logic) -----------------------------------------------------------------------------

        addTask.addActionListener(e -> {
            JFrame newTask = new JFrame("New Task");
            newTask.setSize(600,600);

            String[] taskTypes = {"Study", "Free", "Entertainment"};
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
            create.setBackground(new Color(15, 128, 255));
            create.setForeground(Color.WHITE);

            create.addActionListener(e1 -> {
                newTask.dispose();
            });


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
            newTask.setLocationRelativeTo(null);
            newTask.setLayout(null);
            newTask.setResizable(false);
            newTask.setVisible(true);

            create.addActionListener(e1 -> {
                LocalDateTime date = LocalDateTime.parse(dueDateField.getText(), formatter);
                Task task = TaskFactory.createTask((String)typeComboBox.getSelectedItem(),nameField.getText(),description.getText(),Integer.parseInt(priorityField.getText()),date);

                manager.addTask(task);
                manager.displayTasks();

                JPanel taskCard = new JPanel();
                taskCard.setLayout(new BoxLayout(taskCard, BoxLayout.Y_AXIS));
                taskCard.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(75, 75, 80), 1, true),
                        BorderFactory.createEmptyBorder(12, 12, 12, 12)
                ));
                taskCard.setBackground(new Color(53, 53, 57));
                taskCard.setMaximumSize(new Dimension(320, 140));
                taskCard.setAlignmentX(Component.CENTER_ALIGNMENT);

                JLabel titleLabel = new JLabel(nameField.getText() + " (" + typeComboBox.getSelectedItem() + ")");
                titleLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
                titleLabel.setForeground(new Color(240, 240, 240));
                titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

                JLabel descLabel = new JLabel(description.getText());
                descLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
                descLabel.setForeground(new Color(180, 180, 185));
                descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

                JLabel prioLabel = new JLabel("Priority: " + priorityField.getText());
                prioLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
                prioLabel.setForeground(new Color(241, 196, 15));
                prioLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

                JLabel dateLabel = new JLabel("Due: " + dueDateField.getText());
                dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
                dateLabel.setForeground(new Color(155, 160, 165));
                dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

                taskCard.add(titleLabel);
                taskCard.add(Box.createRigidArea(new Dimension(0, 6)));
                taskCard.add(descLabel);
                taskCard.add(Box.createRigidArea(new Dimension(0, 10)));
                taskCard.add(prioLabel);
                taskCard.add(Box.createRigidArea(new Dimension(0, 4)));
                taskCard.add(dateLabel);

                taskCard.putClientProperty("taskObject", task);
                taskCard.putClientProperty("titleLabel", titleLabel);
                taskCard.putClientProperty("descLabel", descLabel);
                taskCard.putClientProperty("prioLabel", prioLabel);
                taskCard.putClientProperty("dateLabel", dateLabel);

                taskCard.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e2) {
                        if (selectedTaskCard != null) {
                            selectedTaskCard.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(new Color(75, 75, 80), 1, true),
                                    BorderFactory.createEmptyBorder(12, 12, 12, 12)
                            ));
                        }
                        selectedTaskCard = taskCard;
                        selectedTaskObject = task;
                        taskCard.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(15, 128, 255), 2, true),
                                BorderFactory.createEmptyBorder(11, 11, 11, 11)
                        ));
                    }
                });

                tasksContainer.add(taskCard);
                tasksContainer.add(Box.createRigidArea(new Dimension(0, 12)));

                tasksContainer.revalidate();
                tasksContainer.repaint();

            });
        });
        // End of Add Task Button frame & Logic ------------------------------------------------------------------------

        deleteTask.addActionListener(e -> {
            if (selectedTaskCard != null && selectedTaskObject != null) {
                manager.removeTask(selectedTaskObject);
                int index = tasksContainer.getComponentZOrder(selectedTaskCard);
                tasksContainer.remove(selectedTaskCard);
                if (index < tasksContainer.getComponentCount()) {
                    tasksContainer.remove(index);
                }
                selectedTaskCard = null;
                selectedTaskObject = null;
                tasksContainer.revalidate();
                tasksContainer.repaint();
                manager.displayTasks();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Please select a task card first.");
            }
        });

        editTask.addActionListener(e -> {
            if (selectedTaskCard != null && selectedTaskObject != null) {
                JFrame editFrame = new JFrame("Edit Task");
                editFrame.setSize(600, 600);

                JLabel taskNameLabel = new JLabel("Task Name");
                taskNameLabel.setBounds(15, 85, 100, 30);
                JTextField nameField = new JTextField();
                nameField.setBounds(105, 90, 150, 20);

                JLabel descriptionLabel = new JLabel("Description");
                descriptionLabel.setBounds(15, 125, 100, 30);
                JTextField descriptionField = new JTextField(10);
                descriptionField.setBounds(105, 130, 300, 60);

                JLabel priorityLabel = new JLabel("Priority");
                priorityLabel.setBounds(15, 200, 100, 30);
                JTextField priorityField = new JTextField();
                priorityField.setBounds(105, 200, 100, 30);

                JLabel dueDateLabel = new JLabel("Due Date");
                dueDateLabel.setBounds(15, 240, 100, 30);
                JTextField dueDateField = new JTextField();
                dueDateField.setBounds(105, 240, 100, 30);

                JLabel titleLbl = (JLabel) selectedTaskCard.getClientProperty("titleLabel");
                JLabel descLbl = (JLabel) selectedTaskCard.getClientProperty("descLabel");
                JLabel prioLbl = (JLabel) selectedTaskCard.getClientProperty("prioLabel");
                JLabel dateLbl = (JLabel) selectedTaskCard.getClientProperty("dateLabel");

                String fullTitle = titleLbl.getText();
                String currentType = fullTitle.contains(" (") ? fullTitle.substring(fullTitle.lastIndexOf(" (") + 2, fullTitle.length() - 1) : "Study";
                String currentName = fullTitle.contains(" (") ? fullTitle.substring(0, fullTitle.lastIndexOf(" (")) : fullTitle;

                nameField.setText(currentName);
                descriptionField.setText(descLbl.getText());
                priorityField.setText(prioLbl.getText().replace("Priority: ", ""));
                dueDateField.setText(dateLbl.getText().replace("Due: ", ""));

                JButton saveButton = new JButton("Save");
                saveButton.setBounds(450, 500, 100, 30);
                saveButton.setBackground(new Color(15, 128, 255));
                saveButton.setForeground(Color.WHITE);

                saveButton.addActionListener(e1 -> {
                    titleLbl.setText(nameField.getText() + " (" + currentType + ")");
                    descLbl.setText(descriptionField.getText());
                    prioLbl.setText("Priority: " + priorityField.getText());
                    dateLbl.setText("Due: " + dueDateField.getText());

                    editFrame.dispose();
                    tasksContainer.revalidate();
                    tasksContainer.repaint();
                });

                editFrame.add(saveButton);
                editFrame.add(dueDateField);
                editFrame.add(dueDateLabel);
                editFrame.add(priorityField);
                editFrame.add(priorityLabel);
                editFrame.add(descriptionLabel);
                editFrame.add(descriptionField);
                editFrame.add(taskNameLabel);
                editFrame.add(nameField);

                editFrame.setLocationRelativeTo(null);
                editFrame.setLayout(null);
                editFrame.setResizable(false);
                editFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Please select a task card first.");
            }
        });


        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setResizable(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}