package Duke.Util;

import Duke.Tasks.Task;

import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner scan;
    private static String LINE = "_______________________________\n";

    public Ui() {
        scan = new Scanner(System.in);
    }

    private void closeScan() {
        scan.close();
    }

    public String readCommand() {
        return scan.nextLine();
    }

    public void helloMsg() {
        System.out.println(
                        LINE +
                        "Hello! I'm Duke\n" +
                        "What can I do for you?\n" +
                        LINE);
    }

    public void showLine() {
        System.out.print(LINE);
    }

    public void addedTaskMsg() {
        System.out.println("Got it. I've added this task:");
    }

    public void currentTaskListSizeMsg(int size) {
        System.out.println(
                "Now you have " +
                        size +
                        " tasks in the list.");
    }
    public void doneTaskMsg(Task task) {
        System.out.println("Nice! I've marked this task as done:\n" + task);
    }

    public void printTaskList(List<Task> taskList) {
        int count = 1;
        for (Task temp : taskList) {
            System.out.println(count + ". " +temp);
            count++;
        }
    }

    public void printTask(Task task) {
        System.out.println(task);
    }

    public void findMsg(List<Task> taskList) {
        System.out.println("Here are the matching tasks in your list:");
        int count = 1;
        for (Task temp : taskList) {
            System.out.println(count + ". " + temp);
            count++;
        }
    }

    public void goodbyeMsg() {
        System.out.println("Bye. Hope to see you again soon!");
        closeScan();
    }

    public void deleteMsg(Task task) {
        System.out.println("Noted. I've removed this task:\n" + task);
    }

}
