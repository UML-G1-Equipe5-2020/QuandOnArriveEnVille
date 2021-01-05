package town;

public class Foret extends CaseDeDeplacement{

    public Foret() {
        this.setModeDeplacement("Pied");
    }

    @Override
    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement == "Velo" || modeDeplacement == "Pied") {
            super.setModeDeplacement(modeDeplacement);
        }
    }


    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement == "Velo" || modeDeplacement == "Pied") {
            return super.changeModeDeplacement(pers, modeDeplacement);
        }
        return false;
    }

    public void suru(Personnage pers){
        switch(getModeDeplacement()){
            case "Pied":
                pers.updateValue("hydratation", -10);
                pers.updateValue("satiete", -10);
            case "Velo":
                pers.updateValue("hydratation", -5);
                pers.updateValue("satiete", -5);
                if (Math.random() <= 0.002){
                    pers.mourir();
                }
        }
        determinerPiege(pers);
    }


    public void determinerPiege(Personnage pers) {
        if (Math.random() <= 0.05){
            double alea = Math.random();
            if (alea <= 0.10){
                pers.updateValue("vie", -10);
            }
        }
    }
}
