package CommandPattern.Solution.AC.Commands;

import CommandPattern.Solution.ICommand;
import CommandPattern.Solution.AC.AirConditioner;

public class SetTemperatureCommand implements ICommand {
    private final AirConditioner ac;
    private final int newTemperature;
    private int previousTemperature;

    public SetTemperatureCommand(AirConditioner ac, int temperature) {
        this.ac = ac;
        this.newTemperature = temperature;
    }

    @Override
    public void execute() {
        this.previousTemperature = ac.getTemperature();
        ac.setTemperature(newTemperature);
    }

    @Override
    public void undo() {
        System.out.println("Undo: Set Temperature command");
        ac.setTemperature(previousTemperature);
    }
}