package MineSweeper;

public class Cell {
    private CellType cellType;
    private boolean isHidden;
    private boolean isFlagged;
    private int noOfAdjacentMines;
    public Cell(CellType cellType)
    {
        this.cellType = cellType;
        this.isHidden = true;
        this.isFlagged = false;
        this.noOfAdjacentMines = 0;
    }

    public CellType getCellType() {return cellType;}
    public boolean  isHidden() {return isHidden;}
    public boolean isFlagged() {return isFlagged;}
    public int getNoOfAdjacentMines() {return noOfAdjacentMines;}

    public void setCellType(CellType cellType){ this.cellType = cellType;}
    public void Unhide(){ isHidden = false;}
    public void toggleFlag(){ this.isFlagged = !this.isFlagged;}
    public void increaseAdjMineCount(){noOfAdjacentMines++;}


}
