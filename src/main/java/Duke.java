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

    private void tryAgainNumber() {
        System.out.println("Please input a number!");
    }
    private void tryAgainIndex() {
        System.out.println("Please check your index!");
    }

    private void doneTaskMsg() {
        System.out.println("Nice! I've marked this task as done:");
    }

    //TODO: change from boolean to void, throws illegal index access later
    private void checkValidDoneIndex(String input) throws NumberFormatException, IllegalAccessError {
        String[] hold = input.split(" ");
        int test = hold.length;
        int index = Integer.parseInt(hold[1]);
        if (test > 2) {
            throw new NumberFormatException();
        } else if(index > taskList.size()) {
            throw new NumberFormatException();
        } else if(index  <= 0) {
            throw new IllegalAccessError();
        } else {
            setDoneTask(index);
        }
    }

    private void setDoneTask(int index) {
        taskList.get(index - 1).setTaskDone();
        doneTaskMsg();
        System.out.println(taskList.get(index - 1));
    }

    private void displayAllTasks() {
        int count = 1;
        for (Task temp : taskList) {
            System.out.println(count + ". " + temp);
            count++;
        }
    }

    private void loopMsg() {
        String input = scan.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                displayAllTasks();
            } else if (input.startsWith("done")) {
                try {
                    checkValidDoneIndex(input);
                } catch (NumberFormatException e) {
                    tryAgainNumber();
                } catch (IllegalAccessError e) {
                    tryAgainIndex();
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
        closeScan();
    }

    private void closeScan() {
        scan.close();
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.helloMsg();
        duke.loopMsg();
        duke.goodbyeMsg();
    }
}
