package town;

public class Standard extends Personnage {
    public Standard(Case house, boolean permis, boolean velo, boolean maillot) {
        super(house, permis, velo, maillot);
        this.maxVie = 75;
        this.maxHydratation = 75;
        this.maxSatiete = 75;
        this.maxMoral = 75;
        this.facteurDePerte = 1;

        this.vie = this.maxVie;
        this.hydratation = this.maxHydratation;
        this.satiete = this.maxSatiete;
        this.moral = this.maxMoral;
    }


    public boolean seDeplacer(String direction, Ville ville){
        boolean deplace = super.seDeplacer(direction, ville);
        if(deplace){
            this.updateValue("vie", -1);
        }
        return deplace;
    }
}
