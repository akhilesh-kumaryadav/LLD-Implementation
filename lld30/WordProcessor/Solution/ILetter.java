package WordProcessor.Solution;

// Flywieght (Interface) -> for the flyweight object - defines methods that use extrinsic state
public interface ILetter {
    // The position(r, c) is extrinsic data - unique to each object
    void display(int row, int column);
}