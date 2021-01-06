package town;

public class Foret extends CaseDeDeplacement{

    public Foret(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("pieds");
    }


    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            super.setModeDeplacement(modeDeplacement, Foret.class);
        }
    }


    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            return super.changeModeDeplacement(pers, modeDeplacement);
        }
        return false;
    }

    public void suru(Personnage pers){
        super.suru(pers);
        System.out.println("Loup y es-tu ?");
        switch(getModeDeplacement((CaseDeDeplacement) pers.casePersonnage)){
            case "pieds":
                pers.updateValue("hydratation", (int) (-3*pers.getFacteurDePerte()));  // 3 au lieu de 10
                pers.updateValue("satiete", (int) (-3*pers.getFacteurDePerte()));  // 3 au lieu de 10
                break;
            case "velo":
                pers.updateValue("hydratation", (int) (-2*pers.getFacteurDePerte()));  // 2 au lieu de 5
                pers.updateValue("satiete", (int) (-2*pers.getFacteurDePerte()));  // 2 au lieu de 5
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
