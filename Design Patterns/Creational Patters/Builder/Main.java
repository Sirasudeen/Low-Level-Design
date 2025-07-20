package Builder;

public class Main {
    public static void main(String[] args) {

        User user = new User.UserBuilder("Sirasudeen","sirasudeenp@gmail.com","1234556").mobileNumber("232123212").userBuild(); 
        user.showInfo();
    }
}
