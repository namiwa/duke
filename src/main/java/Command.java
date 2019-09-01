public abstract class Command {


    public abstract void execute(TaskList task, Ui ui, Storage store);
    public abstract boolean isExit();


}
