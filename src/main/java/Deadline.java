import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private String dateAndTime;
    private LocalDate date;

    Deadline(String... input) {
        super(input[0]);
        setDateAndTime(input[input.length - 1]);
    }

    private void setDateAndTime(String dateAndTime) {
        if (dateAndTime.contains("/")) {
            setStringToDate(dateAndTime);
        }
        this.dateAndTime = dateAndTime;
    }

    private void setStringToDate(String dateAndTime) {
        String[] split = dateAndTime.split(" ");
        date = LocalDate.parse(split[0], DateTimeFormatter.ofPattern("d/MM/yyyy"));
    }

    public String writingFile() { return "D" + "|" + super.writingFile() + "|" + dateAndTime; }

    public String toString() {
        return "[D]" + super.toString() + "(by: " + dateAndTime + ")";
    }


}
