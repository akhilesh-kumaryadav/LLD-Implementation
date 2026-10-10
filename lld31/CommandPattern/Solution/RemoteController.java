package CommandPattern.Solution;

import java.util.Stack;

public class RemoteController {
    ICommand command;
    Stack<ICommand> commandHistory = new Stack<>();

    public RemoteController() {

    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        this.command.execute();
        this.commandHistory.push(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            ICommand lastCommand = this.commandHistory.pop();
            lastCommand.undo();
        }
    }
}