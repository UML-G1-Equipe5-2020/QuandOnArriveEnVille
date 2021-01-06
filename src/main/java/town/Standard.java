package town;

public class Standard extends Personnage {
    public Standard(Case house, boolean permis, boolean velo, boolean maillot) { //définie les attributs d'une instance du personnage HommePresse
        super(house, permis, velo, maillot);
        this.maxVie = 75;
        this.maxHydratation = 75;
        this.maxSatiete = 75;
        this.maxMoral = 75;
        this.facteurDePerte = 1;

        this.vie = this.maxVie;
        this.hydratation = this.maxHydratation;
        this.satiete = this.maxSatiete;
        this.moral = this.maxMoral;
    }

    //définie une spécificité du personnage lorsqu'il se déplace en plus de la methode "seDeplacer()" dans la classe Personnage
    public boolean seDeplacer(String direction, Ville ville){
        boolean deplace = super.seDeplacer(direction, ville); //on utilise la méthode "seDeplacer()" de la classe Personne
        if(deplace){
            this.updateValue("vie", -1); //pour chaque déplacement, le personnage Standard
        }
        return deplace;
    }
}
