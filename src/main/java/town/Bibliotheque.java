package town;

public class Bibliotheque extends Batiment{

    public Bibliotheque()
    {
        super();
    }

    public Bibliotheque(int l, int c)
    {
        super(l, c);
    }

    public void suru(Personnage p)
    {
        p.updateValue("moral", 20);

        double chance = Math.random();
        if (chance <= 5/100)
        {
            p.updateValue("chanceDiplome", 10);
        }
    }

}
