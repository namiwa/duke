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

    private List<Task> find(String input) {
        List<Task> temp = new ArrayList<>();
        for (Task hold : tasks) {
            if (hold.getTask().contains(input)) {
                temp.add(hold);
            }
        }
        return temp;
    }

    private void add(Task task) {
        tasks.add(task);
    }

    private void delete(int index) {
        tasks.remove(index - 1);
    }

}
