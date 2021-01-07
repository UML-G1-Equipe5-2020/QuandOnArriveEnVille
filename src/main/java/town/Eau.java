package town;

public class Eau extends CaseDeDeplacement{

    public Eau(int ligne, int colonne) {
        super(ligne, colonne);
        super.setModeDeplacement("pieds", Eau.class);  // set le mode de déplacement par défaut sur pieds
    }

    // suru = "faire" en japonais -> procède aux actions de la case lors du déplacement sur une case
    // Affecte le personnage en mettant à jour ses statistiques conformément à son facteur de perte
    public void suru(Personnage pers){
        System.out.println("Tous en maillot de bain !");
        pers.updateValue("hydratation", (int) (-3*pers.getFacteurDePerte()));  // 3 au lieu de 10
        pers.updateValue("satiete", (int) (-3*pers.getFacteurDePerte()));  // 3 au lieu de 10
    }

    @Override
    // Autorise le déplacement si le personage a un maillot
    public boolean autoriserDeplacement(Personnage p){
            return p.getMaillot();
    }


    @Override
    public String toString() {
        return  "EA";
    }
}
