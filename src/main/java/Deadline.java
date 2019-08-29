import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Deadline extends Task {
    private String dateAndTime;
    private Date date;

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
        DateFormat format = new SimpleDateFormat("dd/MM/YYYY", Locale.ENGLISH);
        try {
            date = format.parse(split[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String writingFile() { return "D" + "|" + super.writingFile() + "|" + dateAndTime; }

    public String toString() {
        return "[D]" + super.toString() + "(by: " + dateAndTime + ")";
    }


}
