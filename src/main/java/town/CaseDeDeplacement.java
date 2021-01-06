package town;

import java.util.HashMap;

public abstract class CaseDeDeplacement extends Case{
    //private String modeDeplacement;
    private HashMap<Class, String> modeDeplacement = new HashMap<>();

    public CaseDeDeplacement(int ligne, int colonne){
        super(ligne, colonne);
        this.modeDeplacement.put(Foret.class, "pieds");
        this.modeDeplacement.put(Route.class, "voiture");
        this.modeDeplacement.put(Trottoir.class, "pieds");
    }

    public void setModeDeplacement(String modeDeplacement, Class theCase) {
        if(modeDeplacement.equals("voiture") || modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            this.modeDeplacement.replace(theCase, modeDeplacement);
        }
    }


    public String getModeDeplacement(CaseDeDeplacement theCase) {
        return modeDeplacement.get(theCase.getClass());
    }


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

    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("voiture") && pers.getPermis() && pers.getClass() != town.Hippie.class) {
            this.modeDeplacement.put(pers.getCase().getClass(), modeDeplacement);
            return true;
        }else if(modeDeplacement.equals("velo") && pers.getVelo()){
            this.modeDeplacement.put(pers.getCase().getClass(), modeDeplacement);
            return true;
        }else if(modeDeplacement.equals("pieds")){
            this.modeDeplacement.put(pers.getCase().getClass(), modeDeplacement);
            return true;
        }
        return false;
    }
}
