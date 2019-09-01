import java.util.List;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage store) {
        List<Task> temp = tasks.find(keyword);
        ui.findMsg(temp);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
