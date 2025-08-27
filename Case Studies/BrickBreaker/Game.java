package BrickBreaker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Board board;
    private Ball ball;
    private Map<String,MoveStrategy> moveStrategies;

    public Game(int size,int ballLives)
    {
        this.board = new Board(size);
        int startRow = size -1;
        int startCol = size/2;
        this.ball = new Ball(ballLives,startRow,startCol);

        this.moveStrategies = new HashMap<>();
        moveStrategies.put("lt", new LeftDiagnolMove());
        moveStrategies.put("rt", new RightDiagnolMove());
        moveStrategies.put("st", new StraightMoveStrategy());

    }

    public void setupBricks(int[][] brickPositions,int strength)
    {
        for(int[] pos : brickPositions)
        {
            board.placeBrick(pos[0], pos[1], strength);
        }
    }

    public void simulateBallJourney() {
        try {
            while (true) {
                int currentRow = ball.getRow();
                int currentCol = ball.getCol();
                int nextRow = currentRow + ball.getDx();
                int nextCol = currentCol + ball.getDy();
                board.clearBallPostion(currentRow, currentCol);
                Cell nextCell = board.getCell(nextRow, nextCol);
                

            if (nextCell.getCellType() == CellType.GROUND) {
                System.out.println("Ball hit the ground! Life lost.");
                ball.decreaseLife();
                ball.resetToStartPosition();
                return; 
            }

                if (nextCell.getCellType() == CellType.WALL) {
                System.out.println("Ball hit a wall!");
                if (nextRow == 0) {
                    ball.reverseDx();
                }
                if (nextCol == 0 || nextCol== board.size - 1 ) {
                    System.out.println("Ball reveresed");
                    ball.reverseDy();
                }
            }

            else if (nextCell.getCellType() == CellType.BRICK) {
                System.out.println("Ball hit a brick!");
                Brick brick = nextCell.getBrick();
                brick.hit();
                ball.reverseDx();
                ball.reverseDy();
                if (brick.isBroken()) {
                    System.out.println("Brick broken!");
                    nextCell.setType(CellType.EMPTY);
                    board.originalGridTypes[nextRow][nextCol] = CellType.EMPTY;
                }
            } 

                    ball.setPosition(nextRow, nextCol);


                board.placeBall(ball);
                board.display();
                System.out.println("Ball count: " + ball.getLives());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public void run()
    {
        Scanner scanner  = new Scanner(System.in);
        while(!isGameOver())
        {
            board.placeBall(ball);
            board.display();
            System.out.println("Ball Count : "+ball.getLives());
            System.out.print("Enter command (St, Lt, Rt, MBL, MBR) or 'exit': ");
            String command = scanner.nextLine();
            if("exit".equalsIgnoreCase(command))
            {
                System.out.println("Exiting the game.");
                break;
            }
            if("MBR".equalsIgnoreCase(command))
            {
                if(ball.getCol() < board.size - 1)
                { int currentRow = ball.getRow();
                int currentCol = ball.getCol();
                board.clearBallPostion(currentRow, currentCol);

                    ball.setPosition(currentRow, currentCol+1); board.placeBall(ball);}
                else
                System.out.println("Can't Move!!!");
                continue;
            }
            else if("MBL".equalsIgnoreCase(command))
            {
                if(ball.getCol() > 0)
                { int currentRow = ball.getRow();
                int currentCol = ball.getCol();
                board.clearBallPostion(currentRow, currentCol);

                    ball.setPosition(currentRow, currentCol-1); board.placeBall(ball);}
                else
                System.out.println("Can't Move!!!");
                continue;
            }
            MoveStrategy strategy = moveStrategies.get(command.toLowerCase());
            if(strategy != null)
            {
                strategy.execute(this);
                simulateBallJourney();
            }
            else 
            {System.err.println("Invalid command.");}
        }

        scanner.close();
         if (board.getBrickCount() == 0) {
            System.out.println("\nCONGRATULATIONS - You broke all the bricks!");
        }
        else if (ball.getLives() == 0) {
            System.out.println("\nGAME OVER - You ran out of lives!");
        }
    }

    public boolean isGameOver()
    {
        if(ball.getLives() == 0)
        {
            return true;
        }
        if(board.getBrickCount() == 0)
        {
            return true;
        }
        return false;
    }

    public Ball getBall(){return ball;}
    public Board getBoard(){return board;}
}
