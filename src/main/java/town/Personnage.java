package town;

public abstract class Personnage {

    //Moyen de deplacement
    protected boolean permis;
    protected boolean velo;
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


    protected int facteurDePerte;

    //Position du personnage à l'instant T
    protected Case casePersonnage;

    //Autre variables
    protected int chanceDiplome = 30;
    protected int nbDiplome = 0;
    protected int nbArrestation = 0;

    public Personnage(Case caseHouse, boolean permis, boolean velo, boolean maillot)
    {
        this.casePersonnage = caseHouse;
        this.permis = permis;
        this.velo = velo;
        this.maillot = maillot;
    }

    public int getFacteurDePerte() {
        return facteurDePerte;
    }

    public boolean getMaillot() {
        return maillot;
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
            if(this.vie+valeur <= maxVie && this.vie+valeur >= 0  )
            {
                this.vie += valeur;
            }else{
                this.vie = 0;
            }
        }
        else if(barre.equals("hydratation"))
        {
            if(this.hydratation+valeur <= maxHydratation && this.hydratation+valeur >= 0 )
            {
                this.hydratation += valeur;
            }else if (this.hydratation+valeur > maxHydratation){
                this.hydratation = maxHydratation;
            }else{
                this.hydratation = 0;
            }

        }
        else if(barre.equals("satiete"))
        {
            if(this.satiete+valeur <= maxSatiete && this.satiete+valeur >= 0 )
            {
                this.satiete += valeur;
            }else if (this.satiete+valeur > maxSatiete){
                this.satiete = maxSatiete;
            }else{
                this.satiete = 0;
            }

        }
        else if(barre.equals("moral"))
        {
            if(this.moral+valeur <= maxMoral && this.moral+valeur > 0 )
            {
                this.moral += valeur;
            }else if (this.moral+valeur > maxMoral){
                this.moral = maxMoral;
            }else{
                this.moral = 0;
            }
        }
        else if(barre.equals("chance"))
        {
            if(this.chanceDiplome+valeur <= maxChance && valeur > 0)
            {
                this.chanceDiplome += valeur;
            }else if (this.chanceDiplome+valeur > maxChance){
                this.chanceDiplome = maxChance;
            }else{
                this.chanceDiplome = 0;
            }
        }
        else
        {
            System.out.println("Erreur dans updateValue");
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

    public boolean seDeplacer(String direction, Ville ville){
        int currentLigne = this.casePersonnage.getLigne();
        int currentColonne = this.casePersonnage.getColonne();
        Case targetCase = null;
        switch (direction){
            case "d":
                if(currentColonne < ville.getLengthOfColonne()-1){
                    targetCase = ville.getCase(currentLigne, currentColonne+1);
                }
                break;
            case "z":
                if(currentLigne > 0){
                    targetCase = ville.getCase(currentLigne-1, currentColonne);
                }
                break;
            case "q":
                if(currentColonne > 0){
                    targetCase = ville.getCase(currentLigne, currentColonne-1);
                }
                break;
            case "s":
                if(currentLigne < ville.getLengthOfLigne()-1){
                    targetCase = ville.getCase(currentLigne+1, currentColonne);
                }
                break;
            default :
                return false;
        }
        if(targetCase != null && targetCase.autoriserDeplacement(this)) {
            this.setCase(targetCase);
            this.casePersonnage.suru(this);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "permis=" + permis +
                ", velo=" + velo +
                ", maillot=" + maillot +
                ", vie=" + vie +
                ", hydratation=" + hydratation +
                ", satiete=" + satiete +
                ", moral=" + moral +
                ", chanceDiplome=" + chanceDiplome +
                ", nbDiplome=" + nbDiplome +
                ", nbArrestation=" + nbArrestation +
                '}';
    }
}
