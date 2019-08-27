public class Task {
    private String task;
    private Boolean done;


    Task(String task) {
        this.task = task;
        done = false;
    }

    void setTaskDone() {
        done = true;
    }

    public boolean getDone() {
        return done;
    }

    public String writingFile() {
        return task + "|" + (getDone() ? "1" : "0");
    }

    @Override
    public String toString() {
        String completed = (done) ? "[✓] " : "[✗] ";
        return completed + task;
    }
 }
