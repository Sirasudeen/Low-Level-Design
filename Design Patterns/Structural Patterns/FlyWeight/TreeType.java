package FlyWeight;

public class TreeType {
    private String name;
    private String color;
    
    public TreeType(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " " + name + " tree at (" + x + ", " + y + ")");
    }
}
