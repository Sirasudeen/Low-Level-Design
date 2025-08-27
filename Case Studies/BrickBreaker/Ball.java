package BrickBreaker;

public class Ball {
    private int lives;
    private final int startRow;
    private final int startCol;
    private int currRow;
    private int currCol;

    private int dx;
    private int dy;

    public Ball(int lives,int startRow,int startCol)
    {
        this.lives = lives;
        this.startRow = startRow;
        this.startCol = startCol;
        resetToStartPosition();
    }

    public int getLives(){return lives;}
    public int getRow(){return currRow;}
    public int getCol(){return currCol;}
    public int getDx(){return dx;}
    public int getDy(){return dy;}

    public void decreaseLife()
    {
        if(lives>0) lives--;
    }

    public void setPosition(int row, int col)
    {
        currRow = row;
        currCol = col;
    }

    public void setDirection(int dx, int dy)
    {
        this.dx = dx;
        this.dy = dy;
    }

    public void reverseDx()
    {
        this.dx *= -1;
    }
    public void reverseDy()
    {
        this.dy *= -1;
    }

    public void resetToStartPosition()
    {
        this.currRow = startRow;
        this.currCol = startCol;
        this.dx = 0;
        this.dy = 0;
    }
}
