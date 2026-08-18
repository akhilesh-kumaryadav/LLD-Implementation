package Elevator;

import java.util.List;
import java.util.ArrayList;

public class Building {
    List<Floor> floors = new ArrayList<>();

    public Building(int totalFloors, ExternalDispatcher dispatcher) {
        for (int i = 1; i <= totalFloors; i++) {
            floors.add(new Floor(i, dispatcher));
        }
    }

    public Floor getFloor(int floor) {
        return floors.get(floor - 1);
    }
}