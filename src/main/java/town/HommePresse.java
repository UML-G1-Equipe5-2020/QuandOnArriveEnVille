package town;

public class HommePresse extends Personnage {
    public HommePresse(boolean permis, boolean velo, boolean maillot) {
        super(permis, velo, maillot);
        this.maxVie = 100;
        this.maxHydratation = 75;
        this.maxSatiete = 75;
        this.moral = 50;


    }
}
