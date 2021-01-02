package town;

public abstract class CaseDeDeplacement extends Case{
    private String modeDeplacement;


    public String getModeDeplacement() {
        return modeDeplacement;
    }

    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement == "Voiture" || modeDeplacement == "Velo" || modeDeplacement == "Pied") {
            this.modeDeplacement = modeDeplacement;
        }
    }

    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement == "Voiture" && pers.getPermis()) {
            this.modeDeplacement = modeDeplacement;
            return true;
        }else if(modeDeplacement == "Velo" && pers.getVelo()){
            this.modeDeplacement = modeDeplacement;
            return true;
        }else if(modeDeplacement == "Pied"){
            this.modeDeplacement = modeDeplacement;
            return true;
        }
        return false;
    }
}
