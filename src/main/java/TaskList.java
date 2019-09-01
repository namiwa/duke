import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList(Storage store) {
        if (store.getFileExits()) {
            tasks = store.readData();
        } else {
            tasks = new ArrayList<>();
        }
    }

    public List<Task> find(String input) {
        List<Task> temp = new ArrayList<>();
        for (Task hold : tasks) {
            if (hold.getTask().contains(input)) {
                temp.add(hold);
            }
        }
        return temp;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void delete(int index) {
        tasks.remove(index - 1);
    }

    public int getSize() {
        return tasks.size();
    }

    public Task getLastTask() {
        return tasks.get(tasks.size() - 1);
    }

}
