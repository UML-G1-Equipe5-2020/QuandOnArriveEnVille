package town;

public class Trottoir extends CaseDeDeplacement implements Piege{


    public Trottoir() {
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
                if (Math.random() <= 0.005){
                    pers.mourir();
                }
        }
        determinerPiege(pers);
    }

    @Override
    public void determinerPiege(Personnage pers) {
        if (Math.random() <= 0.05){
            double alea = Math.random();
            if (alea <= 0.33){
                pers.updateValue("vie", -3);
            }else if (0.33 <= alea && alea <= 0.66) {
                pers.updateValue("moral", -2);
            }else{
                pers.updateValue("satiete", -1);
            }
        }
    }

}
