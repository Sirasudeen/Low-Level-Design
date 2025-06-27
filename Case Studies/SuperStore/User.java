package SuperStore;
import java.util.UUID;
public abstract class User {
    private String name;
    private String userId;
    private String email;
    private String hashedPassword;

    public User(String name,String email,String password)
    {
        this.name = name;
        this.email = email;
        this.userId = UUID.randomUUID().toString();
        this.hashedPassword = SHA256Hashing.generateSHA256Hash(password);
    }
    public String getName(){return name;}
    public String getUserId(){return userId;}
    public String getEmail(){return email;}
    public boolean checkPassword(String password)
    {
        return SHA256Hashing.generateSHA256Hash(password).equals(hashedPassword);
    }
}
