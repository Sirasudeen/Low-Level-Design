package Prototype;

public class Main {
    public static void main(String[] args) {
        

        EmailTemplate welcomEmailTemplate = EmailTempRegistry.getTemplate("welcome");
        welcomEmailTemplate.setContent("Hii, Siras...dont give up");
        welcomEmailTemplate.send("Siras");

        EmailTemplate welcomeEmailTemplate2 = EmailTempRegistry.getTemplate("welcome");
        welcomeEmailTemplate2.setContent("Lets do it...");
        welcomeEmailTemplate2.send("Siras");
        welcomeEmailTemplate2.send("Luffy");
    }
}