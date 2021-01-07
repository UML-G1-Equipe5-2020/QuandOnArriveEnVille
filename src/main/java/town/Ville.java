package town;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Ville {
    //hashmap permettant de savoir si chaque batiment a été instancié une et une seule fois
    //elle n'est pas utilisée ici car la map est codée en brut, mais si elle était aléatoire, elle pourrait être utilisée
    static HashMap<Class, Boolean> batiments = new HashMap<Class, Boolean>();

    //Matrice de cases formant la ville
    private Case[][] listeCase;

    //renvoie le nombre de ligne de la matrice
    public int getLengthOfLigne(){
        return listeCase.length;
    }

    //renvoie le nombre de colonne de la matrice
    public int getLengthOfColonne(){
        return listeCase[0].length;
    }

    //constructeur qui initialise liste case
    public Ville()
    {
        listeCase = new Case[10][10];
    }

    //ajouter une case dans listeCase
    public void addCase(int ligne, int colonne, String classType) throws Exception {
        Class[] type = { int.class, int.class};
        Object[] obj = {ligne, colonne};
        this.listeCase[ligne][colonne] = (Case) Class.forName("town."+classType).getDeclaredConstructor(type).newInstance(obj);
    }


    public Case getCase(int ligne, int colonne) {
        return listeCase[ligne][colonne];
    }

    public void showCase(int ligne, int colonne){
        System.out.print(this.listeCase[ligne][colonne]);
    }


    public static void setBatiments(Class c, Boolean bool) {
        batiments.put(c, bool);
    }

    public static HashMap<Class, Boolean> getBatiments() {
        return batiments;
    }
}
