package MineSweeper;

import java.util.Scanner;

public class Game {

    private Board board;
    private boolean GameOver;

    public Game(int size)
    {
        board = new Board(size);
        GameOver = false;
    }

    public void startGame()
    {
        System.out.println("\t\t\t\t\tMINESWEEPERRR\t\t\t\t\t\n");
        Scanner scanner = new Scanner(System.in);
        while(!GameOver)
        {
            board.printBoard();
            System.out.println("\n1.Reveal a Cell (Type r,(rowNO),(colNo))");
            System.out.println("2.Flag a Cell (f,(rowNo),(colNo))");
            System.out.println("3.Exit (Type exit))\n");
            String command = scanner.nextLine();
            if(command.equalsIgnoreCase("exit")){GameOver = true; break;}
            String[] commands = command.trim().split(" ");
            if(commands.length != 3) 
            {
                                System.out.println("Invalid input!!");
                continue;
            }
            int row = Integer.parseInt(commands[1]);
            int col = Integer.parseInt(commands[2]);
            if( row >= board.getSize() || col>=board.getSize() || row<0 || col<0) 
            {
                System.out.println("Invalid input!!");
                continue;
            }
            if(commands[0].equalsIgnoreCase("f"))
            {
                board.toggleFlag(row,col);
                continue;
            }
            else if(commands[0].equalsIgnoreCase("r"))
            {
                if(!board.reveal(row, col))
                {
                    GameOver = true;
                    System.out.println("You opened a Mine!!! Game Over!!!");
                }
            }
            else
            {
                                System.out.println("Invalid input!!");
                continue;
            }
            if(isGameWon())
            {
                System.out.println("You won!!!!"); GameOver = true;
            }
        }
    }

    private boolean isGameWon()
    {
        if(board.getNoOfUnHiddenCells() + board.getSize() == board.getSize()*board.getSize())
        return true;
        return false;
    }


}
