package SnakeGame;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {

    private Board board;
    private HashMap<String, MoveStrategy> moveStrategy;
    private volatile int currentDirection;
    private volatile boolean isGameOver = false;
    private final BlockingQueue<Integer> directionQueue = new LinkedBlockingQueue<>();

    public Game(int size) {
        this.board = new Board(size);
        this.moveStrategy = new HashMap<>();
        this.moveStrategy.put("W", new UpMoveStrategy());
        this.moveStrategy.put("S", new DownMoveStrategy());
        this.moveStrategy.put("D", new RightMoveStrategy());
        this.moveStrategy.put("A", new LeftMoveStrategy());

        this.currentDirection = this.moveStrategy.get("D").getDirection();
    }

    @Override
    public void run() {
        System.out.println("Grow Snake to size " + board.getBoardSize() + " to Win!!!");
        startInputThread();
        while (!isGameOver) {
            try {
                Integer newDirection = directionQueue.poll(1000, TimeUnit.MILLISECONDS);
                if (newDirection != null) {
                    currentDirection = newDirection;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Game thread interrupted.");
            }

            clearScreen();
            System.out.println("Enter Command (W/S/A/D) to Change Direction");
            System.out.println("Score : " + (board.getSnakeSize() - 1));
            board.printBoard();
            
            boolean result = board.moveSnake(currentDirection);
            if (!result) {
                System.out.println("Game Over!!! You Lost!!!");
                isGameOver = true;
                break;
            }
            if (isGameOver()) {
                System.out.println("Game Over!!! You Won!!!");
                isGameOver = true;
                break;
            }
        }
    }

    public boolean isGameOver() {
        return board.getSnakeSize() == (board.getBoardSize() * board.getBoardSize()) / 2;
    }

    private void clearScreen() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
        }
    }

    public void startInputThread() {
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            try {
                while (!isGameOver) {
                    String input = scanner.nextLine().toUpperCase();
                    if (moveStrategy.containsKey(input)) {
                        try {
                            directionQueue.put(moveStrategy.get(input).getDirection());
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        System.out.println("Invalid Command");
                    }
                }
            } finally {
                scanner.close();
            }
        });
        inputThread.start();
    }
}