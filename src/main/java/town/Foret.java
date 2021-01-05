package town;

public class Foret extends CaseDeDeplacement{

    public Foret(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("Pied");
    }

    @Override
    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement.equals("Velo") || modeDeplacement.equals("Pied")) {
            super.setModeDeplacement(modeDeplacement);
        }
    }


    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("Velo") || modeDeplacement.equals("Pied")) {
            return super.changeModeDeplacement(pers, modeDeplacement);
        }
        return false;
    }

    public void suru(Personnage pers){
        System.out.println("Loup y es-tu ?");
        switch(getModeDeplacement()){
            case "Pied":
                pers.updateValue("hydratation", -10);
                pers.updateValue("satiete", -10);
                break;
            case "Velo":
                pers.updateValue("hydratation", -5);
                pers.updateValue("satiete", -5);
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
