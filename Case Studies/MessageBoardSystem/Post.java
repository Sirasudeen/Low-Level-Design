package MessageBoardSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class Post {
    private final String postId;
    private final String authorUsername;
    private final String content;
    private final List<Comment> comments = new ArrayList<>();

    public Post(String authorUsername, String content) {
        this.postId = UUID.randomUUID().toString().substring(0, 8);
        this.authorUsername = authorUsername;
        this.content = content;
    }

    public String getPostId() { return postId; }
    public String getAuthorUsername() { return authorUsername; }
    public void addComment(Comment comment) { comments.add(comment); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------------\n");
        sb.append("Post ID: ").append(postId).append(" | By: ").append(authorUsername).append("\n");
        sb.append("  ").append(content).append("\n");
        sb.append("  Comments:\n");
        if (comments.isEmpty()) {
            sb.append("    (No comments yet)\n");
        } else {
            comments.forEach(comment -> sb.append(comment.toString()).append("\n"));
        }
        sb.append("----------------------------------");
        return sb.toString();
    }
}
