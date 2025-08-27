package TicTocToe;

public class Board {
    public PlayingPiece[][] board;
    public int size;

    public Board(int size)
    {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row,int col,PlayingPiece piece)
    {
        if(row >=size || col>=size || row<0 || col<0 || board[row][col]!=null)
        {return false;}
        else
        {board[row][col] = piece;
        return true;}
    }

    public boolean hasFreeCells()
    {
        for(int i =0; i<size;i++)
        {
            for(int j = 0;j<size;j++)
            {
                if(board[i][j] == null) return true;
            }
        }
        return false;
    }

    public void printBoard()
    {
        
            for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + (board[i][j] == null ? " " : board[i][j].type) + " ");
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();
            if (i < size - 1) {
                for(int k=0; k<size; k++) System.out.print("----");
                System.out.println();
            }
        }

        }
}
