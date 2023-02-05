package com.cmiurca.saintseiyadeckbuilding.saintseiya;

/**
 * Game class, where the game is created
 * 
 * @author LittleBigOwI, Sirwolf
 * @version 1.3
 * @since 2023-02-04
 */
public class Game {
<<<<<<< HEAD
    
    /**
     * Number of players in game
     */
    private int playerCount;
=======
    private int playerCount = 0;
>>>>>>> 1c7a4adbebe65269c07e4db7638bad6b32e8f895

    /**
     * Array of players in game
     */
    private Player[] players;


    /** 
     * Simple getter for number of players in game
     * @return int number of players
     */
    public int getPlayerCount() {
        return this.playerCount;
    }

    /** 
     * Simple setter for number of players in game
     * @param int number of players to set
     */
    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

<<<<<<< HEAD
    /** 
     * Simple getter for players in game
     * @return Player[] array of players
     */
    public Player[] getPlayers() {
        return this.players;
    }

    /** 
     * Simple setter for players in game
     * @param Player[] array of players to set
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    

    /**
     * Constructor for Game class
     * @param playerCount number of players in game
     * @param players array of players in game
     */
    public Game(int playerCount) {
        this.playerCount = playerCount;
        this.players = new Player[playerCount];
    }

    /**
     * Method to start the game
     */
    public void startGame() {
        System.out.println("Starting game with " + this.playerCount + " players");
        //...
    }

    /**
     * Method to end the game
     */
    public void endGame() {
        System.out.println("Ending game with " + this.playerCount + " players");
        //...
    }

=======
    /**
     * Main game start method, called in GameController class
     */
    public void start() {
        return;
    }
>>>>>>> 1c7a4adbebe65269c07e4db7638bad6b32e8f895
}
