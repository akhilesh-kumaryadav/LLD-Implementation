package CommandPattern.Solution.AC.Commands;

import CommandPattern.Solution.ICommand;
import CommandPattern.Solution.AC.AirConditioner;

public class TurnOnCommand implements ICommand {
    private final AirConditioner ac;
    private boolean previousState;

    public TurnOnCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        this.previousState = ac.isOn();
        ac.turnOn();
    }

    @Override
    public void undo() {
        System.out.println("Undo: Turn On Command.");

        if (!this.previousState) {
            ac.turnOff();
        }
    }
}