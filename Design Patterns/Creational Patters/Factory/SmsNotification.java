package Factory;

public class SmsNotification implements Notification {
    @Override
    public void sendNotification()
    {
        System.out.println("Sending an SMS notification");
    }
}
