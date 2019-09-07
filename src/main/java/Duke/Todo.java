package Duke;

public class Todo extends Task {
    Todo(String... input) {
        super(input[0]);
    }

    @Override
    public String writingFile() {
        return "T" + "|" + super.writingFile();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
