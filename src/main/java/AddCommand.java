public class AddCommand extends Command {

    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) {
        tasks.add(task);
        ui.addedTaskMsg();
        tasks.getLastTask();
        ui.currentTaskListSizeMsg(tasks.getSize());
        store.writeData(tasks.getTasks());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
