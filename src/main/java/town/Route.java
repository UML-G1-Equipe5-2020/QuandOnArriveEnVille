package town;

public class Route extends CaseDeDeplacement implements Piege{

    public Route() {
        this.setModeDeplacement("Voiture");
    }

    @Override
    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement == "Voiture" || modeDeplacement == "Velo") {
            super.setModeDeplacement(modeDeplacement);
        }
    }

    @Override
    public void changeModeDeplacement(String modeDeplacement) {
        if(modeDeplacement == "Voiture" || modeDeplacement == "Velo") {
            super.changeModeDeplacement(modeDeplacement);
        }
    }

    public void suru(Personnage pers){
        switch(getModeDeplacement()){
            case "Voiture":
                pers.updateValue("moral", -2);
                if (Math.random() <= 0.02){
                    pers.mourrir();
                }
                if (Math.random() <= 0.05){
                    pers.updateValue("arrestation", 1);
                }
            case "Velo":
                pers.updateValue("hydratation", -5);
                pers.updateValue("satiete", -5);
                if (Math.random() <= 0.005){
                    pers.mourrir();
                }
        }
        determinerPiege();
    }


    @Override
    public void determinerPiege() {
        if (Math.random() <= 0.05){
            int alea = Math.random()
            if (alea <= 0.33){
                pers.updateValue("vie", -1);
            }else if (0.33 <= alea && alea <= 0.66) {
                pers.updateValue("moral", -1);
            }else{
                pers.updateValue("hydratation", -2);
                pers.updateValue("satiete", -2);
            }
        }
    }

    @Override
    public boolean autoriserDeplacement(Personnage p){
        if(this.getModeDeplacement() == "Voiture"){
            if(p.getPermis){
                return true;
            }else{
                if(this.changeModeDeplacement(p, "Velo")){
                    return true;
                }
            }
            return false
        }else if(getModeDeplacement() == "Velo"){
            if(p.getVelo){
                return true;
            }else{
                if(this.changeModeDeplacement(p, "Voiture")){
                    return true;
                }
            }
            return false
        }
    }
}
