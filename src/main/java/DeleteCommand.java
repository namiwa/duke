public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }


    @Override
    public void execute(TaskList task, Ui ui, Storage store) {
        Task temp = task.getTasks().get(index - 1);
        task.getTasks().remove(index- 1);
        ui.deleteMsg(temp);
        store.writeData(task.getTasks());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
