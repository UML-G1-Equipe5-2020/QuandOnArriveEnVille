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
        System.out.println("Jour d'examen : Quel la force soit avec vous !");
        double chance = Math.random();
        if (chance <= p.getChanceDiplome()/100.0)
        {
            System.out.println("Vous êtes plus intelligent : Vous avez obtenu un diplôme");
            p.incrementerDiplome();
            p.updateValue("moral", 5);
        }else{
            System.out.println("Vous êtes moins intelligent que prévu... Vous redoublez... encore !");
        }
    }

    @Override
    public String toString() {
        return  "UN";
    }
}
