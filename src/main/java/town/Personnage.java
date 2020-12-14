package town;

public class Personnage {

    private int vie;
    private int hydratation;
    private int satiete;
    private int moral;
    private int chanceDiplome;
    private int diplome;

    public void updateValue(String barre, int valeur )
    {
        if(barre.equals("vie") && valeur < 0)
        {
            this.vie +=  valeur;
        }
        else if(barre.equals("hydratation"))
        {
            this.hydratation += valeur;
        }
        else if(barre.equals("satiete"))
        {
            this.satiete += valeur;
        }
        else if(barre.equals("moral"))
        {
            this.moral += valeur;
        }
    }

    public int getChanceDiplome()
    {
        return chanceDiplome;
    }

    public void incrementerDiplome()
    {
        diplome++;
    }
}
