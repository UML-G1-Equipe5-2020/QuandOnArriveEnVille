package town;

public class Standard extends Personnage {
    public Standard(boolean permis, boolean velo, boolean maillot) {
        super(permis, velo, maillot);
        this.maxVie = 75;
        this.maxHydratation = 75;
        this.maxSatiete = 75;
        this.moral = 75;
    }
}
