public class DoneCommand extends Command {

    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) {
        tasks.getTasks().get(index).setTaskDone();
        ui.doneTaskMsg(tasks.getTasks().get(index));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
