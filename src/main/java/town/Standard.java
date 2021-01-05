package town;

public class Standard extends Personnage {
    public Standard(Case house, boolean permis, boolean velo, boolean maillot) {
        super(house, permis, velo, maillot);
        this.maxVie = 75;
        this.maxHydratation = 75;
        this.maxSatiete = 75;
        this.maxMoral = 75;

        this.vie = this.maxVie;
        this.hydratation = this.maxHydratation;
        this.satiete = this.maxSatiete;
        this.moral = this.maxMoral;
    }
}
