package town;

public class Main {
    public static void main(String args[]) throws Exception {
        Ville honeyWood = new Ville();

        honeyWood.addCase(0, 0, "Bar");
        honeyWood.addCase(0, 1, "Bibliotheque");
        honeyWood.addCase(0, 2, "Maison");

        honeyWood.showCase(0, 0);
        honeyWood.showCase(0, 1);
        honeyWood.showCase(0, 2);

        Standard me = new Standard(honeyWood.getCase(0 , 2), true, true, true);
        System.out.println(me.seDeplacer("left", honeyWood));
    }
}
