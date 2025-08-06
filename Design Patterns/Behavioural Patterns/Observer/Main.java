package Observer;

public class Main {
    public static void main(String[] args) {
        
        YoutubeChannel tuf = new YoutubeChannel("IVE");

        tuf.Subscribe(new MobileSubscriber("Siras"));
        tuf.Subscribe(new EmailSubscriber("sirasudeenp@gmail.com"));

        tuf.uploadVideo("I AM MV");
        tuf.uploadVideo("ATTITUDE MV");
        
    }
}
