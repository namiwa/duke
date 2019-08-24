public class Task {
    protected String task;
    protected Boolean done;


    Task(String task) {
        this.task = task;
        done = false;
    }

    void setTaskDone() {
        done = true;
    }


    @Override
    public String toString() {
        String completed = (done) ? "[✓] " : "[✗] ";
        return completed + task;
    }
 }
