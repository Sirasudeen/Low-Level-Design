package MessageBoardSystem;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
          MessageBoard board = new MessageBoard();
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        // Pre-populate with some data
        User user1 = board.registerUser("Alice");
        User user2 = board.registerUser("Bob");
        board.createPost("Alice", "Hello world! This is my first post.");
        board.createPost("Bob", "Just finished the Library Management System project. It was fun!");

        while (true) {
            System.out.println("\n===== Message Board Menu =====");
            System.out.println("Logged in as: " + (currentUser != null ? currentUser.getUsername() : "Guest"));
            System.out.println("1. Register a new User");
            System.out.println("2. Login as a User");
            System.out.println("3. Create a Post");
            System.out.println("4. Add a Comment to a Post");
            System.out.println("5. View Public Feed");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter a new username: ");
                    String newUsername = scanner.nextLine();
                    board.registerUser(newUsername);
                    break;
                case 2:
                    System.out.print("Enter username to login: ");
                    String loginUsername = scanner.nextLine();
                    User userToLogin = board.getUserByUsername(loginUsername);
                    if (userToLogin != null) {
                        currentUser = userToLogin;
                        System.out.println("SUCCESS: Logged in as " + currentUser.getUsername());
                    } else {
                        System.out.println("ERROR: User not found.");
                    }
                    break;
                case 3:
                    if (currentUser == null) {
                        System.out.println("ERROR: You must be logged in to post.");
                        break;
                    }
                    System.out.print("Enter your post content: ");
                    String content = scanner.nextLine();
                    board.createPost(currentUser.getUsername(), content);
                    break;
                case 4:
                    if (currentUser == null) {
                        System.out.println("ERROR: You must be logged in to comment.");
                        break;
                    }
                    System.out.print("Enter the Post ID to comment on: ");
                    String postId = scanner.nextLine();
                    System.out.print("Enter your comment: ");
                    String commentText = scanner.nextLine();
                    board.addComment(currentUser.getUsername(), postId, commentText);
                    break;
                case 5:
                    board.viewAllPosts();
                    break;
                case 6:
                    System.out.println("Exiting the Message Board. See you next time!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
