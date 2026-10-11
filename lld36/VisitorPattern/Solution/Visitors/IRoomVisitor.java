package VisitorPattern.Solution.Visitors;

import VisitorPattern.Solution.Elements.DeluxeRoom;
import VisitorPattern.Solution.Elements.StandardRoom;
import VisitorPattern.Solution.Elements.SuiteRoom;

// Visitor interface = defines operations
public interface IRoomVisitor {
    void visitStandardRoom(StandardRoom room);

    void visitDeluxeRoom(DeluxeRoom room);

    void visitSuiteRoom(SuiteRoom room);
}