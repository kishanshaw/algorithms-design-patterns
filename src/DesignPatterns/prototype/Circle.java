package DesignPatterns.prototype;

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(Circle existingCircle) {
        super(existingCircle);
        if (existingCircle != null) {
            this.radius = existingCircle.radius;
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }
}
