package Observer;

public class MobileSubscriber implements Subscriber{
    
    private String username;

    public MobileSubscriber(String username) {
        this.username = username;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("In-app notification for " + username + ": New video - " + videoTitle);
    }
}
