package MineSweeper;

import java.util.LinkedList;
import java.util.Queue;

public class Board {
    private int size;
    private Cell[][] board;
    private int noOfUnHiddenCells;

    public Board(int size)
    {
        this.size = size;
        board = new Cell[size][size];
        initializeBoard();
        this.noOfUnHiddenCells = size*size;
    }

    private void initializeBoard()
    {
        for(int i = 0;i<size;i++)
        {
            for(int j = 0;j<size; j++)
            {
                board[i][j] = new Cell(CellType.Safe);
            }
        }
        setMines();
    }

    private void setMines()
    {
        int noOfMines = 0;
        while(noOfMines < size)
        {
            int row = (int)(Math.random() * (size-1));
            int col = (int)(Math.random() * (size-1));
            if(board[row][col].getCellType() != CellType.Mine) 
            {
                board[row][col].setCellType(CellType.Mine);
                setAdjacentMineValues(row, col);
                noOfMines++;
            }
        }      

    }

    private void setAdjacentMineValues(int row, int col)
    {
        int[] dx = {0,1,-1,0,1,-1,-1,1}; int[] dy = {1,0,0,-1,1,-1,1,-1};

        for(int i = 0;i<8;i++)
        {

            int r = row+dx[i]; int c = col+dy[i];
            if(r<0 || c<0 || r>=size || c>=size) continue;
             board[r][c].increaseAdjMineCount();
        }
    }

    public void printBoard()
    {
        for(int i = 0;i<size;i++)
        {
            for(int j = 0;j<size;j++)
            {
                Cell cell = board[i][j];
                if(cell.isHidden()) {if(cell.isFlagged()) System.out.print(" F "); else  System.out.print(" - ");}
                else if(cell.getCellType() == CellType.Mine)System.out.print(" X "); else System.out.print(" " + cell.getNoOfAdjacentMines()+" ");
            
            }
            System.out.println();
        }
    }
    public void toggleFlag(int row,int col)
    {
        board[row][col].toggleFlag();
    }

    public boolean reveal(int row,int col)
    {
        if(board[row][col].getCellType() == CellType.Mine)
            {
                return false;
            }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
                int[] dx = {0,1,-1,0,1,-1,-1,1}; int[] dy = {1,0,0,-1,1,-1,1,-1};
        while(!q.isEmpty())
        {
            int[] pos = q.poll();
            Cell cell = board[pos[0]][pos[1]];
            cell.Unhide();
            noOfUnHiddenCells--;
            if(cell.getNoOfAdjacentMines() == 0)
            {
                for(int i = 0;i<8;i++)
                {
                        int r = pos[0] + dx[i];
                        int c = pos[1] + dy[i];
                        if(r<0 || c<0 || r>=size || c>=size) continue;
                            q.add(new int[]{r,c});
                }
            }
            printBoard();

        }

        return true;
    }
    public int getSize(){return size;}
    public int getNoOfUnHiddenCells(){return noOfUnHiddenCells;}
    public void setNoOfUnHiddenCell(int val) {this.noOfUnHiddenCells = val;}


}
