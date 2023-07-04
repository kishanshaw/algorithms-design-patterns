package DesignPatterns.flyweight;

public class RoboticDog implements IRobot {

    private final String type;
    private final String body;

    public RoboticDog(String type, String body) {
        this.type = type;
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public String getBody() {
        return body;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("The dog robot is position x: " + x + "+ y:" + y);
    }
}
