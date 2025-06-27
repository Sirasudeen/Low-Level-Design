package SuperStore;

import java.util.HashMap;

public class ProfileService {
    private static ProfileService instance;

    private HashMap<String,User> userById;
    private HashMap<String,User> usersByEmail;
    private ProfileService(){
        userById = new HashMap<>();
        usersByEmail = new HashMap<>();
    }
    public static synchronized  ProfileService getInstance()
    {
        if(instance == null)
        {
            instance = new ProfileService();
        }
        return instance;
    }
    public User register(String name,String email,String password,UserType userType)
    {
        if(usersByEmail.containsKey(email))
        {System.err.println("User already exists with this email!!!"); return null;}
        User user = (userType == UserType.BUYER)?new Buyer(name, password,email): new Seller(name, email, password);
        usersByEmail.put(email,user);
        userById.put(user.getUserId(),user);
                System.out.println(userType + " registered successfully: " + name);
        return user;
    }
    public User login(String email,String password)
    {
        User user = usersByEmail.getOrDefault(email,null);
        if (user != null && user.checkPassword(password)) {
            System.out.println("User logged in: " + user.getName());
            return user;
        }
        System.out.println("ERROR: Invalid email or password.");
        return null;
    }
    public User getUserById(String userId){return userById.get(userId);}

}
