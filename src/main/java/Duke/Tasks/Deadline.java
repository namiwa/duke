package Duke.Tasks;

import Duke.Exceptions.DukeInvalidTimeException;
import Duke.Util.DateTimeParser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDateTime dateTime;

    public Deadline(String... input) {
        super(input[0]);
        dateTime = null;
        setDateAndTime(input[input.length - 1]);
    }

    private void setDateAndTime(String dateAndTime) {
        try {
            dateTime = DateTimeParser.getStringToDate(dateAndTime);
        } catch (DukeInvalidTimeException e) {
            System.out.println(e.getMessage() + " " + dateAndTime + getTask());
        }
    }

    public String writingFile() { return "D" + "|" + super.writingFile() +
            "|" + dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy [HH:mm]")); }

    public String toString() {
        return "[D]" + super.toString() +
                "(by: " + dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy [HH:mm]")) + ")";
    }


}
