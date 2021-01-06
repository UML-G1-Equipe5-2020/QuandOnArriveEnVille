package town;

public class HommePresse extends Personnage {
    public HommePresse(Case house, boolean permis, boolean velo, boolean maillot) {
        super(house, permis, velo, maillot);


        this.maxVie = 100;
        this.maxHydratation = 75;
        this.maxSatiete = 75;
        this.maxMoral = 50;
        this.facteurDePerte = 0;

        this.vie = this.maxVie;
        this.hydratation = this.maxHydratation;
        this.satiete = this.maxSatiete;
        this.moral = this.maxMoral; 
    }

    public boolean seDeplacer(String direction, Ville ville){
        boolean deplace = super.seDeplacer(direction, ville);
        if(deplace){
            this.updateValue("moral", -2);
        }
        return deplace;
    }
}
