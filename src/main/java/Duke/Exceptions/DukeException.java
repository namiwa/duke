package Duke.Exceptions;

import Duke.Duke;

public class DukeException extends Exception {

    @Override
    public String getMessage() {
        return "DukeException: ";
    }
}
