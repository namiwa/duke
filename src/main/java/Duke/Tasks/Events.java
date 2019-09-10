package Duke.Tasks;

import Duke.Exceptions.DukeInvalidTimeException;
import Duke.Util.DateTimeParser;

import java.time.LocalDateTime;

public class Events extends Task {
    private String dateAndTime;
    private LocalDateTime dateTime;

    public Events(String... input) {
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


    public String writingFile() {
        return "E" + "|" + super.writingFile() + "|" + dateAndTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + dateAndTime + ")";
    }

}
