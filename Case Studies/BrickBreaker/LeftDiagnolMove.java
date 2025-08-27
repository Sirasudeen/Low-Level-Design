package BrickBreaker;

public class LeftDiagnolMove implements MoveStrategy{
    
    @Override
    public void execute(Game game) {
        game.getBall().setDirection(-1,-1);
    }
}
