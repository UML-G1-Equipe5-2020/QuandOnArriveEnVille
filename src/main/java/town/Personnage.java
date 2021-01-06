package town;

public abstract class Personnage {

    //Moyen de deplacement
    protected boolean permis;
    protected boolean velo;
    protected boolean maillot;

    public int getVie() {
        return vie;
    }

    public int getHydratation() {
        return hydratation;
    }

    public int getSatiete() {
        return satiete;
    }

    public int getMoral() {
        return moral;
    }

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
    protected int chanceDiplome = 30; //chance d'obtenir un diplome
    protected int nbDiplome = 0;      //nombre de diplome
    protected int nbArrestation = 0;  //nombre d'arrestation

    public Personnage(Case caseHouse, boolean permis, boolean velo, boolean maillot) //Constructeur de personnage
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

    public void incrementerDiplome() //Incrementer le compteur de diplome du personnage
    {
        this.nbDiplome += 1; //augmente le nombre de diplome
        this.chanceDiplome = 30; //réinitialise la probabilité d'obtenir un diplome a chaque diplome obtenu
    }


    public int getChanceDiplome()
    {
        return this.chanceDiplome;
    }

    public void incrementerArrestation()
    {
        this.nbArrestation += 1;
    } //augmente le nombre d'arrestation du personnage

    public void updateValue(String barre, int valeur ) //Fonction pour modifier la valeur d'un attribut (Hydratation, vie, satiete...)
    {

        if(barre.equals("vie") && valeur < 0) //Pour modifie la vie
        {
            //si la vie + la valeur d'incrémentation est inférieure à la vie maximum autorisée par le personnage et est supérieure a 0
            if(this.vie+valeur <= maxVie && this.vie+valeur >= 0  )
            {
                this.vie += valeur;
            }else{
                this.vie = 0;
            }
        }
        else if(barre.equals("hydratation")) //Pour modifier l'hydratation
        {
            //si la valeur de l'hydratation + la valeur d'incrémentation est inférieure à l'hydratation autorisée par le personnage et est supérieure a 0
            if(this.hydratation+valeur <= maxHydratation && this.hydratation+valeur >= 0 )
            {
                this.hydratation += valeur;
            }else if (this.hydratation+valeur > maxHydratation){
                //sinon si l'hydratation + la valeur d'incrémentation est supérieur au maximum, on définie la valeur au maximum que peut avoir le personnage pour cet attribut
                this.hydratation = maxHydratation;
            }else{
                this.hydratation = 0;
            }

        }
        else if(barre.equals("satiete")) //Pour modifier la satiete
        {
            //si la satiete + la valeur d'incrémentation est inférieure à la satiete maximum autorisée par le personnage et est supérieure a 0
            if(this.satiete+valeur <= maxSatiete && this.satiete+valeur >= 0 )
            {
                this.satiete += valeur;
            }else if (this.satiete+valeur > maxSatiete){
                //sinon si la satiete + la valeur d'incrémentation est supérieur au maximum, on définie la valeur au maximum que peut avoir le personnage pour cet attribut
                this.satiete = maxSatiete;
            }else{
                this.satiete = 0;
            }

        }
        else if(barre.equals("moral"))
        {
            //si le moral + la valeur d'incrémentation est inférieure au moral maximum autorisé par le personnage et est supérieure a 0
            if(this.moral+valeur <= maxMoral && this.moral+valeur >= 0 )
            {
                this.moral += valeur;
            }else if (this.moral+valeur > maxMoral){
                //sinon si le moral + la valeur d'incrémentation est supérieur au maximum, on définie la valeur au maximum que peut avoir le personnage pour cet attribut
                this.moral = maxMoral;
            }else{
                this.moral = 0;
            }
        }
        else if(barre.equals("chance"))
        {
            //si la chance d'obtention du diplome + la valeur d'incrémentation est inférieure à la chance maximum autorisée par le personnage et est supérieure a 0
            if(this.chanceDiplome+valeur <= maxChance && valeur >= 0)
            {
                this.chanceDiplome += valeur;
            }else if (this.chanceDiplome+valeur > maxChance){
                //sinon la chance d'obtention un diplome + la valeur d'incrémentation est supérieur au maximum, on définie la valeur au maximum que peut avoir le personnage pour cet attribut
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
    } //définir la case où se situe le personnage

    public Case getCase()
    {
        return casePersonnage;
    } //obtenir la case où se situe le personnage

    public void mourir()
    {
        this.vie = 0;
    } //fait mourrir le personnage

    public boolean seDeplacer(String direction, Ville ville){
        int currentLigne = this.casePersonnage.getLigne(); //obtient la ligne où est situé personnage
        int currentColonne = this.casePersonnage.getColonne(); //obtient la colonne ou est situé le personnage
        Case targetCase = null; //la case où l'utilisateur veut que son personnage se déplace
        switch (direction){
            case "d": //lorsque l'utilisateur appuie sur la touche "d" puis "entrée":
                if(currentColonne < ville.getLengthOfColonne()-1){  //si le déplacement demandée par l'utilisateur ne fait pas sortir le personnage de la ville (colonne)
                    targetCase = ville.getCase(currentLigne, currentColonne+1); //la case cible est obtenue pour le déplacement du personnage
                }
                break;
            case "z": //lorsque l'utilisateur appuie sur la touche "z" puis "entrée":
                if(currentLigne > 0){ //si le déplacement demandée par l'utilisateur ne fait pas sortir le personnage de la ville (colonne)
                    targetCase = ville.getCase(currentLigne-1, currentColonne); //la case cible est obtenue pour le déplacement du personnage
                }
                break;
            case "q": //lorsque l'utilisateur appuie sur la touche "q" puis "entrée":
                if(currentColonne > 0){ //si le déplacement demandée par l'utilisateur ne fait pas sortir le personnage de la ville (ligne)
                    targetCase = ville.getCase(currentLigne, currentColonne-1); //la case cible est obtenue pour le déplacement du personnage
                }
                break;
            case "s": //lorsque l'utilisateur appuie sur la touche "s" puis "entrée":
                if(currentLigne < ville.getLengthOfLigne()-1){ //si le déplacement demandée par l'utilisateur ne fait pas sortir le personnage de la ville (ligne)
                    targetCase = ville.getCase(currentLigne+1, currentColonne); //la case cible est obtenue pour le déplacement du personnage.
                }
                break;
            default :
                return false; //sinon, retourne false qui empeche le déplacement du personnage.
        }
        if(targetCase != null && targetCase.autoriserDeplacement(this)) { //si il y a une case cible pour le déplacement et qu'il est possible de s'y déplacer
            this.setCase(targetCase); //le personnage se déplace sur cette case
            this.casePersonnage.suru(this); //réalise l'action de la case sur laquelle se situe le personnage (varie en fonction du type de la case)
            return true;
        }
        return false;
    }

    @Override
    public String toString() { //affichage des caractéristiques du personnage.
        return "Vous: " +
                ", vie:" + vie +
                ", soif:" + hydratation +
                ", faim:" + satiete +
                ", moral:" + moral +
                ", chanceDiplome:" + chanceDiplome +
                ", nbDiplome:" + nbDiplome +
                ", nbArrestation:" + nbArrestation;
    }
}
