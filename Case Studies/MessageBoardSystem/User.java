package MessageBoardSystem;

import java.util.UUID;

public class User {
    private final String userId;
    private final String username;

    public User(String username) {
        this.userId = UUID.randomUUID().toString();
        this.username = username;
    }

    public String getUserId() { return userId; }
    public String getUsername() { return username; }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Username: " + username;
    }
}