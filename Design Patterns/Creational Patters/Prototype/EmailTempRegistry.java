package Prototype;

import java.util.HashMap;

public class EmailTempRegistry  {
    private static final HashMap<String,EmailTemplate> mp = new HashMap<>();

    static{
        mp.put("welcome",new WelcomeTemplate());
    }
    public static EmailTemplate getTemplate(String type)
    {
        return mp.get(type).clone();
    }
}
