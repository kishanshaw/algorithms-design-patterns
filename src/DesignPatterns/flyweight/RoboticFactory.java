package DesignPatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class RoboticFactory {
    private static final Map<String, IRobot> typeVsBodyMap = new HashMap<>();

    public static IRobot createRobot(String type, String body) {
        if (typeVsBodyMap.containsKey(type)) {
            return typeVsBodyMap.get(type);
        } else {
            if (type.equalsIgnoreCase("HUMANOID")) {
                IRobot humanoid = new HumanoidRobot("HUMANOID", body);
                typeVsBodyMap.put("HUMANOID", humanoid);
                return humanoid;
            } else if (type.equalsIgnoreCase("ROBOTIC_DOG")) {
                IRobot roboticDog = new RoboticDog("ROBOTIC_DOG", body);
                typeVsBodyMap.put("ROBOTIC_DOG", roboticDog);
                return roboticDog;
            }
        }
        return null;
    }
}
