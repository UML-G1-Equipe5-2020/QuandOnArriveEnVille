package town;

public class FastFood extends Batiment{

    public FastFood()
    {
        super();
    }

    public FastFood(int l, int c)
    {
        super(l, c);
    }

    public void suru(Personnage p)
    {
        p.updateValue("satiete", 25);
        p.updateValue("hydratation", 10);
        p.updateValue("moral", 10);
        p.updateValue("satiete", -5);
    }

}
