import java.util.ArrayList;
import java.util.Scanner;

public class SimpleTaskListApp {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    taskList.addTask(getTaskName(scanner));
                    break;
                case 2:
                    taskList.removeTask(scanner);
                    break;
                case 3:
                    taskList.listTasks();
                    break;
                case 4:
                    System.out.println("Exiting the Task List Application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Simple Task List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Quit");
        System.out.print("Select an option: ");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static String getTaskName(Scanner scanner) {
        System.out.print("Enter task name: ");
        return scanner.next();
    }
}

class TaskList {
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String name) {
        tasks.add(name);
        System.out.println("Task added: " + name);
    }

    public void removeTask(Scanner scanner) {
        if (!isEmpty()) {
            listTasks();
            int taskNumber = getUserInput(scanner, "Enter the task number to remove: ");
            if (isValidTaskNumber(taskNumber)) {
                System.out.println("Removing task: " + tasks.get(taskNumber - 1));
                tasks.remove(taskNumber - 1);
                System.out.println("Task removed.");
            } else {
                System.out.println("Invalid task number.");
            }
        } else {
            System.out.println("No tasks to remove.");
        }
    }

    public void listTasks() {
        if (!isEmpty()) {
            System.out.println("Task List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        } else {
            System.out.println("No tasks to list.");
        }
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }

    private static int getUserInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
}