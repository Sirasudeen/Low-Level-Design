package BrickBreaker;

public class StraightMoveStrategy implements MoveStrategy {
    
    @Override
    public void execute(Game game) {
        game.getBall().setDirection(-1,0);
    }
}
