package Elevator;

import java.util.List;

import Elevator.Enum.ElevatorDirection;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers, int requestFloor,
            ElevatorDirection direction) {
        ElevatorController nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorController controller : controllers) {
            int nextFloorStoppage = controller.elevatorCar.nextFloorStoppage;

            boolean isSameDirectionCandidate = controller.elevatorCar.movingDirection == direction
                    && ((direction == ElevatorDirection.UP && nextFloorStoppage <= requestFloor)
                            ||
                            (direction == ElevatorDirection.DOWN && nextFloorStoppage >= requestFloor));

            int dist = Math.abs(nextFloorStoppage - requestFloor);

            if (isSameDirectionCandidate && dist < minDistance) {
                minDistance = dist;
                nearest = controller;
            }
        }

        // fallback: if not able to choose, pick the idle one
        if (nearest == null) {
            for (ElevatorController controller : controllers) {
                if (controller.elevatorCar.movingDirection == ElevatorDirection.IDLE) {
                    nearest = controller;
                    break;
                }
            }

            if (nearest == null) {
                nearest = controllers.get(0);
            }
        }

        return nearest;
    }
}