package town;

public class Route extends CaseDeDeplacement implements Piege{
    public void suru(Personnage pers){
        switch(pers.getDeplacement()){
            case "Voiture":
                pers.updateValue("moral", -2);
                if (Math.random() <= 0.02){
                    pers.mourrir();
                }
                if (Math.random() <= 0.05){
                    pers.updateValue("arrestation", 1);
                }
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
                pers.updateValue("vie", -1);
            }else if (0.33 <= alea && alea <= 0.66) {
                pers.updateValue("moral", -1);
            }else{
                pers.updateValue("hydratation", -2);
                pers.updateValue("satiete", -2);
            }
        }
    }
}
