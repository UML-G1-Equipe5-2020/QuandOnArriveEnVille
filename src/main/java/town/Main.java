package town;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void showVille(Ville honeyWood, String[][] map1, Personnage me) {
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[0].length; j++) {
                if (honeyWood.getCase(i, j) == me.getCase()) {
                    System.out.print("(");
                } else {
                    System.out.print(" ");
                }
                honeyWood.showCase(i, j);
                if (honeyWood.getCase(i, j) == me.getCase()) {
                    System.out.print(")");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

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
                            {"TR", "RO", "RO", "RO", "RO", "TR", "RO", "RO", "TR", "EA"},
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
                honeyWood.addCase(i, j, ShortToFullName.get(map1[i][j]));
            }
        }

        Standard me = new Standard(honeyWood.getCase(5 , 9), true, true, true);


        String input;
        Scanner clavier = new Scanner(System.in);


        showVille(honeyWood, map1, me);
        System.out.println(me);

        System.out.println("Début simulation");

        while (true){
            input = clavier.nextLine();
            if(Pattern.matches("Velo|Voiture|Pied", input)){
                try {
                    if (!((CaseDeDeplacement) me.casePersonnage).changeModeDeplacement(me, input)) {
                        System.out.println("Mode de déplacement indisponible pour cette case");
                    } else {
                        System.out.println("Vous vous déplacez maintenant en " + input);
                    }
                }catch(Exception e){
                    System.out.println("On se déplace toujours à pieds dans un batiment...");
                }
            }
            else if(me.seDeplacer(input, honeyWood)) {
                System.out.println(me);
                System.out.println(me.getCase());

                showVille(honeyWood, map1, me);
            }else{
                System.out.println("Commande incorrecte !");
            }
        }





    }
}
