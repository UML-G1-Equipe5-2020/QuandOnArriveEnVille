package town;

public class Bar extends Batiment{

    public Bar()
    {
        super();
    }

    public Bar(int l, int c)
    {
        super(l, c);
    }

    public void suru(Personnage p)
    {
        p.updateValue("hydratation", 25);
        p.updateValue("moral", 10);
        p.updateValue("vie", -3);

        double chance = Math.random();
        if (chance <= 5/100)
        {
            p.updateValue("chanceDiplome", 5);
        }

    }

    @Override
    public String toString() {
        return  "BA";
    }

}
