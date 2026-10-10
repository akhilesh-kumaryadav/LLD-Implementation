package CommandPattern.Solution;

import CommandPattern.Solution.AC.Commands.SetTemperatureCommand;
import CommandPattern.Solution.AC.Commands.TurnOffCommand;
import CommandPattern.Solution.AC.Commands.TurnOnCommand;
import CommandPattern.Solution.AC.AirConditioner;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=====> Command Pattern: Solution Demo <=====");

        AirConditioner airConditioner = new AirConditioner();
        RemoteController remoteController = new RemoteController();

        remoteController.setCommand(new TurnOnCommand(airConditioner));
        remoteController.pressButton();
        remoteController.setCommand(new SetTemperatureCommand(airConditioner, 25));
        remoteController.pressButton();
        remoteController.setCommand(new SetTemperatureCommand(airConditioner, 18));
        remoteController.pressButton();
        remoteController.setCommand(new TurnOffCommand(airConditioner));
        remoteController.pressButton();

        // Undo Command
        remoteController.undo(); // Undo: Turn Off command => AC is now on

        // Undo Command
        remoteController.undo(); // Undo: Set Temperature Command. AC temperature is now 25°C

        // Undo Command
        remoteController.undo(); // Undo: Set Temperature Command. AC temperature is now 0°C

        // Undo Command
        remoteController.undo(); // Undo: Turn On command => AC is now off
    }
}