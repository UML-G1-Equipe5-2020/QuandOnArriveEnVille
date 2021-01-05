package town;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Ville {
    static HashMap<Class, Boolean> batiments = new HashMap<Class, Boolean>();

    private Case[][] listeCase;


    public int getLengthOfLigne(){
        return listeCase.length;
    }


    public int getLengthOfColonne(){
        return listeCase[0].length;
    }


    public Ville()
    {
        listeCase = new Case[10][10];
    }


    public void addCase(int ligne, int colonne, String classType) throws Exception {
        //this.listeCase[ligne][colonne] = (Case) Class.forName("town."+classType).newInstance(ligne, colonne);

        Class[] type = { int.class, int.class};
        Class classDefinition = Class.forName("town."+classType);
        Constructor cons = classDefinition .getConstructor(type);
        Object[] obj = {ligne, colonne};
        this.listeCase[ligne][colonne] = (Case) cons.newInstance(obj);
    }


    public Case getCase(int ligne, int colonne) {
        return listeCase[ligne][colonne];
    }


    public void showCase(int ligne, int colonne){
        System.out.println(this.listeCase[ligne][colonne]);
    }


    public static void setBatiments(Class c, Boolean bool) {
        batiments.put(c, bool);
    }

    public static HashMap<Class, Boolean> getBatiments() {
        return batiments;
    }
}
