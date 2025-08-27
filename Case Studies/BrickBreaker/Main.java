package BrickBreaker;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(7,5);
        int[][] bricks = {
            {2, 2}, {2, 3}, {2, 4},
            {3, 2}, {3, 3}, {3, 4}
        };

        game.setupBricks(bricks, 1);
        game.run();
    }
}
