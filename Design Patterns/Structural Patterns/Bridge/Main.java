package Bridge;

public class Main {
    public static void main(String[] args) {
        VideoPlayer player1 = new WebPlayer(new HDQuality());

        VideoPlayer player2 = new MobilePlayer(new _4KQuality());

        player1.play("Iam by Ive");

        player2.play("Iam by Ive");

    }
}
