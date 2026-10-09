package RoboticGame.Solution;

import java.util.HashMap;
import java.util.Map;

public class RoboticFactory {
    private static final Map<String, IRobot> roboticObjectCache = new HashMap<>();

    public static IRobot createRobot(String robotType) {
        if (roboticObjectCache.containsKey(robotType)) {
            // if exists, return the cached object;
            return roboticObjectCache.get(robotType);
        } else {
            // If not exists, create the object and cache it
            if (robotType.equals("HUMANOID")) {
                Sprites humanoidSprite = new Sprites();
                IRobot humanoidObject = new HumanoidRobot(robotType, humanoidSprite);

                // Add to cache
                roboticObjectCache.put(robotType, humanoidObject);
                return humanoidObject;
            } else if (robotType.equals("ROBOTIC_DOG")) {
                Sprites roboticDogSprite = new Sprites();
                IRobot roboticDogObject = new RoboticDog(robotType, roboticDogSprite);

                // Add to cache
                roboticObjectCache.put(robotType, roboticDogObject);
                return roboticDogObject;
            }
        }

        throw new IllegalArgumentException("Invalid robot type: " + robotType);
    }

    public static int getTotalRobots() {
        return roboticObjectCache.size();
    }
}