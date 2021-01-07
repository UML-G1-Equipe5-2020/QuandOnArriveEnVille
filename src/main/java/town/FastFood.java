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
        System.out.println("Miam miam ?");

        //On augmente ou diminue les valeurs du personnage
        p.updateValue("satiete", 25);
        p.updateValue("hydratation", 10);
        p.updateValue("moral", 10);
        p.updateValue("satiete", -5);
    }

    @Override
    public String toString() {
        return  "FA";
    }
}
