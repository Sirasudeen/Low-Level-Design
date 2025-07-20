package Builder;

public class User {
    //required
    private final String name;
    private final   String email;
    private final  String password; //Stop thinking too much

    //optional
    private final String mobileNumber;
    private final String address;
    private final String country;

    private User(UserBuilder userBuilder)
    {
        this.name = userBuilder.name;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.mobileNumber = userBuilder.mobileNumber;
        this.address = userBuilder.address;
        this.country = userBuilder.country;
    }
    public static class UserBuilder{
        private String name;
            private String email;
        private String  password;
        private String  mobileNumber;
        private String  address;
        private String country;

        public UserBuilder(String name,String email,String password)
        {
            this.email = email; this.name = name; this.password = password;
        }

        public UserBuilder mobileNumber(String mobileNumber)
        {
            this.mobileNumber = mobileNumber;
            return this;
        }
        public UserBuilder address(String address)
        {
            this.address = address;
            return this;
        }        
        public UserBuilder country(String country)
        {
            this.country = country;
            return this;
        }

        public User userBuild()
        {
            return new User(this);
        }
        
    }
        public void showInfo() {
        System.out.println("User: " + name + ", Email: " + email + ", Phone: " + mobileNumber + ", Address: " + address);
    }

}
