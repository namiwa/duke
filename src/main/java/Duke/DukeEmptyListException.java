package Duke;

public class DukeEmptyListException extends DukeException {

    @Override
    public String getMessage() {
        return super.getMessage() + "There are not tasks in the list!";
    }
}
