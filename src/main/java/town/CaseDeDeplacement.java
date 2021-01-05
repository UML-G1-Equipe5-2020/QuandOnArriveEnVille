package town;

public abstract class CaseDeDeplacement extends Case{
    private String modeDeplacement;

    public CaseDeDeplacement(int ligne, int colonne){
        super(ligne, colonne);
    }


    public String getModeDeplacement() {
        return modeDeplacement;
    }

    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement.equals("Voiture") || modeDeplacement.equals("Velo") || modeDeplacement.equals("Pied")) {
            this.modeDeplacement = modeDeplacement;
        }
    }

    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("Voiture") && pers.getPermis()) {
            this.modeDeplacement = modeDeplacement;
            return true;
        }else if(modeDeplacement.equals("Velo") && pers.getVelo()){
            this.modeDeplacement = modeDeplacement;
            return true;
        }else if(modeDeplacement.equals("Pied")){
            this.modeDeplacement = modeDeplacement;
            return true;
        }
        return false;
    }
}
