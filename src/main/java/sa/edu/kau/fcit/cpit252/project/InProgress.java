package sa.edu.kau.fcit.cpit252.project;

public class InProgress implements TaskState{
    @Override
    public void updateState(Task task) {

        task.setState(new Completed());
    }

    @Override
    public void editState(Task task) {

    }
}
