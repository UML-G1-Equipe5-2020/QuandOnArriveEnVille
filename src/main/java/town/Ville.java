package town;

import java.lang.reflect.Type;
import java.util.HashMap;

public class Ville {
    static HashMap<Class, Boolean> batiments = new HashMap<Class, Boolean>();
    private Case[][] listeCase;

    public Ville()
    {
        listeCase = new Case[10][10];
    }


    public void addCase(int ligne, int colonne, String classType) throws Exception {
        this.listeCase[ligne][colonne] = (Case) Class.forName(classType).newInstance();
    }

    public static void setBatiments(Class c, Boolean bool) {
        batiments.put(c, bool);
    }

    public static HashMap<Class, Boolean> getBatiments() {
        return batiments;
    }
}
