package town;

public class Foret extends CaseDeDeplacement{

    public Foret(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("pieds");
    }

    @Override
    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            super.setModeDeplacement(modeDeplacement);
        }
    }


    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            return super.changeModeDeplacement(pers, modeDeplacement);
        }
        return false;
    }

    public void suru(Personnage pers){
        System.out.println("Loup y es-tu ?");
        switch(getModeDeplacement()){
            case "pieds":
                pers.updateValue("hydratation", (int) (-10*pers.getFacteurDePerte()));
                pers.updateValue("satiete", (int) (-10*pers.getFacteurDePerte()));
                break;
            case "velo":
                pers.updateValue("hydratation", (int) (-5*pers.getFacteurDePerte()));
                pers.updateValue("satiete", (int) (-5*pers.getFacteurDePerte()));
                if (Math.random() <= 0.002){
                    pers.mourir();
                }
                break;
        }
        determinerPiege(pers);
    }


    public void determinerPiege(Personnage pers) {
        if (Math.random() <= 0.10){
            System.out.println("Kof Kof ! Arggh vous êtes malade (-10 points de vie)");
            pers.updateValue("vie", -10);
        }
    }

    @Override
    public String toString() {
        return  "FO";
    }
}
