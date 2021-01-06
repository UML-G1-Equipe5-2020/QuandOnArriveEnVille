package town;

public class Route extends CaseDeDeplacement implements Piege{

    public Route(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("voiture");
    }

    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement.equals("voiture") || modeDeplacement.equals("velo")) {
            super.setModeDeplacement(modeDeplacement, Trottoir.class);
        }
    }


    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("voiture") || modeDeplacement.equals("velo")) {
            return super.changeModeDeplacement(pers, modeDeplacement);
        }
        return false;
    }

    public void suru(Personnage pers){
        super.suru(pers);
        switch(getModeDeplacement((CaseDeDeplacement) pers.casePersonnage)){
            case "voiture":
                System.out.println("Vrooom");
                pers.updateValue("moral", (int) (-2*pers.getFacteurDePerte()));
                if (Math.random() <= 0.02){
                    pers.mourir();
                }
                if (Math.random() <= 0.05){
                    System.out.println("22 vlà les flic : vous vous êtes fait arrêtés");
                    pers.incrementerArrestation();
                }
                break;
            case "velo":
                System.out.println("DingDing !");
                pers.updateValue("hydratation", (int) (-2*pers.getFacteurDePerte()));  // 2 au lieu de 5
                pers.updateValue("satiete", (int) (-2*pers.getFacteurDePerte()));  // 2 au lieu de 5
                if (Math.random() <= 0.005){
                    System.out.println("PinPon PinPon, vous vous êtes fait écrasé. Vous ferez mieux la prochaine fois");
                    pers.mourir();
                }
                break;
        }
        determinerPiege(pers);
    }


    @Override
    public void determinerPiege(Personnage pers) {
        if (Math.random() <= 0.05){
            double alea = Math.random();
            if (alea <= 0.33){
                pers.updateValue("vie", -1);
            }else if (0.33 <= alea && alea <= 0.66) {
                pers.updateValue("moral", -1);
            }else{
                pers.updateValue("hydratation", -2);
                pers.updateValue("satiete", -2);
            }
        }
    }

    @Override
    public boolean autoriserDeplacement(Personnage p){
        if(this.getModeDeplacement(this).equals("voiture")){
            if(p.getPermis() && p.getClass() != town.Hippie.class){
                return true;
            }else{
                if(this.changeModeDeplacement(p, "velo")){
                    return true;
                }
            }
            return false;
        }else if(getModeDeplacement(this).equals("velo")){
            if(p.getVelo()){
                return true;
            }else{
                if(p.getClass() != town.Hippie.class && this.changeModeDeplacement(p, "voiture")){
                    return true;
                }
            }
            return false;
        }
        System.out.println("AUTRE deplacement");
        return false;
    }

    @Override
    public String toString() {
        return  "RO";
    }
}
