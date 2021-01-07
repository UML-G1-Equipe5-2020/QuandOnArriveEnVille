package town;

public class CaseGrisee extends CaseDeDeplacement{
    public CaseGrisee(int ligne, int colonne) {
        super(ligne, colonne);
    }

    // suru = "faire" en japonais -> procède aux actions de la case lors du déplacement sur une case
    // Affiche un message pour prévenir qu'un personnage n'est pas censé se trouver sur cette case
    public void suru(Personnage pers){
        System.out.println("Erreur: un personnage n'est pas censé se trouver sur cette case");
    }

    @Override
    // retourne false et refuse le déplacement sur cette case
    public boolean autoriserDeplacement(Personnage p){
        return false;
    }


    @Override
    public String toString() {
        return  "XX";
    }
}
