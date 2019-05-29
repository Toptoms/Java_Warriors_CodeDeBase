package warriors.engine;

import warriors.contracts.Case;
import warriors.contracts.Map;

import java.util.ArrayList;


public class Plateau implements Map {
    private String name;
    private int nombredecase;
    private ArrayList<Case> mapone = new ArrayList<>();

    public Plateau(String name, int nombredecase) {
        this.name = name;
        this.nombredecase = nombredecase;
        Casestatus();
    }

    public void Casestatus() {

        for (int i = 0; i < nombredecase; i++) {

            if (i == 45 || i == 52 || i == 56 || i == 62) {
                mapone.add(new Ennemis("dragon", 15, 4, "dragon"));

            } else if (i == 10 || i == 20 || i == 25 || i == 32 || i == 35 || i == 36 || i == 37 || i == 40 || i == 44 || i == 47) {
                mapone.add(new Ennemis("sorcier", 9, 2, "sorcier"));

            } else if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21 || i == 24 || i == 27 || i == 30) {
                mapone.add(new Ennemis("goblins", 6, 1, "goblins"));

            } else if (i == 2 || i == 11 || i == 14 || i == 19 || i == 26) {
                mapone.add(new Equipement("arc", 1));

            } else if (i == 5 || i == 22 || i == 38) {
                mapone.add(new Equipement("massue", 3));

            } else if (i == 42 || i == 53) {
                mapone.add(new Equipement("epee", 5));

            } else if (i == 1 || i == 4 || i == 8 || i == 17 || i == 23) {
                mapone.add(new Equipement("eclair", 2));

            } else if (i == 48 || i == 49) {
                mapone.add(new Equipement("boules de feu", 7));

            } else if (i == 7 || i == 13 || i == 28 || i == 29 || i == 33) {
                mapone.add(new Equipement("potion mineure", 1));
            } else mapone.add(new Equipement("neutre", 0));

        }

    }

    public Case getMapone(int currentCase) {
        return mapone.get(currentCase);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfCase() {
        return nombredecase;
    }

}
