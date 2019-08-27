public class Events extends Task {
    private String dateAndTime;

    Events(String... input) {
        super(input[0]);
        setDateAndTime(input[input.length - 1]);
    }

    private void setDateAndTime(String dateAndTime) {
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
