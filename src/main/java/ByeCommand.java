public class ByeCommand extends Command {

    @Override
    public void execute(TaskList task, Ui ui, Storage store) {
        store.writeData(task.getTasks());
        ui.goodbyeMsg();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
