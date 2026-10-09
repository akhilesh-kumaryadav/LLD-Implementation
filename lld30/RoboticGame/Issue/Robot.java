package RoboticGame.Issue;

public class Robot {
    // Extrinsic data
    int coordinateX;
    int coordinateY;

    // Interinsic Data
    String type;
    Sprites body; // -> Heavy-weight object - 2D bitmap image

    public Robot(int coordinateX, int coordinateY, String type, Sprites body) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.type = type;
        this.body = body;
    }

    // getter and setter
}