package town;

public abstract class Batiment extends Case{

    public Batiment()
    {
        super();
    }

    public Batiment(int l, int c)
    {
        super(l, c);
    }

    public abstract void suru(Personnage p);

}
