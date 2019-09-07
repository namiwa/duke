package Duke;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    /**
     * Task list where active tasks are stored.
     */
    private List<Task> tasks;

    public TaskList(Storage store) {
        if (store.getFileExits()) {
            tasks = store.readData();
        } else {
            tasks = new ArrayList<>();
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns list of tasks which have the search
     * keyword included in their task name.
     * @param input Parsed keyword of the task name to be searched.
     * @return Returns the taskList where each task contains the search keyword.
     */
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

}
