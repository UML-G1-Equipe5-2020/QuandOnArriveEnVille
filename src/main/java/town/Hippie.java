package town;

public class Hippie extends Personnage {
    public Hippie(Case house, boolean permis, boolean velo, boolean maillot) { //définie les attributs d'une instance du personnage HommePresse
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

    public void updateValue(String barre, int valeur ) { //on ajoute une spécifité pour ce personnage pour la mise a jour de ses attributs vitaux
        if (!barre.equals("moral")) { //il ne peut pas perdre du moral peu importe ce qu'il se passe, donc la barre de moral ne peut pas être impactée
            super.updateValue(barre, valeur); //on utilise la methode "updateValue()" de la classe Personne.
        }
    }
    //définie une spécificité du personnage lorsqu'il se déplace en plus de la methode "seDeplacer()" dans la classe Personnage
    public boolean seDeplacer(String direction, Ville ville){
        boolean deplace = super.seDeplacer(direction, ville); //on utilise la méthode "seDeplacer()" de la classe Personne
        if(deplace){
            this.updateValue("vie", -2); //On ajoute la spécificité: Le personnage type hippie perd 2 points de vie lorsqu'il se déplace d'une case
        }
        return deplace;
    }

}
