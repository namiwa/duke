public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }


    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) throws DukeInvalidIndexException {
        if (index - 1 < 0 || index - 1 >= tasks.getTasks().size()) {
            throw new DukeInvalidIndexException();
        } else {
            Task temp = tasks.getTasks().get(index - 1);
            tasks.getTasks().remove(index - 1);
            ui.deleteMsg(temp);
            store.writeData(tasks.getTasks());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
