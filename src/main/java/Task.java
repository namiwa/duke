class Task {
    private String task;
    private Boolean done;

    Task(String task) {
        this.task = task;
        done = false;
    }

    void setTaskDone() {
        done = true;
    }

    String displayTask() {
        String completed = (done) ? "[✓] " : "[✗] ";
        return completed + task;
    }
 }
