package BrickBreaker;

public class Board {
     final int size;
    private final Cell[][] board;
     final CellType[][] originalGridTypes;

    public Board(int size)
    {
        this.size = size;
        this.board = new Cell[size][size];
        this.originalGridTypes = new CellType[size][size];
        initializeBoard();
    }
    

    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                
                if (i == 0 || j == 0 || j == size - 1) {
                    board[i][j] = new Cell(CellType.WALL);
                } else if (i == size - 1) {
                    board[i][j] = new Cell(CellType.GROUND);
                } else {
                    board[i][j] = new Cell(CellType.EMPTY);
                }
                originalGridTypes[i][j] = board[i][j].getCellType();
            }
        }
        board[size-1][0]  = new Cell(CellType.GROUND);
        board[size-1][size-1]  = new Cell(CellType.GROUND);
        originalGridTypes[size-1][0] = CellType.GROUND;
        originalGridTypes[size-1][size-1] = CellType.GROUND;
    }
    public void placeBrick(int row, int col, int strength)
    {
        if(row<0 || row>=size || col<0 || col>=size) return;
        board[row][col] = new Cell(CellType.BRICK);
        board[row][col].setBrick(new Brick(strength));
        originalGridTypes[row][col] = CellType.BRICK;
    }
    public void placeBall(Ball ball){
        board[ball.getRow()][ball.getCol()].setType(CellType.BALL);
    }

    public void clearBallPostion(int row,int col)
    {
        board[row][col].setType(originalGridTypes[row][col]);
    }

    public void display()
    {
        System.out.println("---------------------------------");
        for(int i = 0;i<size;i++)
        {
            for(int j = 0; j<size; j++)
            {
                Cell cell = board[i][j];
                switch (cell.getCellType()) {
                    case WALL: System.out.print(" w "); break;
                    case GROUND: System.out.print(" g "); break;
                    case EMPTY: System.out.print("   "); break;
                    case BALL: System.out.print(" o "); break;
                    case BRICK: System.out.print(" b "); break;
                    default:
                        throw new AssertionError();
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }


    public Cell getCell(int row,int col)
    {
        if(row<0 || row>=size || col<0 || col>=size) return null;
        return board[row][col];
    }

    public int getBrickCount()
    {
        int count = 0;
        for(int i = 0;i<size;i++)
        {
            for(int j = 0;  j<size; j++)
            {
                if(board[i][j].getCellType() == CellType.BRICK && board[i][j].getBrick() != null && !board[i][j].getBrick().isBroken())
                count++;
            }
        }
        return count;
    }
}

