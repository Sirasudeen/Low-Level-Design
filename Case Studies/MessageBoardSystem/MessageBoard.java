package MessageBoardSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MessageBoard {
    private final Map<String, User> usersByUsername = new HashMap<>();
    private final List<Post> allPosts = new ArrayList<>();

    public User registerUser(String username) {
        if (usersByUsername.containsKey(username)) {
            System.out.println("ERROR: Username '" + username + "' is already taken.");
            return null;
        }
        User newUser = new User(username);
        usersByUsername.put(username, newUser);
        System.out.println("SUCCESS: User '" + username + "' registered!");
        return newUser;
    }

    public User getUserByUsername(String username) {
        return usersByUsername.get(username);
    }

    public void createPost(String username, String content) {
        if (!usersByUsername.containsKey(username)) {
            System.out.println("ERROR: User '" + username + "' not found.");
            return;
        }
        Post newPost = new Post(username, content);
        allPosts.add(0, newPost); // Add to the front to show newest first
        System.out.println("SUCCESS: Post created!");
    }

    public void addComment(String username, String postId, String text) {
        User user = getUserByUsername(username);
        Post post = findPostById(postId);

        if (user == null) {
            System.out.println("ERROR: You must be logged in to comment.");
            return;
        }
        if (post == null) {
            System.out.println("ERROR: Post with ID '" + postId + "' not found.");
            return;
        }
        post.addComment(new Comment(username, text));
        System.out.println("SUCCESS: Comment added to post " + postId);
    }

    public void viewAllPosts() {
        System.out.println("\n===== Public Message Feed =====");
        if (allPosts.isEmpty()) {
            System.out.println("(The feed is empty. Be the first to post!)");
        } else {
            allPosts.forEach(System.out::println);
        }
        System.out.println("=============================");
    }

    private Post findPostById(String id) {
        return allPosts.stream().filter(p -> p.getPostId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}

