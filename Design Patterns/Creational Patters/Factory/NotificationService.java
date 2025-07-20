package Factory;

public class NotificationService {
    private  Notification notification;
    
    public void send(String mode)
    {
        notification = new NotificationFactory().createNotification(mode);
        notification.sendNotification();
    }
}
