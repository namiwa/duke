import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Duke {
    private Scanner scan;
    private List<Task> taskList;


    private Duke() {
        scan = new Scanner(System.in);
        taskList = new ArrayList<>();
    }

    private void helloMsg() {
        String LINE = "_______________________________\n";
        System.out.println(
                LINE +
                "Hello! I'm Duke\n" +
                "What can I do for you?\n" +
                LINE);
    }

    private void addedTaskMsg(String task) {
        System.out.println("added: " + task);
    }

    private void tryAgainMsg() {
        System.out.println("Please try again!");
    }

    private void doneTaskMsg() {
        System.out.println("Nice! I've marked this task as done:");
    }

    private Boolean checkValidDoneIndex(String input) throws NumberFormatException {
        String[] hold = input.split(" ");
        int test = hold.length;
        int index = Integer.parseInt(hold[1]);
        if (test > 2) {
            return false;
        } else if(index > taskList.size()) {
            return false;
        } else if(index  < 0) {
            return false;
        } else {
            setDoneTask(index);
            return true;
        }
    }

    private void setDoneTask(int index) {
        taskList.get(index - 1).setTaskDone();
        doneTaskMsg();
        System.out.println(taskList.get(index - 1).displayTask());
    }

    private void loopMsg() {
        String input = scan.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                if (taskList.size() == 0) {
                    tryAgainMsg();
                }
                int count = 1;
                for (Task temp : taskList) {
                    System.out.println(count + ". " + temp.displayTask());
                    count++;
                }
            } else if (input.startsWith("done")) {
                Boolean cont = checkValidDoneIndex(input);
                if (!cont) {
                    tryAgainMsg();
                }
            } else {
                taskList.add(new Task(input));
                addedTaskMsg(input);
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
        try {
            duke.loopMsg();
        } catch (NumberFormatException e) {
            duke.tryAgainMsg();
        }
        duke.goodbyeMsg();
        duke.closeScan();
    }
}
