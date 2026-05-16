package sa.edu.kau.fcit.cpit252.project;

public class Completed implements TaskState{
    @Override
    public void updateState(Task task) {

        System.out.println("Task is already completed, No further state changes.");
    }

    @Override
    public void editState(Task task) {

    }
}
