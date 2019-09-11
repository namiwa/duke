package Duke.Command;

import Duke.Exceptions.DukeException;
import Duke.Util.Storage;
import Duke.Util.TaskList;
import Duke.Util.Ui;

public abstract class Command {

    /**
     * Abstract method to be implemented into specified command classes.
     * @param tasks TaskList object containing current active taskList.
     * @param ui Ui object containing all output methods to user.
     * @param store Storage object which updates stored data.
     * @throws DukeException template to allow specified command methods
     * to throw specified exceptions when errors is encountered.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage store) throws DukeException;

    /**
     * Checks if the command is the exit command.
     * @return true if the command is the exit command.
     */
    public abstract boolean isExit();


}
