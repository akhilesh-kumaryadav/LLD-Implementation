package Elevator;

import java.util.List;

import Elevator.Enum.ElevatorDirection;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(List<ElevatorController> controllers, int requestFloor,
            ElevatorDirection direction);
}