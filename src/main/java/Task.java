class Task {
    private String[] arr;
    private int counter;

    Task() {
        arr = new String[100];
        counter = 0;
    }
    void addTask(String task) {
        arr[counter] = task;
        counter++;
        System.out.println("added: " + task);
    }

    void displayList() {
        for (int i = 0; i < counter; i++) {
            System.out.println(i + 1 + ". " + arr[i]);
        }
    }
 }
