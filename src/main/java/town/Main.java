package town;

import java.lang.reflect.Array;
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
        ShortToFullName.put("XX", "CaseGrisee");

        //association nom de map -> map
        HashMap<String, String[][]> mapCatalogue = new HashMap<String, String[][]>();

        //position de la maison par map
        HashMap<String, int[]> posHouse= new HashMap<String,int[]>();


        String[][] map1 = { {"FO", "BA", "FO", "FO", "FO", "FO", "FO", "FO", "FO", "EA"},
                            {"TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "EA"},
                            {"TR", "XX", "XX", "XX", "RO", "TR", "RO", "RO", "TR", "EA"},
                            {"TR", "TR", "TR", "TR", "RO", "BI", "EA", "RO", "TR", "FO"},
                            {"EA", "EA", "FO", "XX", "RO", "FO", "EA", "RO", "TR", "FO"},
                            {"FO", "EA", "EA", "XX", "RO", "FO", "UN", "RO", "FO", "MA"},
                            {"FO", "TR", "TR", "TR", "RO", "RO", "TR", "RO", "TR", "EA"},
                            {"FO", "TR", "RO", "RO", "RO", "TR", "TR", "RO", "TR", "EA"},
                            {"FO", "TR", "RO", "TR", "TR", "XX", "TR", "RO", "TR", "EA"},
                            {"FO", "TR", "TR", "TR", "FA", "FO", "TR", "TR", "TR", "EA"}};

        mapCatalogue.put("map1", map1);
        int[] pos1 = {5, 9};
        posHouse.put("map1", pos1);


        String[][] map2 = { {"FO", "FO", "FO", "FO", "EA", "EA", "FO", "FO", "FO", "MA"},
                            {"FO", "TR", "FO", "FO", "FO", "FO", "FO", "FO", "XX", "XX"},
                            {"FO", "TR", "RO", "RO", "RO", "EA", "EA", "FO", "FO", "XX"},
                            {"FO", "TR", "RO", "FO", "FO", "FO", "EA", "EA", "FO", "FO"},
                            {"FO", "TR", "TR", "TR", "FA", "FO", "FO", "EA", "EA", "EA"},
                            {"XX", "TR", "RO", "TR", "TR", "TR", "TR", "EA", "EA", "BA"},
                            {"XX", "TR", "RO", "RO", "RO", "RO", "TR", "EA", "EA", "EA"},
                            {"XX", "TR", "RO", "TR", "TR", "TR", "TR", "TR", "TR", "EA"},
                            {"BI", "TR", "RO", "TR", "FO", "FO", "FO", "FO", "RO", "RO"},
                            {"XX", "XX", "XX", "XX", "EA", "EA", "EA", "FO", "FO", "UN"}};

        mapCatalogue.put("map2", map2);
        int[] pos2 = {0, 9};
        posHouse.put("map2", pos2);


        String[][] map3 = { {"TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR"},
                            {"TR", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "TR"},
                            {"MA", "XX", "EA", "EA", "EA", "FO", "EA", "UN", "XX", "TR"},
                            {"XX", "XX", "EA", "EA", "EA", "FO", "EA", "FO", "XX", "TR"},
                            {"FO", "TR", "TR", "RO", "RO", "FO", "FO", "FO", "XX", "TR"},
                            {"FO", "XX", "TR", "TR", "RO", "XX", "XX", "FO", "XX", "TR"},
                            {"FO", "FO", "EA", "TR", "RO", "RO", "XX", "FO", "XX", "TR"},
                            {"FO", "XX", "XX", "TR", "FO", "FO", "FO", "FO", "XX", "FA"},
                            {"FO", "FO", "XX", "TR", "XX", "XX", "XX", "XX", "XX", "TR"},
                            {"BA", "BI", "XX", "TR", "TR", "TR", "TR", "TR", "TR", "TR"}};

        mapCatalogue.put("map3", map3);
        int[] pos3 = {2, 0};
        posHouse.put("map3", pos3);


        Scanner mapChoixScanner = new Scanner(System.in);

        String mapChoix;

        System.out.println("Quelle map voulez-vous charger ? (map1, map2, map3) :");
        while (!Pattern.matches("map1|map2|map3", mapChoix = mapChoixScanner.nextLine())){
            System.out.println("Map inexistante !");
            System.out.println("Quelle map voulez-vous charger ? (map1, map2, map3) :");
        }


        for(int i=0; i < map1.length; i++){
            for(int j=0; j < map1[0].length; j++){
                honeyWood.addCase(i, j, ShortToFullName.get(mapCatalogue.get(mapChoix)[i][j]));
            }
        }

        //Standard me = new Standard(honeyWood.getCase(5 , 9), true, true, true);
        //Hippie me = new Hippie(honeyWood.getCase(5,9), true, true, true);
        //HommePresse me = new HommePresse(honeyWood.getCase(5,9), true, true, true);

        boolean pickType = false;
        boolean pickPermis = false;
        boolean pickVelo = false;
        boolean pickMaillot = false;

        Scanner pType = new Scanner(System.in);

        boolean permisVal = false;
        boolean veloVal = false;
        boolean maillotVal = false;

        Personnage me = null;
        while(!pickType) {

            System.out.println("Veuillez choisir un type de personnage (disponible: Standard, Hippie ou HommePresse).");
            String str = pType.nextLine();
            System.out.println("Vous avez choisi le type : " + str);
            if(str.equals("Standard") || str.equals("Hippie") || str.equals("HommePresse")) {

                pickType = true;
                while(!pickPermis) {
                    System.out.println("Voulez-vous que votre personnage ai le permis ? (oui/non)");
                    String reponse = pType.nextLine();

                    if(reponse.equals("oui") || reponse.equals("non")) {
                        if(reponse.equals("oui")) {
                            permisVal = true;
                        }
                        else {
                            permisVal = false;
                        }
                        pickPermis = true;
                    }
                    else {
                        System.out.println("Erreur: '" + reponse + "' n'est pas un choix valide.");
                    }
                }
                while(!pickVelo) {
                    System.out.println("Voulez-vous que votre personnage ai un vélo ? (oui/non)");
                    String reponse = pType.nextLine();
                    if(reponse.equals("oui") || reponse.equals("non")) {
                        if(reponse.equals("oui")) {
                            veloVal = true;
                        }
                        else {
                            veloVal = false;
                        }
                        pickVelo = true;
                    }
                    else {
                        System.out.println("Erreur: '" + reponse + "' n'est pas un choix valide.");
                    }
                }

                while(!pickMaillot) {
                    System.out.println("Voulez-vous que votre personnage ai un maillot ? (oui/non)");
                    String reponse = pType.nextLine();
                    if(reponse.equals("oui") || reponse.equals("non")) {
                        if(reponse.equals("oui")) {
                            maillotVal = true;
                        } else {
                            maillotVal = false;
                        }
                        pickMaillot = true;
                    } else {
                        System.out.println("Erreur: '" + reponse + "' n'est pas un choix valide. ");
                    }
                }
                Class[] type = {Case.class, boolean.class, boolean.class, boolean.class};
                Object[] obj = {honeyWood.getCase(posHouse.get(mapChoix)[0], posHouse.get(mapChoix)[1]), permisVal, veloVal, maillotVal};
                me = (Personnage) Class.forName("town."+str).getDeclaredConstructor(type).newInstance(obj);
            } else {
                System.out.println("Erreur: '" + str + "' n'est pas un choix valide. Rappel des types disponible: Standard, Hippie ou HommePresse");
            }
        }

        String input;
        Scanner clavier = new Scanner(System.in);


        showVille(honeyWood, map1, me);
        System.out.println(me);

        System.out.println("Commandes : z, q, s, d, velo, voiture, pieds");
        System.out.println("Début simulation");

        while (me.getVie() != 0 && me.getHydratation() != 0  && me.getSatiete() != 0 && me.getMoral() != 0){
            System.out.println("Saisissez une commande : ");
            input = clavier.nextLine();
            if(Pattern.matches("velo|voiture|pieds", input)){
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
            else if(Pattern.matches("z|q|s|d", input)){
                if(me.seDeplacer(input, honeyWood)) {
                    System.out.println(me);
                    showVille(honeyWood, map1, me);
                }else{
                    System.out.println("Impossible de se déplacer ici");
                }
            }else{
                System.out.println("Commande incorrecte !");
                System.out.println("Commandes : z, q, s, d, velo, voiture, pieds");
            }
        }

        System.out.println("Ohhhh.. Vous êtes mort");
        System.out.println("Voici votre etat actuel:");
        System.out.println(me);


    }
}
