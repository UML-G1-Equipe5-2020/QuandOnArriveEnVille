package town;

import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws Exception {
        Ville honeyWood = new Ville();

        HashMap<String, String> ShortToFullName = new HashMap<String, String>();

        ShortToFullName.put("BA", "Bar");
        ShortToFullName.put("BI", "Bibliotheque");
        ShortToFullName.put("EA", "Eau");
        ShortToFullName.put("FA", "FastFood");
        ShortToFullName.put("FO", "Foret");
        ShortToFullName.put("MA", "Maison");
        ShortToFullName.put("RO", "Route");
        ShortToFullName.put("TR", "Trottoir");
        ShortToFullName.put("UN", "Universite");

        String[][] map1 = { {"FO", "BA", "FO", "FO", "FO", "FO", "FO", "FO", "FO", "EA"},
                            {"TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "EA"},
                            {"TR", "RO", "RO", "RO", "RO", "RO", "RO", "RO", "TR", "EA"},
                            {"TR", "TR", "TR", "TR", "RO", "BI", "EA", "RO", "TR", "FO"},
                            {"EA", "EA", "FO", "TR", "RO", "FO", "EA", "RO", "TR", "FO"},
                            {"FO", "EA", "EA", "TR", "RO", "FO", "UN", "RO", "FO", "MA"},
                            {"FO", "TR", "TR", "TR", "RO", "RO", "TR", "RO", "TR", "EA"},
                            {"FO", "TR", "RO", "RO", "RO", "TR", "TR", "RO", "TR", "EA"},
                            {"FO", "TR", "RO", "TR", "TR", "TR", "TR", "RO", "TR", "EA"},
                            {"FO", "TR", "TR", "TR", "FA", "FO", "TR", "TR", "TR", "EA"}};

        /*
        honeyWood.addCase(0, 0, "Bar");
        honeyWood.addCase(0, 1, "Trottoir");
        honeyWood.addCase(0, 2, "Maison");

        */

        for(int i=0; i < map1.length; i++){
            for(int j=0; j < map1[0].length; j++){
                honeyWood.addCase(j, i, ShortToFullName.get(map1[i][j]));
            }
        }

        Standard me = new Standard(honeyWood.getCase(9 , 5), true, true, true);

        for(int i=0; i < map1.length; i++){
            for(int j=0; j < map1[0].length; j++){
                if(honeyWood.getCase(j, i) == me.getCase()){
                    System.out.print("(");
                }else {
                    System.out.print(" ");
                }
                honeyWood.showCase(j, i);
                if(honeyWood.getCase(j, i) == me.getCase()){
                    System.out.print(")");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        /*
        Standard me = new Standard(honeyWood.getCase(0 , 2), true, true, true);
        System.out.println(me);
        System.out.println(me.getCase());

        System.out.println(me.seDeplacer("left", honeyWood));
        System.out.println(me);
        System.out.println(me.getCase());

        System.out.println(me.seDeplacer("right", honeyWood));
        System.out.println(me);
        System.out.println(me.getCase());

        System.out.println(me.seDeplacer("left", honeyWood));
        System.out.println(me);
        System.out.println(me.getCase());

        System.out.println(honeyWood.getCase(0,1));
        System.out.println(honeyWood.getCase(0,2));
        System.out.println(honeyWood.getCase(0,3));
        */
    }
}
