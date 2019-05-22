package warriors.engine;

import warriors.contracts.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Warriors implements WarriorsAPI {
    private ArrayList<Hero> personnagestab = new ArrayList<>();
    private ArrayList<Map> mapstab = new ArrayList<>();
    private Hashtable<String, GameState> herostate = new Hashtable<>();


    public Warriors() {

        Personnage magicien = new Magicien("cedric", "brouillon", 3, 8);
        personnagestab.add(magicien);
        Personnage guerrier = new Guerrier("flo", "charnu", 5, 5);
        personnagestab.add(guerrier);

        GenerateMap mapdebase = new GenerateMap("mapone", 64);
        mapstab.add(mapdebase);
    }

    public void Action(Case objcas, GenerateGameState myGame) {


        if (myGame.getHero() instanceof Guerrier) {
            if (((Equipement)objcas).getNom() == "arc"||"massue"||"epee"){

            }

            ((Guerrier) myGame.getHero()).setLife();
        }else{}


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
        Action(objcase, myGame);
        return myGame;
    }
}
