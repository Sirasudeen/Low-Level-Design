package FlyWeight;

import java.util.HashMap;
public class TreeFactory {
    static HashMap<String,TreeType> mp = new HashMap<>();

    public static TreeType getTreeType(String name,String color){
        String key = name + color;
        if(mp.containsKey(key)){
            return mp.get(key);
        }
        else{
            TreeType treeType = new TreeType(name,color);
            mp.put(key,treeType);
            return treeType;
        }
    }
}
