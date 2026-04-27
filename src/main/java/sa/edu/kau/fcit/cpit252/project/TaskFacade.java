package sa.edu.kau.fcit.cpit252.project;

import java.time.LocalDateTime;

public class TaskFacade  {

    private TaskManager manager;


    public TaskFacade (){
        this.manager = new TaskManager();
    }

    public void addTask(Task task){
        manager.addTask(task);
    }

    public void removeTask(Task task){
        manager.removeTask(task);
    }

    public void displayTasks(){
        manager.displayAllTasks();
    }

    public void editTask(Task t ,String newType, String newName, String newDescription, int newPriority, LocalDateTime newDueDate){
        manager.editTask();
    }

}
