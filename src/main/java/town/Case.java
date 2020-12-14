package town;

public abstract class Case {
    final int ligne;
    final int colonne;

    public Case()
    {
        ligne = 0;
        colonne = 0;
    }

    public Case(int l, int c)
    {
        ligne = l;
        colonne = c;
    }


    public abstract void suru(Personnage p);
    public abstract boolean deplacerPersonnage();

}