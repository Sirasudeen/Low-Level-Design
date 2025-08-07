package Mediator;

public interface DocumentSessionMediator {
    void broadcastChange(String change,User sender);
    void join(User user);
}
