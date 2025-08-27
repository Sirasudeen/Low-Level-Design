package BrickBreaker;

public class Cell {
    private CellType cellType;
    private Brick brick;

    public Cell(CellType cellType)
    {
        this.cellType = cellType;
        this.brick = null;
    }

    public void setBrick(Brick brick)
    {
        if(this.cellType == CellType.BRICK)
        {this.brick = brick;}
    }

    public CellType getCellType()
    {
        return this.cellType;
    }
    public Brick getBrick()
    {
        return this.brick;
    }   

    public void setType(CellType cellType)
    {
        this.cellType = cellType;
        if(this.cellType != CellType.BRICK)
        {this.brick = null;}
    }


}
