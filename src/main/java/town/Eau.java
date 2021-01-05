package town;

public class Eau extends CaseDeDeplacement{

    public Eau(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("Pied");
    }

    public void suru(Personnage pers){
        pers.updateValue("hydratation", -10);
        pers.updateValue("satiete", -10);
    }

    @Override
    public boolean autoriserDeplacement(Personnage p){
            return p.getMaillot();
    }


    @Override
    public String toString() {
        return  "EA";
    }
}