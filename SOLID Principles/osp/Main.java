package osp;

public class Main {
        public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        AreaCalculator calc = new AreaCalculator();
        System.out.printf("Circle Area: %.2f\n",calc.calculateArea(circle));
        System.out.println("Rectangle Area: " + calc.calculateArea(rectangle));
    }
}
