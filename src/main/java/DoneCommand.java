public class DoneCommand extends Command {

    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) throws DukeInvalidIndexException {
        if (index - 1 >= tasks.getTasks().size() || index - 1 < 0) {
            throw new DukeInvalidIndexException();
        } else {
            tasks.getTasks().get(index - 1).setTaskDone();
            ui.doneTaskMsg(tasks.getTasks().get(index - 1));
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
