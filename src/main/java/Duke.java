import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {

    private Storage store;
    private Ui ui;
    private TaskList tasks;

    private Duke() {
        store = new Storage();
        ui = new Ui();
        tasks = new TaskList(store);
    }

    public void run() {
        ui.helloMsg();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, store);
                isExit = c.isExit();
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.run();
    }
}
