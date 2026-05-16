package sa.edu.kau.fcit.cpit252.project;

public interface Task {

    void setState(TaskState state);
    TaskState getState();
    void displayTask();

}


