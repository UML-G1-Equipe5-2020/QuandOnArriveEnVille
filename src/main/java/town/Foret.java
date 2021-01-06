package town;

public class Foret extends CaseDeDeplacement{

    public Foret(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("pieds");  // initialise le mode de déplacement à pieds
    }

    // Initialise le mode de deplacement pour cette case si il s'agit de velo ou de pieds
    // retourne true si l'action a réussi, false sinon
    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            super.setModeDeplacement(modeDeplacement, Foret.class);  // change le mode de déplacement dans le Hashmap
        }
    }


    // Change le mode de deplacement
    // Verifie si le mode de deplacement est velo ou pieds
    // retourne true si le changement est effectué, false sinon
    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            return super.changeModeDeplacement(pers, modeDeplacement);  // change le mode de déplacement dans le Hashmap
        }
        return false;
    }


    // suru = "faire" en japonais -> procède aux actions de la case lors du déplacement sur une case
    // Affecte le personnage en mettant à jour ses statistiques conformément à son facteur de perte et son mode de déplacement
    // Fait appel à la méthode determinerPiege()
    public void suru(Personnage pers){
        super.suru(pers);
        System.out.println("Loup y es-tu ?");
        switch(getModeDeplacement((CaseDeDeplacement) pers.casePersonnage)){
            case "pieds":
                pers.updateValue("hydratation", (int) (-3*pers.getFacteurDePerte()));  // 3 au lieu de 10
                pers.updateValue("satiete", (int) (-3*pers.getFacteurDePerte()));  // 3 au lieu de 10
                break;
            case "velo":
                pers.updateValue("hydratation", (int) (-2*pers.getFacteurDePerte()));  // 2 au lieu de 5
                pers.updateValue("satiete", (int) (-2*pers.getFacteurDePerte()));  // 2 au lieu de 5
                if (Math.random() <= 0.002){
                    pers.mourir();
                }
                break;
        }
        determinerPiege(pers);
    }


    // determine si la case comporte un piège (ici: maladie) et affecte le personnage en conséquence
    public void determinerPiege(Personnage pers) {
        // 10% de chance de tomber malade
        if (Math.random() <= 0.10){
            System.out.println("Kof Kof ! Arggh vous êtes malade (-10 points de vie)");
            pers.updateValue("vie", -10);
        }
    }

    @Override
    public String toString() {
        return  "FO";
    }
}
