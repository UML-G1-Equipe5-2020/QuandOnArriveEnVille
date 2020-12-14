package town;

public class Universite extends Batiment{

    public Universite()
    {
        super();
    }

    public Universite(int l, int c)
    {
        super(l, c);
    }

    public void suru(Personnage p)
    {
        double chance = Math.random();
        if (chance <= p.getChanceDiplome()/100)
        {
            p.incrementerDiplome();
            p.updateValue("moral", 5);
        }
    }

    public boolean deplacerPersonnage()
    {
        return true;
    }
}
