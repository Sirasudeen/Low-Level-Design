package osp;

public class Rectangle implements Shape {
    private double length, breadth;
    public Rectangle(double l, double b) {
        length = l;
        breadth = b;
    }

    public double area() {
        return length * breadth;
    }
}