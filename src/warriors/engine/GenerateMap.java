package warriors.engine;

import warriors.contracts.Case;
import warriors.contracts.Map;


public class GenerateMap implements Map {
    private String name;
    private int numbercase;

    public GenerateMap(String name, int numbercase) {
        this.name = name;
        this.numbercase = numbercase;
    }

    public Case Casestatus(int casestatut) {
        Case objcase = null;
        if (casestatut == 45 || casestatut == 52 || casestatut == 56 || casestatut == 62) {
            objcase = new Ennemis("dragon", 15, 4, "dragon");

        } else if (casestatut == 10 || casestatut == 20 || casestatut == 25 || casestatut == 32 || casestatut == 35 || casestatut == 36 || casestatut == 37 || casestatut == 40 || casestatut == 44 || casestatut == 47) {
            objcase = new Ennemis("sorcier", 9, 2, "sorcier");

        } else if (casestatut == 3 || casestatut == 6 || casestatut == 9 || casestatut == 12 || casestatut == 15 || casestatut == 18 || casestatut == 21 || casestatut == 24 || casestatut == 27 || casestatut == 30) {
            objcase = new Ennemis("goblins", 6, 1, "goblins");

        } else if (casestatut == 2 || casestatut == 11 || casestatut == 14 || casestatut == 19 || casestatut == 26) {
            objcase = new Equipement("arc", 1);

        } else if (casestatut == 5 || casestatut == 22 || casestatut == 38) {
            objcase = new Equipement("massue", 3);

        } else if (casestatut == 42 || casestatut == 53) {
            objcase = new Equipement("epee", 5);

        } else if (casestatut == 1 || casestatut == 4 || casestatut == 8 || casestatut == 17 || casestatut == 23) {
            objcase = new Equipement("eclair", 2);

        } else if (casestatut == 48 || casestatut == 49) {
            objcase = new Equipement("boules de feu", 7);

        } else if (casestatut == 7 || casestatut == 13 || casestatut == 28 || casestatut == 29 || casestatut == 33) {
            objcase = new Equipement("potion mineure", 1);
        }
        return objcase;

    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfCase() {
        return numbercase;
    }

}
