package sa.edu.kau.fcit.cpit252.project;
import java.time.LocalDateTime;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Task task1 = TaskFactory.createTask("Study","cpit252","solve Lab3 Factory Method",3,LocalDateTime.of(2023,3,4,12,30));
        Task task2 = TaskFactory.createTask("Break","FreeTime","3-4hours free",4,LocalDateTime.of(2026,3,4,1,4));
        Task task3 = TaskFactory.createTask("Entertainment","Gaming","Beat The Boss",1,LocalDateTime.of(2025,3,4,4,6));

        TaskManager manager = new TaskManager();
        manager.addTask(task1);
        manager.addTask(task2);
        manager.addTask(task3);

        manager.displayAllTasks();

    }
}
