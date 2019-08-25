public class Events extends Task {
    private String dateAndTime;

    Events(String... input) {
        super(input[0]);
        setDateAndTime(input[input.length - 1]);
    }

    private void setDateAndTime(String dateAndTime) {
        String formattedDateAndTime = dateAndTime.trim();
        formattedDateAndTime = formattedDateAndTime.replaceFirst("at", "(at:");
        this.dateAndTime = formattedDateAndTime + ")";
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + dateAndTime;
    }

}
