package VisitorPattern.Solution.Elements;

import VisitorPattern.Solution.Visitors.IRoomVisitor;

// Element interface - represents rooms(elements) that can be visited
public interface IRoom {
    void accept(IRoomVisitor visitor);
}