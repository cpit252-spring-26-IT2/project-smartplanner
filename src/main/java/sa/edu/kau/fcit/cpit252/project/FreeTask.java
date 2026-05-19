package sa.edu.kau.fcit.cpit252.project;
import java.time.LocalDateTime;
public class FreeTask implements Task{

    String taskName;
    String description;
    int priority ;
    LocalDateTime dueDate;

    private TaskState currentState;

    public FreeTask(String taskName,String description, int priority, LocalDateTime dueDate){

        this.taskName = taskName;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;

        this.currentState = new Pending();

    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public TaskState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(TaskState currentState) {
        this.currentState = currentState;
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
