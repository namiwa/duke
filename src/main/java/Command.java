public abstract class Command {


    public abstract void execute(TaskList tasks, Ui ui, Storage store) throws DukeException;
    public abstract boolean isExit();


}
