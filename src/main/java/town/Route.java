package town;

public class Route extends CaseDeDeplacement implements Piege{

    public Route(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("Voiture");
    }

    @Override
    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement.equals("Voiture") || modeDeplacement.equals("Velo")) {
            super.setModeDeplacement(modeDeplacement);
        }
    }


    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("Voiture") || modeDeplacement.equals("Velo")) {
            return super.changeModeDeplacement(pers, modeDeplacement);
        }
        return false;
    }

    public void suru(Personnage pers){
        switch(getModeDeplacement()){
            case "Voiture":
                System.out.println("Vrooom");
                pers.updateValue("moral", -2);
                if (Math.random() <= 0.02){
                    pers.mourir();
                }
                if (Math.random() <= 0.05){
                    System.out.println("22 vlà les flic : vous vous êtes fait arrêtés");
                    pers.incrementerArrestation();
                }
                break;
            case "Velo":
                System.out.println("DingDing !");
                pers.updateValue("hydratation", -5);
                pers.updateValue("satiete", -5);
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
        if(this.getModeDeplacement() == "Voiture"){
            System.out.println("en voiture");
            if(p.getPermis()){
                return true;
            }else{
                if(this.changeModeDeplacement(p, "Velo")){
                    return true;
                }
            }
            return false;
        }else if(getModeDeplacement() == "Velo"){
            System.out.println("en voiture");
            if(p.getVelo()){
                return true;
            }else{
                if(this.changeModeDeplacement(p, "Voiture")){
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
