package DesignPatterns.flyweight;

public class HumanoidRobot implements IRobot {
    private final String type;
    private final String body;

    public HumanoidRobot(String type, String body) {
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
        System.out.println("The humanoid robot is position x: " + x + "+ y:" + y);
    }
}
