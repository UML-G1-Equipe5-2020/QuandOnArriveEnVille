package town;

public class CaseGrisee extends CaseDeDeplacement{
    public CaseGrisee(int ligne, int colonne) {
        super(ligne, colonne);
    }

    public void suru(Personnage pers){
        System.out.println("Erreur: un personnage n'est pas censé se trouver sur cette case");
    }

    @Override
    public boolean autoriserDeplacement(Personnage p){
        return false;
    }


    @Override
    public String toString() {
        return  "XX";
    }
}
