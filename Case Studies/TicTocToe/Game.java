package TicTocToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class Game {
    
    private Board board;
    private Deque<Player> players;

    public Game()
    {
        initializeGame();
    }
    public void initializeGame()
    {
        players = new LinkedList<>();
        board = new Board(3);
        Player Player1 = new Player("Siras",new PieceX());
        Player Player2 = new Player("Nabila",new PieceY());

        players.addFirst(Player1);
        players.add(Player2);
    }

    @SuppressWarnings("UnnecessaryContinue")
    public String startGame()
    {
        boolean noWinner = true;
        Scanner sc = new Scanner(System.in);
        while(noWinner)
        {
            Player playerTurn = players.removeFirst();
            
            board.printBoard();

            if(!board.hasFreeCells())
            {
                noWinner = false;
                continue; 
            }
            
            System.out.println("Player "+playerTurn.name+" Enter Row and Col :");
            String s = sc.nextLine();
            String[] values = s.split(",");
            if(values.length != 2)
            {System.out.println("Enter Correct Input"); players.addFirst(playerTurn); continue;}
            int inputRow = Integer.parseInt(values[0]);
            int inputCol = Integer.parseInt(values[1]);
            
            if(!board.addPiece(inputRow, inputCol, playerTurn.piece))
            {System.out.println("Enter Correct Input"); players.addFirst(playerTurn); continue;}
            players.addLast(playerTurn);
            if(hasWinner(inputRow,inputCol,playerTurn.piece))
            {
                noWinner = false;
                return playerTurn.name;
            }

        }

        return "It's  a Tie";

    }

    private boolean hasWinner(int row,int col,PlayingPiece piece)
    {
        boolean RowCheck = true;
        boolean ColCheck = true;
        boolean DiagnolCheck = true;
        boolean AntiDiagnolCheck = true;

        for(int i = 0; i<board.size; i++)
        {
            if(board.board[row][i] != piece)
            RowCheck = false;
        }
        for(int i = 0; i<board.size;i++)
        {
            if(board.board[i][col] != piece)
            ColCheck = false;
        }

        for(int i = 0; i<board.size;i++)
        {
            if(board.board[i][i]!=piece)
            DiagnolCheck = false;
        }
        for(int i = 0; i<board.size;i++)
        {
            if(board.board[i][board.size-i-1] != piece)
            AntiDiagnolCheck = false;
        }

        return RowCheck || ColCheck || DiagnolCheck || AntiDiagnolCheck;
    }
}
