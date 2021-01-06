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
        System.out.println("SIIlEEence !!! C'est pas le zoo, ici, c'est la bibliothèque");

        //On augmente le moral du personnage
        p.updateValue("moral", 20);

        //Si l'utilisateur a de la chance (5%), il trouve le livre de génie logiciel et a 10% de chances de plus d'obtenir un diplôme lors de sa prochaine visite à l'université
        double chance = Math.random();
        if (chance <= 5/100.0)
        {
            p.updateValue("chanceDiplome", 10);
            System.out.println("Vous avez trouvé le livre de génie logiciel ! (+10% de chance d'obtenir un diplôme)");
        }
    }

    @Override
    public String toString() {
        return  "BI";
    }

}
