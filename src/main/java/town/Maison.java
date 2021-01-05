package town;

public class Maison extends Batiment{

    public Maison()
    {
        super();
    }

    public Maison(int l, int c)
    {
        super(l, c);
    }

    public void suru(Personnage p)
    {
        System.out.println("Métro, boulot, dodo ? C'est l'heure de l'apéro");
        p.updateValue("moral", 10);
        p.updateValue("satiete", 10);
        p.updateValue("hydratation", 10);
    }

    @Override
    public String toString() {
        return  "MA";
    }

}
