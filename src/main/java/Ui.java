public class Ui {
    public void helloMsg() {
        String LINE = "_______________________________\n";
        System.out.println(
                LINE +
                        "Hello! I'm Duke\n" +
                        "What can I do for you?\n" +
                        LINE);
    }

    private void tryAgainCommand() {
        System.out.println("Please input the right command!");
    }

    private void tryAgainCommandEmpty() {
        System.out.println("Adding command cannot be empty!");
    }

    private void tryAgainNumber() {
        System.out.println("Please input a number!");
    }

    private void tryAgainIndex() {
        System.out.println("Please check your index");
    }

    private void tryAgainListSize() {
        System.out.println("Please check your list size!");
    }

    private void addedTaskMsg() {
        System.out.println("Got it. I've added this task:");
    }

    private void currentTaskListSizeMsg(int size) {
        System.out.println(
                "Now you have " +
                        size +
                        " tasks in the list.");
    }
    private void doneTaskMsg() {
        System.out.println("Nice! I've marked this task as done:");
    }

    private void printTask(Task task) {
        System.out.println(task);
    }

}
