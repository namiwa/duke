import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Events extends Task {
    private String dateAndTime;
    private Date date;

    Events(String... input) {
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

    public String writingFile() {
        return "E" + "|" + super.writingFile() + "|" + dateAndTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + dateAndTime + ")";
    }

}
