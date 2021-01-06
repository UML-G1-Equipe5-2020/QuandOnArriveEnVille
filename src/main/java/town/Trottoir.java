package town;

public class Trottoir extends CaseDeDeplacement implements Piege{


    public Trottoir(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("pieds");  // initialise le mode de déplacement à pieds
    }


    // Initialise le mode de deplacement pour cette case si il s'agit de velo ou de pieds
    // retourne true si l'action a réussi, false sinon
    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            super.setModeDeplacement(modeDeplacement, this.getClass());  // change le mode de déplacement dans le Hashmap
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
        switch(getModeDeplacement(this)){
            case "pieds":
                System.out.println("42.332 km à pieds, ça use, ça use");
                pers.updateValue("hydratation", (int) (-3*pers.getFacteurDePerte()));  // 3 au lieu de 10
                pers.updateValue("satiete", (int) (-3*pers.getFacteurDePerte()));  // 3 au lieu de 10
                break;
            case "velo":
                System.out.println("DingDing");
                pers.updateValue("hydratation", (int) (-2*pers.getFacteurDePerte()));  // 2 au lieu de 5
                pers.updateValue("satiete", (int) (-2*pers.getFacteurDePerte()));  // 2 au lieu de 5
                // 0.5 % de chance de mourrir directement
                if (Math.random() <= 0.005){
                    pers.mourir();
                }
                break;
        }
        determinerPiege(pers);
    }

    @Override
    // determine si la case comporte un piège et affecte le personnage en conséquence
    public void determinerPiege(Personnage pers) {
        // 5% d'avoir un piège
        if (Math.random() <= 0.05){
            double alea = Math.random();
            if (alea <= 0.33){  // 1 chance sur 3 de tomber sur une banane
                System.out.println("swiiip ! Vous avez glissé sur une peau de banane (-3 points de vie)");
                pers.updateValue("vie", -3);
            }else if (0.33 <= alea && alea <= 0.66) {  // 1 chance sur 3 de tomber sur une poussette
                System.out.println("Ouin! Ouin! Vous croisez une poussette (-3 points de moral)");
                pers.updateValue("moral", -2);
            }else{  // 1 chance sur 3 de tomber sur une déjection canine
                System.out.println("Berk !! Vous avez marché dans une crotte de chien et... ça vous donne faim (-1 points de satiété)");
                pers.updateValue("satiete", -1);
            }
        }
    }

    @Override
    public String toString() {
        return  "TR";
    }
}
