package sa.edu.kau.fcit.cpit252.project;

import java.time.LocalDateTime;

public class EntertainmentTask implements Task{

    String taskName;
    String description;
    int priority ;
    LocalDateTime dueDate;

    private TaskState currentState;

    public EntertainmentTask(String taskName,String description, int priority,LocalDateTime dueDate){
        this.taskName = taskName;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;

        this.currentState = new Pending();
    }

    public void setState(TaskState state){

        this.currentState = state;

    }

    public TaskState getState(){
        return this.currentState;
    }

    public void updateState(){
        currentState.updateState(this);
    }

    @Override
    public void displayTask() {
        System.out.println("Name: "+taskName);
        System.out.println("Description: " +description);
        System.out.println("Priority: "+ priority);
        System.out.println("dueDate: "+this.dueDate);
        System.out.println();
    }

}
