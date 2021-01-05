package town;

public class Hippie extends Personnage {
    public Hippie(Case caseHouse, boolean permis, boolean velo, boolean maillot) {
        super(caseHouse, permis, velo, maillot);
        this.vie = 75;
        this.hydratation = 50;
        this.satiete = 50;
        this.maxVie = 75;
        this.maxHydratation = 50;
        this.maxSatiete = 50;
        this.moral = 100;
    }
}
