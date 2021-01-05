package town;

public class Standard extends Personnage {
    public Standard(Case caseHouse, boolean permis, boolean velo, boolean maillot) {
        super(caseHouse, permis, velo, maillot);
        this.maxVie = 75;
        this.maxHydratation = 75;
        this.maxSatiete = 75;
        this.moral = 75;
    }


}
