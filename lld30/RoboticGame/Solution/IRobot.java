package RoboticGame.Solution;

// Flyweight (Interface) -> for the flyweight object - defines methods that use extrinsic state
public interface IRobot {
    // X and Y are extrinsic data - not unique to each object
    void display(int x, int y);
}