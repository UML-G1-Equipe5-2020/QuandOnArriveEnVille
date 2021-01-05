package town;

public class Hippie extends Personnage {
    public Hippie(boolean permis, boolean velo, boolean maillot) {
        super(permis, velo, maillot);
        this.maxVie = 75;
        this.maxHydratation = 50;
        this.maxSatiete = 50;
        this.moral = 100;
    }
}
