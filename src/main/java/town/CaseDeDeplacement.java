package town;

import java.util.HashMap;

public abstract class CaseDeDeplacement extends Case{
    private static HashMap<Class, String> modeDeplacement = new HashMap<>();  // fait correspondre un mode de déplacement à chaque type de case de déplacement

    public CaseDeDeplacement(int ligne, int colonne){
        super(ligne, colonne);
        // force un mode de deplacement par defaut pour Foret, Route et Trottoir
        modeDeplacement.put(Foret.class, "pieds");
        modeDeplacement.put(Route.class, "voiture");
        modeDeplacement.put(Trottoir.class, "pieds");
    }

    // Initialise le mode de deplacement pour un type de case de deplacement
    // Paramètre : le mode de deplacement et le type de case
    public void setModeDeplacement(String modeDeplacement, Class theCase) {
        if(modeDeplacement.equals("voiture") || modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            CaseDeDeplacement.modeDeplacement.replace(theCase, modeDeplacement);  // change le mode de déplacement pour le type de case donné
        }
    }

    // retourne le type de mode de déplacement pour la case donnée en paramètre
    public String getModeDeplacement(CaseDeDeplacement theCase) {
        return modeDeplacement.get(theCase.getClass());
    }


    // suru = "faire" en japonais -> procède aux actions de la case lors du déplacement sur une case
    // Affiche le mode de déplacement utilisé pour se déplacer sur la case
    public void suru(Personnage pers){
        switch (modeDeplacement.get(pers.getCase().getClass())){
            case "voiture":
                System.out.print("Vous êtes en ");
                break;
            case "velo":
            case "pieds":
                System.out.print("Vous êtes à ");
        }
        System.out.println(modeDeplacement.get(pers.getCase().getClass()));
    }


    // Change le mode de deplacement pour le type de case sur lequel se trouve le personnage
    // Verifie si le mode de deplacement est voiture, velo ou pieds
    // vérifie pour chaque mode de déplacement si le personnage est autorisé à l'utiliser
    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("voiture") && pers.getPermis() && pers.getClass() != town.Hippie.class) {
            // si "voiture" et le personnage a un permis et n'est pas un hippie -> met déplacement à voiture
            CaseDeDeplacement.modeDeplacement.put(pers.getCase().getClass(), modeDeplacement);
            return true;
        }else if(modeDeplacement.equals("velo") && pers.getVelo()){
            // si "velo" et le personnage a un velo -> met déplacement à velo
            CaseDeDeplacement.modeDeplacement.put(pers.getCase().getClass(), modeDeplacement);
            return true;
        }else if(modeDeplacement.equals("pieds")){
            // si "pieds" -> met déplacement à velo
            CaseDeDeplacement.modeDeplacement.put(pers.getCase().getClass(), modeDeplacement);
            return true;
        }
        return false;
    }
}
