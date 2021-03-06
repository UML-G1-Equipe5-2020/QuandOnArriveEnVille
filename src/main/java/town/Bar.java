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
        System.out.println("On boit un coup ? Pas plus haut que le bord !");

        //On augmente ou diminue les valeurs du personnage
        p.updateValue("hydratation", 25);
        p.updateValue("moral", 10);
        p.updateValue("vie", -3);

        //Si l'utilisateur a de la chance (5%), il trouve le sujet du prochain examen et a 5% de chances de plus d'obtenir un diplôme lors de sa prochaine visite à l'université
        double chance = Math.random();
        if (chance <= 5/100.0)
        {
            p.updateValue("chanceDiplome", 5);
            System.out.println("Vous avez trouvé l'ennoncé du sujet de l'examen !! (+5% de chance d'obtenir un diplôme)");
        }

    }

    @Override
    public String toString() {
        return  "BA";
    }

}
