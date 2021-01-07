package town;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    // Procède à un affichage de la ville
    public static void showVille(Ville honeyWood, String[][] map1, Personnage me) {
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[0].length; j++) {
                if (honeyWood.getCase(i, j) == me.getCase()) {  // Si le personnage est sur la case, l'afficher entre parenthèses
                    System.out.print("(");
                } else {
                    System.out.print(" ");
                }
                honeyWood.showCase(i, j);
                if (honeyWood.getCase(i, j) == me.getCase()) {
                    System.out.print(")");  // Si le personnage est sur la case, l'afficher entre parenthèses
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String args[]) throws Exception {
        Ville honeyWood = new Ville();  // notre ville

        // HashMap faisant correspondre un surnom (eg. "BI") à un nom de Case (eg. "Bibliotheque")
        HashMap<String, String> ShortToFullName = new HashMap<String, String>();

        // Population du HashMap ShortToFullName avec les correspondance surnom -> nom de Case
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

        // Une map corresponds à la représentation d'une ville par un tableau de surnom de case

        // Définition de la map1 (carte )
        String[][] map1 = { {"FO", "BA", "FO", "FO", "FO", "FO", "FO", "FO", "FO", "EA"},
                            {"TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "EA"},
                            {"TR", "XX", "XX", "XX", "RO", "TR", "RO", "RO", "TR", "EA"},
                            {"TR", "TR", "TR", "TR", "RO", "BI", "EA", "RO", "TR", "FO"},
                            {"EA", "EA", "FO", "XX", "RO", "FO", "EA", "RO", "TR", "FO"},
                            {"FO", "EA", "EA", "XX", "RO", "FO", "UN", "RO", "TR", "MA"},
                            {"FO", "TR", "TR", "TR", "RO", "RO", "TR", "RO", "TR", "EA"},
                            {"FO", "TR", "RO", "RO", "RO", "TR", "TR", "RO", "TR", "EA"},
                            {"FO", "TR", "RO", "TR", "TR", "XX", "TR", "RO", "TR", "EA"},
                            {"FO", "TR", "TR", "TR", "FA", "FO", "TR", "TR", "TR", "EA"}};

        mapCatalogue.put("map1", map1);  // ajout de map1 dans la liste de maps

        // Définition de la map2 (carte )
        String[][] map2 = { {"FO", "FO", "FO", "FO", "EA", "EA", "TR", "TR", "TR", "MA"},
                            {"FO", "TR", "TR", "TR", "TR", "TR", "TR", "FO", "XX", "XX"},
                            {"FO", "TR", "RO", "RO", "RO", "EA", "EA", "FO", "FO", "XX"},
                            {"FO", "TR", "RO", "FO", "FO", "FO", "EA", "EA", "FO", "FO"},
                            {"FO", "TR", "TR", "TR", "FA", "FO", "TR", "TR", "TR", "TR"},
                            {"XX", "TR", "RO", "TR", "TR", "TR", "TR", "EA", "EA", "BA"},
                            {"XX", "TR", "RO", "RO", "RO", "RO", "TR", "EA", "EA", "EA"},
                            {"XX", "TR", "RO", "TR", "TR", "TR", "TR", "TR", "TR", "EA"},
                            {"BI", "TR", "RO", "TR", "FO", "FO", "FO", "FO", "TR", "TR"},
                            {"XX", "XX", "XX", "XX", "EA", "EA", "EA", "FO", "FO", "UN"}};

        mapCatalogue.put("map2", map2);// ajout de map2 dans la liste de maps

        // Définition de la map3 (carte )
        String[][] map3 = { {"TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR"},
                            {"TR", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "TR"},
                            {"MA", "XX", "EA", "EA", "EA", "FO", "EA", "UN", "XX", "TR"},
                            {"XX", "XX", "EA", "EA", "EA", "FO", "EA", "TR", "XX", "TR"},
                            {"TR", "TR", "TR", "TR", "TR", "TR", "TR", "TR", "XX", "TR"},
                            {"TR", "XX", "EA", "TR", "EA", "XX", "XX", "RO", "XX", "TR"},
                            {"TR", "FO", "EA", "TR", "EA", "BA", "XX", "RO", "XX", "TR"},
                            {"TR", "XX", "XX", "TR", "FO", "RO", "RO", "RO", "RO", "FA"},
                            {"TR", "TR", "XX", "TR", "XX", "XX", "XX", "XX", "XX", "TR"},
                            {"EA", "BI", "XX", "TR", "TR", "TR", "TR", "TR", "TR", "TR"}};

        mapCatalogue.put("map3", map3);// ajout de map3 dans la liste de maps

        int ligneHouse = -1;
        int colonneHouse = -1;
        Scanner mapChoixScanner = new Scanner(System.in);

        String mapChoix;  // choix de la map

        // tant que le choix de la map n'est pas valide, on demande à nouveau de choisir une map
        System.out.println("Quelle map voulez-vous charger ? (map1, map2, map3) :");
        while (!Pattern.matches("map1|map2|map3", mapChoix = mapChoixScanner.nextLine())){
            System.out.println("Map inexistante !");
            System.out.println("Quelle map voulez-vous charger ? (map1, map2, map3) :");
        }


        // Génération de la ville à partir d'une map
        for(int i=0; i < map1.length; i++){  // pour toute les lignes de map
            for (int j = 0; j < map1[0].length; j++) {  // pour toutes les colonnes d'une map
                // on ajoute une case à la ligne i et la colonne j correspondant à la bonne case
                honeyWood.addCase(i, j, ShortToFullName.get(mapCatalogue.get(mapChoix)[i][j]));
            }
        }

        // Recherche automatique des coordonnées de la maison dans la ville
        for(int i=0; i<mapCatalogue.get(mapChoix).length; i++){
            if(Arrays.asList(mapCatalogue.get(mapChoix)[i]).contains("MA")) {
                for (int j = 0; j < mapCatalogue.get(mapChoix)[0].length; j++) {
                    if (honeyWood.getCase(i, j).getClass() == town.Maison.class) {
                        // Si la ligne et colonne actuelles correcpondent à la maison
                        ligneHouse = i; // ligneHouse : ligne de la maison
                        colonneHouse = j;  // coloneHouse : colone de la maison
                    }
                }
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

        //Questionnaire pour instancier le personnage désiré avec les attributs choisis
        while(!pickType) { //tant qu'un choix correct n'est pas fait

            System.out.println("Veuillez choisir un type de personnage (disponible: Standard, Hippie ou HommePresse)."); //on demande a l'utilisateur de chosir le type de personnage qu'il souhaite jouer
            String str = pType.nextLine(); //on récupère la réponse de l'utilisateur
            System.out.println("Vous avez choisi le type : " + str); //on affiche son choix
            if(str.equals("Standard") || str.equals("Hippie") || str.equals("HommePresse")) { //on vérifie si le choix est valide

                pickType = true; //on met a true pour que la boucle s'arrête
                while(!pickPermis) { //on passe a la question suivante, avec une boucle qui continue tant qu'un choix correct n'est pas fait
                    System.out.println("Voulez-vous que votre personnage ait le permis ? (oui/non)"); //on pose la question
                    String reponse = pType.nextLine(); //on récupère la réponse de l'utilisateur

                    if(reponse.equals("oui") || reponse.equals("non")) { //on vérifie qu'il s'agit d'une réponse valide.
                        if(reponse.equals("oui")) { //si la réponse est oui
                            permisVal = true; //on met la valeur du permis pour le personnage a true: il aura le permis
                        }
                        else {
                            permisVal = false; //on met la valeur du permis pour le personnage a false: il n'aura pas le permis
                        }
                        pickPermis = true; //on met a true pour que la boucle s'arrête
                    }
                    else {
                        System.out.println("Erreur: '" + reponse + "' n'est pas un choix valide."); //on affiche un message pour dire que la réponse saisie n'est pas parmis celles attendues
                    }
                }
                while(!pickVelo) {
                    System.out.println("Voulez-vous que votre personnage ait un vélo ? (oui/non)");
                    String reponse = pType.nextLine();
                    if(reponse.equals("oui") || reponse.equals("non")) { //on vérifie si la réponse est valide
                        if(reponse.equals("oui")) { //si le choix de l'utilisateur est oui:
                            veloVal = true; //on met la valeur du vélo pour le personnage a true: il aura un vélo
                        }
                        else { //sinon
                            veloVal = false; //on met la valeur du vélo pour le personnage a false: il n'aura pas de vélo
                        }
                        pickVelo = true; //on met a true pour que la boucle s'arrête
                    }
                    else {
                        System.out.println("Erreur: '" + reponse + "' n'est pas un choix valide.");
                    }
                }

                while(!pickMaillot) {
                    System.out.println("Voulez-vous que votre personnage ait un maillot ? (oui/non)");
                    String reponse = pType.nextLine();
                    if(reponse.equals("oui") || reponse.equals("non")) { //on vérifie si la réponse est valide
                        if(reponse.equals("oui")) { //si le choix de l'utilisateur est oui:
                            maillotVal = true; //on met la valeur du maillot pour le personnage a true: il aura un maillot sur lui
                        } else { //sinon
                            maillotVal = false; //on met la valeur du maillot pour le personnage a false: il n'aura pas de maillot
                        }
                        pickMaillot = true; //on met a true pour que la boucle s'arrête
                    } else {
                        System.out.println("Erreur: '" + reponse + "' n'est pas un choix valide. ");
                    }
                }
                Class[] type = {Case.class, boolean.class, boolean.class, boolean.class}; //on créer une liste de type utilisé en argument du constructeur de personnage
                Object[] obj = {honeyWood.getCase(ligneHouse, colonneHouse), permisVal, veloVal, maillotVal}; //on lie les attributs au type dans le tableau type
                me = (Personnage) Class.forName("town."+str).getDeclaredConstructor(type).newInstance(obj); //on instancie le type de personnage avec les attributs choisis lors du questionnaire
            } else {
                System.out.println("Erreur: '" + str + "' n'est pas un choix valide. Rappel des types disponible: Standard, Hippie ou HommePresse"); //on affiche un message pour dire que la réponse saisie n'est pas parmis celles attendues
            }
        }

        String input;
        Scanner clavier = new Scanner(System.in);


        showVille(honeyWood, map1, me);  // Affichage initial de la ville
        System.out.println(me);  // affichage initial du personnage

        System.out.println("Commandes : z, q, s, d, velo, voiture, pieds, quitter");  // affichage des commandes dispo
        System.out.println("Début simulation");


        // tant qu'aucune barre n'est à 0
        while (me.getVie() != 0 && me.getHydratation() != 0  && me.getSatiete() != 0 && me.getMoral() != 0){
            // demande de saisie d'une commande
            System.out.println("Saisissez une commande : ");
            input = clavier.nextLine();
            // si la commande corresponds à un mode de deplacement
            if(Pattern.matches("velo|voiture|pieds", input)){
                // tentative de modification du déplcement
                try {
                    // Si la case refuse le mode de déplacement
                    if (!((CaseDeDeplacement) me.casePersonnage).changeModeDeplacement(me, input)) {
                        System.out.println("Mode de déplacement indisponible pour cette case");  // la case a refusé le mode de déplacement
                    } else {
                        System.out.println("Vous vous déplacez maintenant en " + input);  // le mode de déplacement a été update
                    }
                }catch(Exception e){
                    // si le try echoue, la case n'a pas pu être castée et on est dans un batiment
                    System.out.println("On se déplace toujours à pieds dans un batiment...");
                }
            }
            // Si la commande corresponds à une demande de déplacement
            else if(Pattern.matches("z|q|s|d", input)){
                if(me.seDeplacer(input, honeyWood)) {  // Si on a pu se déplacer (authorisation donnée par la case)
                    System.out.println(me);  // affiche l'etat actuel du personnage
                    showVille(honeyWood, map1, me);  // affiche l'etat actuel de la ville
                }else{  // Si la case refuse le déplacement
                    System.out.println("Impossible de se déplacer ici");
                }
            }
            else if(Pattern.matches("quitter", input)){  // si la commande est "quitter"
                break;   // on sort de la boucle et on meurt
            }else{  // Dans les autres cas, la commande n'est pas reconnue
                System.out.println("Commande incorrecte !");
                System.out.println("Commandes : z, q, s, d, velo, voiture, pieds");
            }
        }

        System.out.println("Ohhhh.. Vous êtes mort");  // le personnage est mort
        System.out.println("Voici votre etat actuel:");  // on affiche son état final
        System.out.println(me);


    }
}
