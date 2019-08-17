import java.util.Scanner;

public class Duke {
    //TODO: Level 2 fixed list msg + array storage
    private static String LINE = "_______________________________\n";
    private Scanner scan;
    private Task task;


    private Duke() {
        scan = new Scanner(System.in);
        task = new Task();
    }

    private void helloMsg() {
        System.out.println(
                LINE +
                "Hello! I'm Duke\n" +
                "What can I do for you?\n" +
                LINE);
    }

    private void loopMsg() {
        String input = scan.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                task.displayList();
            } else {
                task.addTask(input);
            }
            input = scan.nextLine();
        }
    }

    private void goodbyeMsg() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    private void closeScan() {
        scan.close();
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.helloMsg();
        duke.loopMsg();
        duke.goodbyeMsg();
        duke.closeScan();
    }
}
