package SnakeGame;

public class Snake {
    Cell cell;
    int row;
    int col;
    Snake next;

    public Snake(Cell cell,int row,int col) {
        this.cell = cell;
        this.row = row;
        this.col = col;
        this.next = null;
    }
    public Snake(Cell cell,int row,int col,Snake next)
    {
        this.cell = cell;
        this.row = row;
        this.col = col;
        this.next = next;
    }

}
