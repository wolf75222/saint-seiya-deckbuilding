package com.cmiurca.saintseiyadeckbuilding.saintseiya;

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
        Card[][] hands = new Card[4][5];
        for (int i = 0; i < hands.length; i++) {
            for (int j = 0; j < hands[i].length; j++) {
                int id = 1;
                hands[i][j] = new Card(1);

            }
        }
        game.setAllPlayerHand(hands);
        System.out.println(game.toString());
        Card[] cardLocation = new Card[6];
        for (int i = 0; i < cardLocation.length; i++) {
            cardLocation[i] = new Card(61);
        }
        game.setPlayMatCardLocation(cardLocation);
        System.out.println(game.getPlayMat().toString());
        Card[] hand0 = game.getPlayer(0).getHand();
        game.getPlayer(game.getCurrentPlayerIndex()).acquireByStrength(game.getPlayMat(), 0, hand0);
        System.out.println(game.toString());
        //game.getPlayer(game.getCurrentPlayerIndex()).applyEffect(game.getPlayMat(), ...);
        // add a card with id 5 to the player
        game.getPlayer(0).addCardToHand(new Card(5));

        System.out.println(game.getPlayer(0).help(game.getPlayMat()));
    }
}
