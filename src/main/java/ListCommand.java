public class ListCommand extends Command {

    private boolean isEmpty;

    public ListCommand() {

    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) {
        isEmpty = tasks.getTasks().isEmpty();
        if (!isEmpty) {
            ui.printTaskList(tasks.getTasks());
        } else {
            ui.tryAgainListSize();
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
