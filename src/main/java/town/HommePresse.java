package town;

public class HommePresse extends Personnage {
    public HommePresse(Case caseHouse, boolean permis, boolean velo, boolean maillot) {
        super(caseHouse, permis, velo, maillot);
        this.maxVie = 100;
        this.maxHydratation = 75;
        this.maxSatiete = 75;
        this.moral = 50;


    }
}
