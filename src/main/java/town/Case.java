package town;

public abstract class Case {
    final abstract int ligne;
    final abstract int colonne;


    public abstract void suru(Personnage pers);
    public abstract void deplacerPersonnage();

}
