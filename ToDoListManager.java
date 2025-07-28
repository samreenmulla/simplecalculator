import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\n TO-DO LIST ");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Mark Task as Done");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public void addTask() {
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();
        tasks.add(new Task(desc));
        System.out.println(" Task added.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, tasks.get(i));
            }
        }
    }

    public void removeTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to remove: ");
        int idx = Integer.parseInt(scanner.nextLine());
        if (idx >= 1 && idx <= tasks.size()) {
            tasks.remove(idx - 1);
            System.out.println(" Task removed.");
        } else {
            System.out.println("Invalid number.");
        }
    }

    public void markTaskDone() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to mark done: ");
        int idx = Integer.parseInt(scanner.nextLine());
        if (idx >= 1 && idx <= tasks.size()) {
            tasks.get(idx - 1).markAsDone();
            System.out.println(" Task marked as done.");
        } else {
            System.out.println("Invalid number.");
        }
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addTask();
                case "2" -> viewTasks();
                case "3" -> removeTask();
                case "4" -> markTaskDone();
                case "5" -> exit = true;
                default -> System.out.println(" Invalid option, try again.");
            }
        }
        System.out.println("Goodbye ");
        scanner.close();
    }

    public static void main(String[] args) {
        new ToDoListManager().run();
    }
}
