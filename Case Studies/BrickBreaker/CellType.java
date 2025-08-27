package BrickBreaker;

public enum CellType {
    WALL('w'),
    GROUND('g'),
    BRICK('b'),
    EMPTY('e'),
    BALL('o');

    private final char type;

    CellType(char type)
    {
        this.type = type;
    }
    public char getType()
    {
        return type;
    }
}
