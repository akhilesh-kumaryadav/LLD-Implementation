package CommandPattern.Solution.AC.Commands;

import CommandPattern.Solution.ICommand;
import CommandPattern.Solution.AC.AirConditioner;

public class TurnOffCommand implements ICommand {
    private final AirConditioner ac;
    private boolean previousState;

    public TurnOffCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        this.previousState = ac.isOn();
        ac.turnOff();
    }

    @Override
    public void undo() {
        System.out.println("Undo: Turn Off Command.");

        if (this.previousState) {
            ac.turnOn();
        }
    }
}