package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import java.util.ArrayList;

public class GameTest {

    /**
     * Main method for testing see if the game is working
     */
    public static void main(String[] args) {
        Game game = new Game(); // Create a new game with default values (4 players)

        String[] playerNames = new String[]{"Romain", "Elise", "Sylvain", "Killian"};
        Hero[] playerHeroes = new Hero[]{Hero.SEIYA, Hero.HYOGA, Hero.SHIRYU, Hero.IKKI};
        
        game.initPlayers();
        
        game.setALLPlayerName(playerNames);
        game.setAllPlayerHero(playerHeroes);
        game.setAllPlayerArmor();

        Player player = game.getPlayer(0);
        Card armor = player.getArmor();
        
        System.out.println("Game created with " + game.getPlayerCount() + " players.");
        System.out.println("Player 0 is : " + player.toString());
        System.out.println("And has armor : " + armor);
        System.out.println("That has effect : " + armor.getEffect() + "\n");

        System.out.println("Distributing hands...\n");

        ArrayList<ArrayList<Card>> hands = new ArrayList<ArrayList<Card>>();
        for (int i = 0; i < game.getPlayerCount(); i++) {
            ArrayList<Card> playerHand = new ArrayList<Card>();
            for (int j = 0; j < 5; j++) {
                int id = 1;
                playerHand.add(new Card(id));
            }
            hands.add(playerHand);
        }
        
        System.out.println("Player 0 [" + player.getName() + "] has hand : ");
        game.setAllPlayerHand(hands);
        for(Card c : player.getHand()) {
            System.out.println(c);
        }
        System.out.println("");
        System.out.println("Initializing river : ");

        Card [] cardLocation = new Card[6];
        for (int i = 0; i < 6; i++) {
            cardLocation[i] = new Card(20 + (int)(Math.random() * ((80 - 10) + 1)));
        }
        game.setPlayMatCardLocation(cardLocation);
        for(Card c : game.getPlayMat().getCardLocation()) {
            System.out.println(c);
        }

        System.out.println("\nPlayer 0 [" + player.getName() + "] tries to get cards from river :");
        for(int i = game.getPlayMat().getCardLocation().length-1; i > -1; i--) {
            try {
                Card c = game.getPlayMat().getCardInLocationFromIndex(i);
                player.acquireByStrength(game.getPlayMat(), i, player.getHand());
                System.out.println("Acquired card \"" + c.getName() + "\" with name[" + c.getName() + "]");
            } catch (IllegalArgumentException e) {
                System.out.println("Not enough strength to aquire card with name[" + game.getPlayMat().getCardInLocationFromIndex(i).getName() + "]");
            } catch (NullPointerException e) {
                //This is triggered only because the player hand is smaller than the river
            }
        }
        
        //game.getPlayer(game.getCurrentPlayerIndex()).applyEffect(game.getPlayMat(), ...); This is code is to apply effects???...

        System.out.println("\n" + player.help(game.getPlayMat()));
    }
}
