package town;

public class Hippie extends Personnage {
    public Hippie(Case caseHouse, boolean permis, boolean velo, boolean maillot) {
        super(caseHouse, permis, velo, maillot);
        this.maxVie = 75;
        this.maxHydratation = 50;
        this.maxSatiete = 50;
        this.moral = 100;
    }
}
