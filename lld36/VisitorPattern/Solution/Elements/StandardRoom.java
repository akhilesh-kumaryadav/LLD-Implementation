package VisitorPattern.Solution.Elements;

import VisitorPattern.Solution.Visitors.IRoomVisitor;

// Concreate Element - Different rrom types
public class StandardRoom implements IRoom {
    private final String roomNumber;

    public StandardRoom(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public void accept(IRoomVisitor visitor) {
        visitor.visitStandardRoom(this);
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}