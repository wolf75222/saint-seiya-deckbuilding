package com.cmiurca.saintseiyadeckbuilding.saintseiya;

/**
 * Game class, where the game is created
 * 
 * @author LittleBigOwI
 * @version 1.2
 * @since 2023-02-04
 */
public class Game {
    private int playerCount = 0;

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

    /**
     * Main game start method, called in GameController class
     */
    public void start() {
        return;
    }
}
