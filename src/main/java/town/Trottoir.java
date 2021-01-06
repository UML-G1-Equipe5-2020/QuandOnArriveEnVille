package town;

public class Trottoir extends CaseDeDeplacement implements Piege{


    public Trottoir(int ligne, int colonne) {
        super(ligne, colonne);
        this.setModeDeplacement("pieds");
    }

    public void setModeDeplacement(String modeDeplacement) {
        if(modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            super.setModeDeplacement(modeDeplacement, this.getClass());
        }
    }


    public boolean changeModeDeplacement(Personnage pers, String modeDeplacement) {
        if(modeDeplacement.equals("velo") || modeDeplacement.equals("pieds")) {
            return super.changeModeDeplacement(pers, modeDeplacement);
        }
        return false;
    }


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
                if (Math.random() <= 0.005){

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
                pers.updateValue("vie", -3);
            }else if (0.33 <= alea && alea <= 0.66) {
                pers.updateValue("moral", -2);
            }else{
                pers.updateValue("satiete", -1);
            }
        }
    }

    @Override
    public String toString() {
        return  "TR";
    }
}
