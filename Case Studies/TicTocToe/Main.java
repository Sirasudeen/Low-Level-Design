package TicTocToe;

public class Main {
    public static void main(String[] args)
    {
        Game game = new Game();
        String Result = game.startGame();
        if(Result.equals("It's a Tie"))
        System.out.println("Game is Tied!!!");
        else
        System.out.println(Result + " has won the Game!!!");
    }
}