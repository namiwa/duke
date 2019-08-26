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

    private void tryAgainCommand() { System.out.println("Please input the right command!"); }
    private void tryAgainCommandEmpty() { System.out.println("Adding command cannot be empty!"); }
    private void tryAgainNumber() {
        System.out.println("Please input a number!");
    }
    private void tryAgainIndex() {
        System.out.println("Please check your index or list size!");
    }

    private void addedTaskMsg() { System.out.println("Got it. I've added this task:");}
    private void currentTaskListSizeMsg() {
        System.out.println(
                "Now you have " +
                taskList.size() +
                " tasks in the list.");
    }
    private void doneTaskMsg() {
        System.out.println("Nice! I've marked this task as done:");
    }
    private void lastTaskAddedMessage() { System.out.println(taskList.get(taskList.size() - 1)); }

    private void checkValidDoneIndex(String input) throws NumberFormatException, IllegalAccessError {
        String[] hold = input.split(" ");
        int test = hold.length;
        int index = Integer.parseInt(hold[1]);
        if (test > 2) {
            throw new NumberFormatException();
        } else if(index > taskList.size()) {
            throw new IllegalAccessError();
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

    private void displayAllTasks() throws IllegalAccessError {
        if (taskList.isEmpty()) {
            throw new IllegalAccessError();
        }
        System.out.println("Here are the tasks in your list:");
        int count = 1;
        for (Task temp : taskList) {
            System.out.println(count + ". " + temp);
            count++;
        }
    }

    private String[] testRegex(String inputs) throws DukeEmptyCommandException {
        if (inputs.startsWith("deadline")) {
            if (!inputs.contains("/by")) {
                throw new DukeEmptyCommandException();
            }
        }
        if (inputs.startsWith("event")) {
            if (!inputs.contains("/at")) {
                throw new DukeEmptyCommandException();
            }
        }
        if (inputs.equals("todo")) {
            throw new DukeEmptyCommandException();
        }

        String[] res = inputs.split("/");
        if (res.length == 0) {
            throw new DukeEmptyCommandException();
        }
        return res;
    }

    private void parseTask(String input) throws DukeCommandException, DukeEmptyCommandException {
        if (input.startsWith("todo ")) {
            String[] temp = input.split("todo ");
            String [] split = testRegex(temp[temp.length - 1]);
            if (!temp[0].equals("")) {
                throw new DukeCommandException();
            }
            taskList.add(new Todo(split));
        } else if (input.startsWith("event ")) {
            String[] temp = input.split("event ");
            String [] split = testRegex(temp[temp.length - 1]);
            if (!temp[0].equals("")) {
                throw new DukeCommandException();
            }
            taskList.add(new Events(split));
        } else if (input.startsWith("deadline ")) {
            String[] temp = input.split("deadline ");
            String [] split = testRegex(temp[temp.length - 1]);
            if (!temp[0].equals("")) {
                throw new DukeCommandException();
            }
            taskList.add(new Deadline(split));
        } else {
            throw new DukeCommandException();
        }
        addedTaskMsg();
        lastTaskAddedMessage();
        currentTaskListSizeMsg();
    }

    private void loopMsg() {
        String input = scan.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                try {
                    displayAllTasks();
                } catch (IllegalAccessError e) {
                    tryAgainIndex();
                }
            } else if (input.startsWith("done")) {
                try {
                    checkValidDoneIndex(input);
                } catch (NumberFormatException e) {
                    tryAgainNumber();
                } catch (IllegalAccessError e) {
                    tryAgainIndex();
                }
            } else {
                try {
                    parseTask(input);
                } catch (DukeCommandException e) {
                    tryAgainCommand();
                } catch (DukeEmptyCommandException e) {
                    tryAgainCommandEmpty();
                }
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
