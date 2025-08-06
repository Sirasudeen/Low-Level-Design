package Observer;

public class EmailSubscriber implements Subscriber{
    private String email;

    public EmailSubscriber(String email)
    {
        this.email = email;
    }

    @Override
    public void update(String videoTitle)
    {
        System.out.println("Email sent to " + email + ": New video uploaded - " + videoTitle);
    }
}
