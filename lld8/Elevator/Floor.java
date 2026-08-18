package Elevator;

import Elevator.Enum.ElevatorDirection;

public class Floor {
    int floorNumber;
    ExternalButton upBotton;
    ExternalButton downBotton;

    public Floor(int floorNumber, ExternalDispatcher dispatcher) {
        this.floorNumber = floorNumber;
        this.upBotton = new ExternalButton(dispatcher);
        this.downBotton = new ExternalButton(dispatcher);
    }

    public void pressUpButton() {
        upBotton.pressButton(floorNumber, ElevatorDirection.UP);
    }

    public void pressDownButton() {
        downBotton.pressButton(floorNumber, ElevatorDirection.DOWN);
    }
}