package FlyWeight;

import java.util.ArrayList;
public class Forest {
    private ArrayList<Tree> trees = new ArrayList<>();
    public void PlantTree(int x,int y,String name,String color)
    {
        TreeType type = TreeFactory.getTreeType(name,color);
        Tree tree = new Tree(x,y,type);
        trees.add(tree);
    }
    
    public void draw(){
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}
