package town;

public class Route extends CaseDeDeplacement implements Piege{

    public Route(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("voiture");  // initialise le déplacement par défaut sur voiture
    }


    // Initialise le mode de deplacement pour cette case si il s'agit de velo ou de voiture
    // retourne true si l'action a réussi, false sinon
    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement.equals("voiture") || modeDeplacement.equals("velo")) {
            super.setModeDeplacement(modeDeplacement, Trottoir.class);
        }
    }


    // Change le mode de deplacement
    // Verifie si le mode de deplacement est velo ou voiture
    // retourne true si le changement est effectué, false sinon
    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("voiture") || modeDeplacement.equals("velo")) {
            return super.changeModeDeplacement(pers, modeDeplacement);
        }
        return false;
    }


    // suru = "faire" en japonais -> procède aux actions de la case lors du déplacement sur une case
    // Affecte le personnage en mettant à jour ses statistiques conformément à son facteur de perte et son mode de déplacement
    // Fait appel à la méthode determinerPiege()
    public void suru(Personnage pers){
        super.suru(pers);
        switch(getModeDeplacement((CaseDeDeplacement) pers.casePersonnage)){
            case "voiture":
                System.out.println("Vrooom");
                pers.updateValue("moral", (int) (-2*pers.getFacteurDePerte()));
                // 2% de chance de mourrir directement en voiture
                if (Math.random() <= 0.02){
                    pers.mourir();
                }
                // 5 pourcent de chance de se faire arrêter par la police
                if (Math.random() <= 0.05){
                    System.out.println("22 vlà les flic : vous vous êtes fait arrêtés");
                    pers.incrementerArrestation();
                }
                break;
            case "velo":
                System.out.println("DingDing !");
                pers.updateValue("hydratation", (int) (-2*pers.getFacteurDePerte()));  // 2 au lieu de 5
                pers.updateValue("satiete", (int) (-2*pers.getFacteurDePerte()));  // 2 au lieu de 5
                // 0.5 % de chance de mourrir directement
                if (Math.random() <= 0.005){
                    System.out.println("PinPon PinPon, vous vous êtes fait écrasé. Vous ferez mieux la prochaine fois");
                    pers.mourir();
                }
                break;
        }
        determinerPiege(pers);
    }


    @Override
    // determine si la case comporte un piège et affecte le personnage en conséquence
    public void determinerPiege(Personnage pers) {
        // 5% de chance de tomber sur un piège
        if (Math.random() <= 0.05){
            double alea = Math.random();
            if (alea <= 0.33){  // 1 chance sur 3 : feu rouge
                System.out.println("Tic tac tic, le temps presse mais le feu est rouge (-1 point de vie)");
                pers.updateValue("vie", -1);
            }else if (0.33 <= alea && alea <= 0.66) {  // 1 chance sur 3 : Police
                System.out.println("Vous croisez la police !! la stress ! (-1 point de moral)");
                pers.updateValue("moral", -1);
            }else{  // 1 chance sur 3 : nid de poule
                System.out.println("bam! un nid de poule ! le choc vous fait perdre des molécules.. (-2 points d'hydratation et de satiété)");
                pers.updateValue("hydratation", -2);
                pers.updateValue("satiete", -2);
            }
        }
    }

    @Override
    // Autorise le déplacement si le personnage a les bons attributs. Sinon, tente d'adapter le mode de déplacement en conséquence
    public boolean autoriserDeplacement(Personnage p){
        if(this.getModeDeplacement(this).equals("voiture")){  // Si voiture
            if(p.getPermis() && p.getClass() != town.Hippie.class){
                return true;  // autorise le déplacement si le personnage a un permis et n'est pas un hippie
            }else{  // Sinon, on passe le mode de déplacement sur velo
                if(this.changeModeDeplacement(p, "velo") && p.getVelo()){
                    return true;  // autorise le déplacement si le personnage a un velo
                }
            }
            return false;  // refuse le déplacement si le personnage n'a ni le permis (ou est un hippie) ni velo
        }else if(getModeDeplacement(this).equals("velo")){  // Si velo
            if(p.getVelo()){
                return true;  // autorise le déplacement si le personnage a un velo
            }else{  // Sinon, on passe le mode de déplacement sur voiture
                if(p.getClass() != town.Hippie.class && this.changeModeDeplacement(p, "voiture")){
                    return true;  // autorise le déplacement si le personnage a une voiture et n'est pas un hippie
                }
            }
            return false;  // retourne false si le personnage n'a ni velo ni voiture (ou est un hippie)
        }
        System.out.println("ERREUR : AUTRE deplacement");  // affiche un message d'erreur si le mode de déplacement n'existe pas
        return false;  // refuse le déplacement dans tout les autres cas
    }

    @Override
    public String toString() {
        return  "RO";
    }
}
