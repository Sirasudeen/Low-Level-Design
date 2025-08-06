package Command;

public class AConCommand implements Command{
    private AC ac;

    public AConCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.on();
    }
    @Override
    public void undo() {
        ac.off();
    }
}
