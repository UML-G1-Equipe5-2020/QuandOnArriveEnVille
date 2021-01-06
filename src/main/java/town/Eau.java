package town;

public class Eau extends CaseDeDeplacement{

    public Eau(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("pieds");
    }

    public void suru(Personnage pers){
        System.out.println("Tous en maillot de bain !");
        pers.updateValue("hydratation", (int) (-10*pers.getFacteurDePerte()));
        pers.updateValue("satiete", (int) (-10*pers.getFacteurDePerte()));
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
