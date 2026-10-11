package VisitorPattern.Solution;

import VisitorPattern.Solution.Elements.*;
import VisitorPattern.Solution.Visitors.*;

public class Demo {
    public static void main(String[] args) {
        System.out.println("\n###### Visitor Design Pattern Demo ######");

        IRoom[] rooms = {
                new StandardRoom("101"),
                new DeluxeRoom("201", true),
                new SuiteRoom("301", 3),
                new StandardRoom("102"),
                new DeluxeRoom("202", false)
        };

        System.out.println("\n==> Housekeeping Service");
        IRoomVisitor houseKeeping = new HouseKeepingVisitor();
        for (IRoom room : rooms) {
            room.accept(houseKeeping);
        }

        System.out.println("\n==> Room Service");
        IRoomVisitor roomService = new RoomServiceVisitor("BreakFast");
        rooms[0].accept(roomService);
        rooms[1].accept(roomService);
        rooms[2].accept(roomService);

        System.out.println("\n==> Revenue Calculation");
        PricingVisitor pricing = new PricingVisitor();
        for (IRoom room : rooms) {
            room.accept(pricing);
        }

        System.out.println("Total Revenue: Rs." + pricing.getTotalRevenue());
    }
}