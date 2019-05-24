package warriors.engine;

import warriors.contracts.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Warriors implements WarriorsAPI {
    private ArrayList<Hero> personnagestab = new ArrayList<>();
    private ArrayList<Map> mapstab = new ArrayList<>();
    private Hashtable<String, GameState> herostate = new Hashtable<>();


    public Warriors() {

        Personnage magicien = new Magicien("Magicien", "brouillon", 3, 8);
        personnagestab.add(magicien);
        Personnage guerrier = new Guerrier("Guerrier", "charnu", 5, 5);
        personnagestab.add(guerrier);

        GenerateMap mapdebase = new GenerateMap("mapone", 64);
        mapstab.add(mapdebase);

    }

    public void ResetPlayers() {
        personnagestab=new ArrayList<>();
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

    @Override
    public GameState nextTurn(String gameID) {
        int de = (int) (Math.random() * (6 - 1)) + 1;
        //herostate.get(gameID).getCurrentCase();
        GenerateGameState myGame = ((GenerateGameState) herostate.get(gameID));
        myGame.setCurrentcase(de);
        Case objcase = (((GenerateMap) myGame.getMap()).Casestatus(myGame.getCurrentCase()));
        System.out.println(objcase);

        if (objcase != null) {
            objcase.modifstat(myGame.getHero());
        }

        return myGame;
    }

    public GameState nextTurnTest(String gameID) {
        String orderPath = "./src/order.csv";
        FileReader dice = null;

        try {
            dice = new FileReader(orderPath);
            System.out.println(dice);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;

        int de = 3;
        i++;
        //herostate.get(gameID).getCurrentCase();
        GenerateGameState myGame = ((GenerateGameState) herostate.get(gameID));
        myGame.setCurrentcase(de);
        Case objcase = (((GenerateMap) myGame.getMap()).Casestatus(myGame.getCurrentCase()));
        System.out.println(objcase);

        if (objcase != null) {
            objcase.modifstat(myGame.getHero());
        }

        return myGame;
    }

}
