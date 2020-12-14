package town;

public abstract class Personnage {

    private boolean permis;
    private boolean velo;
    private int nbArrestation = 0;
    private int vie;
    private int hydratation;
    private int satiete;
    private int moral;
    private boolean maillot;
    private int chanceDiplome;

    private String deplacement;


    private int maxVie;
    private int maxHydratation;
    private int maxSatiete;
    private int maxMoral;


    private int nbDiplome = 0;
    private Personnage p;

    public Personnage(String type, boolean permis, boolean velo)
    {
        this.permis = permis;
        Personnage perso;
        switch (type)
        {
            case "hippie":
                this.p = new Hippie(permis, velo, maillot);
            case "standard":
                this.p = new Standard(permis, velo, maillot);
            case "HommePresse" :
                this.p = new HommePresse(permis, velo, maillot);
            default:
                this.p = new Standard(permis, velo, maillot);
        }
    }



    public void incrementerDiplome()
    {
        this.nbDiplome += 1;
    }

    public void incrementerArrestation()
    {
        this.nbArrestation += 1;
    }




    public void updateValue(String barre, int valeur )
    {
        if(barre.equals("vie") && valeur < 0)
        {
            if(this.vie+valeur <= maxVie )
            {
                this.vie += valeur;
            }
        }
        else if(barre.equals("hydratation"))
        {
            if(this.hydratation+valeur <= maxHydratation)
            {
                this.hydratation += valeur;
            }

        }
        else if(barre.equals("satiete"))
        {
            if(this.satiete+valeur <= maxSatiete )
            {
                this.satiete += valeur;
            }

        }
        else if(barre.equals("moral"))
        {
            if(this.moral+valeur <= maxMoral )
            {
                this.moral += valeur;
            }
        }

    }

    public String getDeplacement()
    {
        return deplacement;
    }

    public void setDeplacement(String deplacement)
    {
        this.deplacement = deplacement;
    }



    public void mourir()
    {
        this.vie = 0;
    }
}
