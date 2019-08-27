public class Deadline extends Task {
    private String dateAndTime;

    Deadline(String... input) {
        super(input[0]);
        setDateAndTime(input[input.length - 1]);
    }

    private void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String writingFile() {
        return "D" + "|" + super.writingFile() + "|" + dateAndTime;
    }

    public String toString() {
        return "[D]" + super.toString() + "(by: " + dateAndTime + ")";
    }


}
