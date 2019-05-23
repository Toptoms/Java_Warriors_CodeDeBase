package warriors.engine;

import warriors.contracts.*;

import java.util.UUID;

public class GenerateGameState implements GameState {
    private Hero hero;
    private Map map;
    private String playername;
    private String gameid;
    private GameStatus gamestatus;
    private String lastlog = "0";
    private int currentcase;


    public GenerateGameState(String playername, Hero hero, Map map) {
        this.playername = playername;
        this.hero = hero;
        this.map = map;
        this.gamestatus = GameStatus.IN_PROGRESS;
        this.gameid = UUID.randomUUID().toString();

    }

    public void setCurrentcase(int dice) {
        lastlog = String.valueOf(this.currentcase += dice);
    }


    @Override
    public String getPlayerName() {
        return playername;
    }

    @Override
    public String getGameId() {
        return gameid;
    }

    @Override
    public GameStatus getGameStatus() {

        if (currentcase > 64) {
            this.gamestatus = GameStatus.FINISHED;

        } else if (hero.getLife() <= 0) {
            this.gamestatus = GameStatus.GAME_OVER;
        }
        return gamestatus;
    }

    @Override
    public Hero getHero() {
        return hero;
    }

    @Override
    public Map getMap() {
        return map;
    }

    @Override
    public String getLastLog() {


        if (currentcase >= 64) {
            System.out.println("YOU WIN !!!!");
        } else if (hero.getLife() == 0) System.out.println("YOU LOSE !!!!");



        return hero.toString() + "\ncase: " + lastlog;
    }


    @Override
    public int getCurrentCase() {
        return currentcase;
    }

}
