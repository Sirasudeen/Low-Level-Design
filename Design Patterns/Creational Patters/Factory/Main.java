package Factory;

public class Main {
        public static void main(String[] args) {
                    NotificationService notificationService = new NotificationService();
        notificationService.send("Email");
        notificationService.send("Sms");
        }
    }
