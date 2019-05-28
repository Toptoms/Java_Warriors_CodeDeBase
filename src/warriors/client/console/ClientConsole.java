package warriors.client.console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.Warriors;

public class ClientConsole {

    private static String MENU_COMMENCER_PARTIE = "1";
    private static String MENU_COMMENCER_PARTIE_TEST = "2";
    private static String MENU_QUITTER = "3";

    public static void main(String[] args)  throws Exception {
        String path = args[0];

        WarriorsAPI warriors = new Warriors(path) ;
        Scanner sc = new Scanner(System.in);
        String menuChoice = "";
        int test = 0;
        do {
            menuChoice = displayMenu(sc);
            if (menuChoice.equals(MENU_COMMENCER_PARTIE)) {

                startGame(warriors, sc, test);
            } else if (menuChoice.equals(MENU_COMMENCER_PARTIE_TEST)) {
                test = 1;
                startGame(warriors, sc, test);

            }
        } while (!menuChoice.equals(MENU_QUITTER));
        sc.close();
        System.out.println("à bientôt");
    }

    private static void startGame(WarriorsAPI warriors, Scanner sc, int test) {
        ((Warriors) warriors).ResetPlayers();
        System.out.println();
        System.out.println("Entrez votre nom:");
        String playerName = sc.nextLine();

        System.out.println("Choisissez votre héro:");
        for (int i = 0; i < warriors.getHeroes().size(); i++) {
            Hero heroe = warriors.getHeroes().get(i);
            System.out.println(i + 1 + " - " + heroe.getName());
            System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
            System.out.println("    Niveau de vie : " + heroe.getLife());
        }
        Hero chosenHeroe = warriors.getHeroes().get(Integer.parseInt(sc.nextLine()) - 1);

        System.out.println("Choisissez votre map:");
        for (int i = 0; i < warriors.getMaps().size(); i++) {
            Map map = warriors.getMaps().get(i);
            System.out.println(i + 1 + " - " + map.getName());
        }
        Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);

        GameState gameState = warriors.createGame(playerName, chosenHeroe, choosenMap);
        int i = 0;
        String gameId = gameState.getGameId();
        while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
            System.out.println(gameState.getLastLog());
            if (test == 0) {
                System.out.println("\nAppuyer sur une touche pour lancer le dé");
                if (sc.hasNext())
                    sc.nextLine();
                gameState = warriors.nextTurn(gameId);
            } else {
                gameState = ((Warriors) warriors).nextTurnTest(gameId, i);
                i++;
            }
        }

        System.out.println(gameState.getLastLog());
    }

    private static String displayMenu(Scanner sc) {
        System.out.println();
        System.out.println("================== Java Warriors ==================");
        System.out.println("1 - Commencer une partie");
        System.out.println("2 - Commencer une partie test");
        System.out.println("3 - Quitter");
        if (sc.hasNext()) {
            String choice = sc.nextLine();
            return choice;
        }

        return "";
    }
}

