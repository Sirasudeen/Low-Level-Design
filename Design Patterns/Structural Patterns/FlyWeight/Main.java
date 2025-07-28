package FlyWeight;
public class Main {
    public static void main(String[] args) {
            Forest forest = new Forest();
            forest.PlantTree(1,1,"Oak","Green");
            forest.PlantTree(2, 2, "Pine", "Green");
            for(int i = 0; i<5;i++)
            {
                forest.PlantTree(i+1, i-1,"Banyan","Green");
            }
            forest.draw();
    }
}
