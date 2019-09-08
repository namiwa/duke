package Duke.Tasks;

public class Task {
    /**
     * Task is the string value of the task name.
     * Done is the active status of the task.
     */
    private String task;
    private Boolean done;

    public Task(String task) {
        this.task = task;
        done = false;
    }

    public void setTaskDone() {
        done = true;
    }

    public String getTask() {
        return task;
    }

    private boolean getDone() {
        return done;
    }

    /**
     * Function to be used to when writing to the file.
     * @return Returns a string containing task name and done status.
     */
    public String writingFile() {
        return task + "|" + (getDone() ? "1" : "0");
    }

    @Override
    public String toString() {
        String completed = (done) ? "[✓] " : "[✗] ";
        return completed + task;
    }
 }
