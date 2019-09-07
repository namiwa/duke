package Duke.Command;
import Duke.Exceptions.DukeEmptyListException;
import Duke.Tasks.Task;
import Duke.Util.Storage;
import Duke.Util.TaskList;
import Duke.Util.Ui;

import java.util.List;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Takes in TaskList, Ui and Storage objects which then displays
     * the active TaskList which contains the task names the user inputs.
     * @param tasks TaskList object containing current active taskList.
     * @param ui Ui object containing all output methods to user.
     * @param store Storage object which updates stored data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) throws DukeEmptyListException {
        if (tasks.getTasks().size() == 0) {
            throw new DukeEmptyListException();
        }
        List<Task> temp = tasks.find(keyword);
        ui.findMsg(temp);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
