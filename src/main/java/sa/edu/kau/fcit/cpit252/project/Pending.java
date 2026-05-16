package sa.edu.kau.fcit.cpit252.project;

public class Pending implements TaskState{
    @Override
    public void updateState(Task task) {

        task.setState(new InProgress());
    }

    @Override
    public void editState(Task task) {

    }
}
