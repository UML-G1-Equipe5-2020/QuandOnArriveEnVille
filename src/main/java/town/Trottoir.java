package town;

public class Trottoir extends CaseDeDeplacement implements Piege{
    public void suru(Personnage pers){
        switch(pers.getDeplacement()){
            case "Pied":
                pers.updateValue"hydratation", -10);
                pers.updateValue("satiete", -10);
            case "Velo":
                pers.updateValue("hydratation", -5);
                pers.updateValue("satiete", -5);
                if (Math.random() <= 0.005){
                    pers.mourrir();
                }
        }
        determinerPiege();
    }

    @Override
    public void determinerPiege() {
        if (Math.random() <= 0.05){
            int alea = Math.random()
            if (alea <= 0.33){
                pers.updateValue("vie", -3);
            }else if (0.33 <= alea && alea <= 0.66) {
                pers.updateValue("moral", -2);
            }else{
                pers.updateValue("satiete", -1);
            }
        }
    }
}
