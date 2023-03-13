package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import java.util.ArrayList;
import java.util.Arrays;

public class GameTest {

    /**
     * Main method for testing see if the game is working
     */
    public static void main(String[] args) {
        Game game = new Game(); // Create a new game with default values (4 players)
        System.out.println("Game created with " + game.getPlayerCount() + " players");
        System.out.println("Current player index is " + game.getCurrentPlayerIndex());
        System.out.println(game.getPlayMat().toString());
        System.out.println(game.toString());
        game.initPlayers();
        System.out.println(game.toString());
        String[] names = {"Romain", "Elise", "Sylvain", "Killian"};
        game.setALLPlayerName(names);
        System.out.println(game.toString());
        Hero[] heroes = {Hero.SEIYA, Hero.HYOGA, Hero.SHIRYU, Hero.IKKI};
        game.setAllPlayerHero(heroes);
        System.out.println(game.toString());
        game.setAllPlayerArmor();
        System.out.println(game.toString());

        // test with the same hand for all players
        ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>();
        for (int i = 0; i < game.getPlayerCount(); i++) {
            ArrayList<Card> playerHand = new ArrayList<Card>();
            for (int j = 0; j < 5; j++) {
                int id = 1;
                playerHand.add(new Card(id));
            }
            hands.add(playerHand);
        }
        game.setAllPlayerHand(hands);
        System.out.println(game.toString());

        Card [] cardLocation = new Card[6];
        for (int i = 0; i < 6; i++) {
            cardLocation[i] = new Card(61);
        }
        game.setPlayMatCardLocation(cardLocation);
        System.out.println(game.getPlayMat().toString());

        ArrayList<Card> hand0 = game.getPlayer(0).getHand();
        game.getPlayer(game.getCurrentPlayerIndex()).acquireByStrength(game.getPlayMat(), 0, hand0);
        System.out.println(game.toString());

        //game.getPlayer(game.getCurrentPlayerIndex()).applyEffect(game.getPlayMat(), ...);

        // add a card with id 5 to the player
        game.getPlayer(0).addCardToHand(new Card(5));
        System.out.println(game.getPlayer(0).help(game.getPlayMat()));
    }
}
