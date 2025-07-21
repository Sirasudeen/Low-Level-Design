package Prototype;


public class WelcomeTemplate implements EmailTemplate {
    private final String subject;
    private String content;
    public WelcomeTemplate()
    {
        this.subject = "Welcome to TUF+";
        this.content = "Hi there! Thanks for joining us.";
    }
    @Override
    public void setContent(String content)
    {
        this.content = content;
    }
    @Override
    public void send(String to)
    {
         System.out.println("Sending to " + to + ": [" + subject + "] " + content);
    }
    public WelcomeTemplate clone(){
        try {
            return (WelcomeTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone Failed",e);
        }
    }
}
