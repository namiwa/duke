package Duke;

public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Takes in ui, tasks and store objects, and removes the tasks
     * based on the parsed user input.
     * @param tasks TaskList object containing current active tasks
     * @param ui Ui object containing all the methods to output to user
     * @param store Storage object which updates stored data.
     * @throws DukeInvalidIndexException when user has input an index that
     * is not within the current range
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) throws DukeInvalidIndexException {
        if (index - 1 < 0 || index - 1 >= tasks.getTasks().size()) {
            throw new DukeInvalidIndexException();
        } else {
            Task temp = tasks.getTasks().get(index - 1);
            tasks.delete(index - 1);
            ui.deleteMsg(temp);
            store.writeData(tasks.getTasks());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
