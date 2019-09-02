public class DukeInvalidIndexException extends DukeException {
    @Override
    public String getMessage() {
        return super.getMessage() + "Invalid Index!";
    }
}

