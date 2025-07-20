package Factory;

public class NotificationFactory {
    public Notification createNotification(String mode)
    {
        switch (mode) {
            case "Email" -> {
                return new EmailNotification();
            }
            case "Sms" -> {
                return new SmsNotification();
            }
            default -> throw new IllegalArgumentException("Unknown notification type: " + mode);
        }
    }
}
