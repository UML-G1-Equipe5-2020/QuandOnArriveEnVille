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
        if(modeDeplacement.equals("voiture") || modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            this.modeDeplacement = modeDeplacement;
        }
    }

    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("voiture") && pers.getPermis()) {
            this.modeDeplacement = modeDeplacement;
            return true;
        }else if(modeDeplacement.equals("velo") && pers.getVelo()){
            this.modeDeplacement = modeDeplacement;
            return true;
        }else if(modeDeplacement.equals("pieds")){
            this.modeDeplacement = modeDeplacement;
            return true;
        }
        return false;
    }
}
