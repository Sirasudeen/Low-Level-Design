package Factory;

public class EmailNotification implements Notification{
        @Override
        public void sendNotification()
        {
            System.out.println("Sending an Email notification");
        }
}
