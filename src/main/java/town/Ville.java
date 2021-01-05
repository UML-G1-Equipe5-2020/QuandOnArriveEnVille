package town;

import java.util.HashMap;

public class Ville {
    static HashMap<Class, Boolean> batiments = new HashMap<Class, Boolean>();
    private Case[][] test;

    public Ville()
    {
        test = new Case[10][10];
    }

    public static void setBatiments(Class c, Boolean bool) {
        batiments.put(c, bool);
    }

    public static HashMap<Class, Boolean> getBatiments() {
        return batiments;
    }
}
