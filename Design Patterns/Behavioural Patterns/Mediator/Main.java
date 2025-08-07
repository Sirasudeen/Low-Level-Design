package Mediator;

public class Main{
    public static void main(String[] args) {

        CollaborativeDocument doc = new CollaborativeDocument();
        User siras = new User("Siras",doc);
        User user2 = new User("User2",doc);

        doc.join(siras);
        doc.join(user2);

        siras.makeChange("Lalala lalala");
        user2.makeChange("dadada daadaa");
    }
}