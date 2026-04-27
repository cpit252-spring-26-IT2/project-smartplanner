package sa.edu.kau.fcit.cpit252.project;
import java.time.LocalDateTime;
public class FreeTask implements Task{

    String taskName;
    String description;
    int priority ;
    LocalDateTime dueDate;


    public FreeTask(String taskName,String description, int priority, LocalDateTime dueDate){

        this.taskName = taskName;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;

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
