package Command;

import java.util.Stack;

public class RemoteControl {
    private Command[] buttons = new Command[4];
    private Stack<Command> commandHistory = new Stack<>();

    public void setCommand(int slot,Command command)
    {
        buttons[slot] = command;
    }

    public void pressButton(int slot)
    {
        if(buttons[slot] != null)
        {
            buttons[slot].execute();
            commandHistory.push(buttons[slot]);
        }
        else 
        {
            System.out.println("No command assigned to slot " + slot);
        }
    }

    public void pressUndo()
    {
        if(!commandHistory.isEmpty())
        {
            commandHistory.pop().undo();
        }
        else
        {
            System.out.println("No commands to undo");
        }
    }
}
