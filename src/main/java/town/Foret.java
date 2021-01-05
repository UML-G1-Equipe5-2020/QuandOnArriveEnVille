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

    @Override
    public void changeModeDeplacement(String modeDeplacement) {
        if(modeDeplacement == "Velo" || modeDeplacement == "Pied") {
            super.changeModeDeplacement(modeDeplacement);
        }
    }

    public void suru(Personnage pers){
        switch(getModeDeplacement()){
            case "Pied":
                pers.updateValue"hydratation", -10);
                pers.updateValue("satiete", -10);
            case "Velo":
                pers.updateValue("hydratation", -5);
                pers.updateValue("satiete", -5);
                if (Math.random() <= 0.002){
                    pers.mourrir();
                }
        }
    }


    @Override
    public void determinerPiege() {
        if (Math.random() <= 0.05){
            int alea = Math.random()
            if (alea <= 0.10){
                pers.updateValue("vie", -10);
            }
        }
    }
}
