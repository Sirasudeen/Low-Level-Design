package osp;

public class Circle implements Shape {
    private double radius;
    public Circle(double r) { radius = r; }

    public double area() {
        return Math.PI * radius * radius;
    }
}