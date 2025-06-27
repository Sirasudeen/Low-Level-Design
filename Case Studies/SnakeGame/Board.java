package SnakeGame;

public class Board {
    private int size;
    private Cell[][] board;
    private Snake snake;
    private int snakeSize;

    public Board(int size) {
        this.size = size;
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell(CellType.Empty);
            }

        }

        board[0][0] = new Cell(CellType.SnakePart);
        snake = new Snake(board[0][0], 0, 0);
        snakeSize = 0;
        makeFood();
    }

    public void makeFood() {
        int row = (int) (Math.random() * size);
        int col = (int) (Math.random() * size);
        while (board[row][col].getCellType() != CellType.Empty) {
            row = (int) (Math.random() * size);
            col = (int) (Math.random() * size);
        }
        board[row][col] = new Cell(CellType.Food);
        snakeSize++;
    }


    public boolean moveSnake(int direction) {
        int[] dx = { 0, 1, -1, 0 };
        int[] dy = { 1, 0, 0, -1 };

        int newRow = snake.row + dx[direction];
        int newCol = snake.col + dy[direction];

        if (newRow < 0 || newRow >= size || newCol < 0 || newCol >= size
                || board[newRow][newCol].getCellType() == CellType.SnakePart) {
            return false;
        }

        boolean ateFood = (board[newRow][newCol].getCellType() == CellType.Food);

        Cell newHeadCell = new Cell(CellType.SnakePart);
        Snake newHead = new Snake(newHeadCell, newRow, newCol);

        board[newRow][newCol] = newHeadCell;
        newHead.next = this.snake;
        this.snake = newHead;

        if (ateFood) {
            makeFood();
        } else {
            Snake current = this.snake;
            Snake beforeTail = null;

            while (current.next != null) {
                beforeTail = current;
                current = current.next;
            }

            board[current.row][current.col] = new Cell(CellType.Empty);

            if (beforeTail != null) {
                beforeTail.next = null;
            }
        }

        return true;
    }

    public int getSnakeSize() {
        return snakeSize;
    }

    public int getBoardSize() {
        return size;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (board[i][j].getCellType()) {
                    case SnakePart:
                        System.out.print("-");
                        break;
                    case Food:
                        System.out.print("X");
                        break;
                    case Empty:
                        System.out.print(".");
                        break;
                    default:
                        throw new AssertionError();
                }

            }
            System.out.println();
        }
    }
}
