package RoboticGame.Solution;

// Concreate Flyweight (Class) - implements the Flyweight interface and stores intrinsic state.
public class RoboticDog implements IRobot {
    // Intrinsic data -> shared date -> common to all objects
    private final String type; // Humanoid or robotic dog
    private final Sprites body; // Small 2d bitmap (graphic element)

    RoboticDog(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }

    @Override
    public void display(int x, int y) {
        // Use the robotic dog sprites object
        // and x, y to render the image
        System.out.println("Displaying " + type + " at " + x + " " + y);
    }
}