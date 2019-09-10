package Duke.Tasks;

import Duke.Exceptions.DukeInvalidTimeException;
import Duke.Util.DateTimeParser;

import java.time.LocalDateTime;

public class Deadline extends Task {
    private String dateAndTime;
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
            System.out.println(e.getMessage());
        }
        this.dateAndTime = dateAndTime;
    }



    public String writingFile() { return "D" + "|" + super.writingFile() + "|" + dateAndTime; }

    public String toString() {
        return "[D]" + super.toString() + "(by: " + dateAndTime + ")";
    }


}
