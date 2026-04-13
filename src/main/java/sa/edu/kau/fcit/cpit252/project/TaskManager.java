package sa.edu.kau.fcit.cpit252.project;

import java.util.ArrayList;
import java.util.List;

public class TaskManager
{
    List<Task> Tasks = new ArrayList<>();

    public void addTask(Task t){
        Tasks.add(t);
    }

    public void removeTask(Task t){
        Tasks.remove(t);
    }

    public void editTask(){

    }

    public void displayAllTasks(){

        for(Task t: Tasks){
            t.displayTask();
        }
    }
}
