package Duke;

public class DoneCommand extends Command {

    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    /**
     * Takes in TaskList, Ui and Storage objects which then marks
     * the task index which has been completed.
     * @param tasks TaskList object containing current active taskList.
     * @param ui Ui object containing all output methods to user.
     * @param store Storage object which updates stored data.
     * @throws DukeInvalidIndexException when user has input an index that
     * is not within the current range
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) throws DukeInvalidIndexException {
        if (index - 1 >= tasks.getTasks().size() || index - 1 < 0) {
            throw new DukeInvalidIndexException();
        } else {
            tasks.getTasks().get(index - 1).setTaskDone();
            ui.doneTaskMsg(tasks.getTasks().get(index - 1));
            store.writeData(tasks.getTasks());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
