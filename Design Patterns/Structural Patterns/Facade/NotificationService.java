package Facade;

public class NotificationService {
    public void sendNotification(String accountId, String message) {
        System.out.println("Notification sent to account " + accountId + ": " + message);
    }
}
