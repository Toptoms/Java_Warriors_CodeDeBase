package warriors.engine;

import warriors.contracts.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Warriors implements WarriorsAPI {
    private ArrayList<Hero> personnagestab = new ArrayList<>();
    private ArrayList<Map> mapstab = new ArrayList<>();
    private Hashtable<String, GameState> herostate = new Hashtable<>();
    private ArrayList csvtab = new ArrayList();


    public Warriors(String orderPath) throws IOException {

        Personnage magicien = new Magicien("Magicien", "brouillon", 3, 8);
        personnagestab.add(magicien);
        Personnage guerrier = new Guerrier("Guerrier", "charnu", 5, 5);
        personnagestab.add(guerrier);

        Plateau mapdebase = new Plateau("mapone", 64);
        mapstab.add(mapdebase);

        BufferedReader br = new BufferedReader(new FileReader(orderPath));
        String ligne = null;
        while ((ligne = br.readLine()) != null) {
            // Retourner la ligne dans un tableau
            String[] data = ligne.split(",");

            // Afficher le contenu du tableau
            for (String val : data) {
                csvtab.add(val);
            }
        }

    }

    public void ResetPlayers() {
        personnagestab = new ArrayList<>();
        Personnage magicien = new Magicien("Magicien", "brouillon", 3, 8);
        personnagestab.add(magicien);
        Personnage guerrier = new Guerrier("Guerrier", "charnu", 5, 5);
        personnagestab.add(guerrier);
    }

    @Override
    public List<Hero> getHeroes() {
        return personnagestab;
    }

    @Override
    public List<Map> getMaps() {
        return mapstab;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        GenerateGameState newGame = new GenerateGameState(playerName, hero, map);
        herostate.put(newGame.getGameId(), newGame);

        return newGame;

    }

    public GameState positionperso( String gameID, int de){
        GenerateGameState myGame = ((GenerateGameState) herostate.get(gameID));
        myGame.setCurrentcase(de);
        Case objcase = (((Plateau) myGame.getMap()).getMapone(myGame.getCurrentCase()));

        objcase.modifstat(myGame.getHero());
        System.out.println(objcase);

        return myGame;
    }

    @Override
    public GameState nextTurn(String gameID) {
        int de = (int) (Math.random() * (6 - 1)) + 1;


        return  positionperso(gameID,  de);
    }

    public GameState nextTurnTest(String gameID, int i) {
        int de = Integer.parseInt((String) csvtab.get(i));

        return positionperso(gameID,  de);
    }

}
