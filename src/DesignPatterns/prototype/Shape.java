package DesignPatterns.prototype;

public abstract class Shape {
    private int x;
    private int y;

    public Shape() {
    }

    public Shape(Shape existingShape) {
        if (existingShape != null) {
            this.x = existingShape.x;
            this.y = existingShape.y;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Shape)) {
            return false;
        }
        Shape other = (Shape) o;
        return other.x == this.x && other.y == this.y;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
