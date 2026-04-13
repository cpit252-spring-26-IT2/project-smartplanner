package sa.edu.kau.fcit.cpit252.project;

import java.time.LocalDateTime;

public class TaskFactory {

    public static Task createTask(String taskType, String taskName, String description, int priority, LocalDateTime dueDate){

        if(taskType.equalsIgnoreCase("Entertainment")){
            return new EntertainmentTask(taskName,description,priority,dueDate);
        }
        if(taskType.equalsIgnoreCase("Study")){
            return new StudyTask(taskName,description,priority,dueDate);
        }
        if(taskType.equalsIgnoreCase("Break")){
            return new BreakTask(taskName,description,priority,dueDate);
        }
        return null;

    }
}
