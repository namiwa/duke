import java.util.Scanner;

public class Duke {
    private static String line = "_______________________________\n";
    private Scanner scan;

    private Duke() {
        scan = new Scanner(System.in);
    }

    private void helloMsg() {
        System.out.println(
                line +
                "Hello! I'm Duke\n" +
                "What can I do for you?\n" +
                line);
    }

    private void loopMsg() {
        String echo = scan.nextLine();
        while (!echo.equals("bye")) {
            System.out.println(line + echo + "\n" + line);
            echo = scan.nextLine();
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
