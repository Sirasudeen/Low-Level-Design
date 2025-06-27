package MessageBoardSystem;

public class Comment {
    private final String authorUsername;
    private final String text;

    public Comment(String authorUsername, String text) {
        this.authorUsername = authorUsername;
        this.text = text;
    }

    @Override
    public String toString() {
        return "    - " + authorUsername + ": '" + text + "'";
    }
}