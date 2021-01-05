package town;

public abstract class Personnage {

    //Moyen de deplacement
    protected boolean permis;
    protected boolean velo;


    public boolean getMaillot() {
        return maillot;
    }

    protected boolean maillot;

    //Variables propre a l'instance du personnage a l'instant T
    protected int vie;
    protected int hydratation;
    protected int satiete;
    protected int moral;

    //Variables fixes propre a la catégorie du personnage, définitive.
    protected int maxVie;
    protected int maxHydratation;
    protected int maxSatiete;
    protected int maxMoral;
    protected int maxChance = 100;

    //Position du personnage à l'instant T
    protected Case casePersonnage;

    //Autre variables
    protected int chanceDiplome;
    protected int nbDiplome = 0;
    protected int nbArrestation = 0;

    public Personnage(boolean permis, boolean velo, boolean maillot)
    {
        this.permis = permis;
        this.velo = velo;
        this.maillot = maillot;
    }

    public boolean getPermis() { return permis; }

    public boolean getVelo() { return velo; }

    public void incrementerDiplome()
    {
        this.nbDiplome += 1;
        this.chanceDiplome = 30;
    }


    public int getChanceDiplome()
    {
        return this.chanceDiplome;
    }

    public void incrementerArrestation()
    {
        this.nbArrestation += 1;
    }

    public void updateValue(String barre, int valeur )
    {
        if(barre.equals("vie") && valeur < 0)
        {
            if(this.vie+valeur <= maxVie && this.vie+valeur > 0  )
            {
                this.vie += valeur;
            }
        }
        else if(barre.equals("hydratation"))
        {
            if(this.hydratation+valeur <= maxHydratation && this.hydratation+valeur > 0 )
            {
                this.hydratation += valeur;
            }

        }
        else if(barre.equals("satiete"))
        {
            if(this.satiete+valeur <= maxSatiete && this.satiete+valeur > 0 )
            {
                this.satiete += valeur;
            }

        }
        else if(barre.equals("moral"))
        {
            if(this.moral+valeur <= maxMoral && this.moral+valeur > 0 )
            {
                this.moral += valeur;
            }
        }
        else if(barre.equals("chance"))
        {
            if(this.chanceDiplome+valeur <= maxChance && valeur > 0)
            {
                this.chanceDiplome += valeur;
            }
        }
        else
        {
            System.out.println("Erreur");
        }

    }

    public void setCase(Case c)
    {
        this.casePersonnage = c;
    }

    public Case getCase()
    {
        return casePersonnage;
    }

    public void mourir()
    {
        this.vie = 0;
    }
}
