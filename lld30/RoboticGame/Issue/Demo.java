package RoboticGame.Issue;

public class Demo {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        // Create 5L humanoid robots
        for (int i = 0; i < 500000; i++) {
            Sprites humanoidSprite = new Sprites();
            Robot humanoidRobot = new Robot(x + i, y + i, "HUMANOID", humanoidSprite);
        }

        // Create 5L robotic dog robots
        for (int i = 0; i < 500000; i++) {
            Sprites roboticDogSprite = new Sprites();
            Robot roboticDog = new Robot(x + i, y + i, "HUMANOID", roboticDogSprite);
        }

        // A total of 10L robots created will result in 10L Sprite objects created
        // which will consume a lot of memory;
    }
}