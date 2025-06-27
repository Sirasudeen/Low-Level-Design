package TaskManagementSystem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicInteger taskIdCounter = new AtomicInteger(1);

    public void addTask(String description, Priority priority) {
        Task newTask = new Task(taskIdCounter.getAndIncrement(), description, priority);
        tasks.add(newTask);
        System.out.println("SUCCESS: Added new task -> " + newTask);
    }

    public void markTaskComplete(int taskId) {
        Task task = findTaskById(taskId);
        if (task != null) {
            task.markComplete();
            System.out.println("SUCCESS: Marked task as complete -> " + task);
        } else {
            System.out.println("ERROR: Task with ID " + taskId + " not found.");
        }
    }

    public void removeTask(int taskId) {
        boolean removed = tasks.removeIf(task -> task.getId() == taskId);
        if (removed) {
            System.out.println("SUCCESS: Removed task with ID " + taskId + ".");
        } else {
            System.out.println("ERROR: Task with ID " + taskId + " not found.");
        }
    }

    public void viewAllTasks() {
        System.out.println("\n--- All Tasks (sorted by priority) ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
        } else {
            tasks.stream()
                 .sorted(Comparator.comparingInt(t -> t.getPriority().getLevel()))
                 .forEach(System.out::println);
        }
        System.out.println("---------------------------------------");
    }

    private Task findTaskById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }
}