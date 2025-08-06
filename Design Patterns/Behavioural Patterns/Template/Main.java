package Template;

public class Main {
    public static void main(String[] args) {
        NotificationSender emailSender = new EmailNotification();
        emailSender.send("Sirasudeenp@gmail.com", "Cheer up Baby!! Cheer UP Baby!!!");
        
    }
}
