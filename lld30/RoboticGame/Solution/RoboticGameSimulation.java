package RoboticGame.Solution;

// Client - supplies extrinsic state when using flyweights
public class RoboticGameSimulation {
    public static void main(String[] args) {
        System.out.println("=====> Flyweight Design Pattern <=====");
        // Factory pattern is used to create object
        // Flywieght pattern is used to reuse objects

        // Create 2 Humanoid robots and provide display coordinates(extrinsic state) at
        // runtime
        IRobot humanoidRobot1 = RoboticFactory.createRobot("HUMANOID");
        humanoidRobot1.display(1, 2);
        IRobot humanoidRobot2 = RoboticFactory.createRobot("HUMANOID");
        humanoidRobot2.display(10, 30);

        // Create 2 Robotic Dog robots and provide display coordinates(extrinsic state)
        // at
        // runtime
        IRobot roboticDog1 = RoboticFactory.createRobot("ROBOTIC_DOG");
        roboticDog1.display(2, 9);
        IRobot roboticDog2 = RoboticFactory.createRobot("ROBOTIC_DOG");
        roboticDog2.display(11, 19);

        System.out.println("Total robots created: " + RoboticFactory.getTotalRobots());
    }
}