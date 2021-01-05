package town;

public class HommePresse extends Personnage {
    public HommePresse(boolean permis, boolean velo, boolean maillot) {
        super(permis, velo, maillot);


        this.maxVie = 100;
        this.maxHydratation = 75;
        this.maxSatiete = 75;
        this.maxMoral = 50;

        this.vie = this.maxVie;
        this.hydratation = this.maxHydratation;
        this.satiete = this.maxSatiete;
        this.moral = this.maxMoral; 
    }
}
