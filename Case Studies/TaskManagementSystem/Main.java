package TaskManagementSystem;

import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Pre-populate with some data
        manager.addTask("Prepare for Zoho interview", Priority.HIGH);
        manager.addTask("Buy groceries", Priority.MEDIUM);
        manager.addTask("Water the plants", Priority.LOW);

        while (running) {
            System.out.println("\n===== Task Management System =====");
            System.out.println("1. Add a new Task");
            System.out.println("2. Mark a Task as Complete");
            System.out.println("3. Remove a Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
                    Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());
                    manager.addTask(description, priority);
                    break;
                case 2:
                    System.out.print("Enter the Task ID to mark as complete: ");
                    int completeId = scanner.nextInt();
                    manager.markTaskComplete(completeId);
                    break;
                case 3:
                    System.out.print("Enter the Task ID to remove: ");
                    int removeId = scanner.nextInt();
                    manager.removeTask(removeId);
                    break;
                case 4:
                    manager.viewAllTasks();
                    break;
                case 5:
                    running = false;
                    System.out.println("Stay productive! Exiting system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
