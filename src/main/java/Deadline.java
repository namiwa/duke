public class Deadline extends Task {
    private String dateAndTime;

    Deadline(String... input) {
        super(input[0]);
        setDateAndTime(input[input.length - 1]);
    }

    private void setDateAndTime(String dateAndTime) {
        String formattedDateAndTime = dateAndTime.trim();
        formattedDateAndTime = formattedDateAndTime.replaceFirst("by", "(by:");
        this.dateAndTime = formattedDateAndTime + ")";
    }


    public String toString() {
        return "[D]" + super.toString() + dateAndTime;
    }


}
