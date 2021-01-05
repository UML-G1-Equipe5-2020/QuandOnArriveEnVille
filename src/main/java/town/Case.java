package town;

public abstract class Case {
    private final int ligne;

    private final int colonne;

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


    public boolean autoriserDeplacement(Personnage p)
    {
        return true;
    }


    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

}