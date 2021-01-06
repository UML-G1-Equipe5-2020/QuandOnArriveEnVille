package town;

public class Eau extends CaseDeDeplacement{

    public Eau(int ligne, int colonne) {
        super(ligne, colonne);
        super.setModeDeplacement("pieds", Eau.class);
    }

    public void suru(Personnage pers){
        System.out.println("Tous en maillot de bain !");
        pers.updateValue("hydratation", (int) (-3*pers.getFacteurDePerte()));  // 3 au lieu de 10
        pers.updateValue("satiete", (int) (-3*pers.getFacteurDePerte()));  // 3 au lieu de 10
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
