package TaskManagementSystem;

class Task {
    private final int id;
    private final String description;
    private boolean isComplete;
    private final Priority priority;

    public Task(int id, String description, Priority priority) {
        this.id = id;
        this.description = description;
        this.isComplete = false;
        this.priority = priority;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public boolean isComplete() { return isComplete; }
    public Priority getPriority() { return priority; }
    public void markComplete() { this.isComplete = true; }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Priority: " + priority +
               ", Status: " + (isComplete ? "Complete" : "Pending") +
               ", Description: '" + description + '\'';
    }
}