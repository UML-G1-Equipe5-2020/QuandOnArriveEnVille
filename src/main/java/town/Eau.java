package town;

public class Eau extends CaseDeDeplacement{

    public Eau(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("pieds");
    }

    public void suru(Personnage pers){
        System.out.println("Tous en maillot de bain !");
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
