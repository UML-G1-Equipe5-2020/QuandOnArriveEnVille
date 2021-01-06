package town;

public class Hippie extends Personnage {
    public Hippie(Case house, boolean permis, boolean velo, boolean maillot) {
        super(house, permis, velo, maillot);
        this.maxVie = 75;
        this.maxHydratation = 50;
        this.maxSatiete = 50;
        this.maxMoral = 100;
        this.facteurDePerte = 2;

        this.vie = this.maxVie;
        this.hydratation = this.maxHydratation;
        this.satiete = this.maxSatiete;
        this.moral = this.maxMoral;

    }

    public void updateValue(String barre, int valeur ) {
        if (!barre.equals("moral")) {
            super.updateValue(barre, valeur);
        }
    }

    public boolean seDeplacer(String direction, Ville ville){
        boolean deplace = super.seDeplacer(direction, ville);
        if(deplace){
            this.updateValue("vie", -2);
        }
        return deplace;
    }

}
