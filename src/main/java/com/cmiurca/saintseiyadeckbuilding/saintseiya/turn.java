package com.cmiurca.saintseiyadeckbuilding.saintseiya;

/**
 * Turn class, where the turn is created
 * 
 * @author Sirwolf
 * @version 1.0
 * @since 2023-02-04
 */
public class turn {

    /**
     * Number of turn
     */
    private int turnNumber;

    /**
     * Player who is playing
     */
    private Player playerTurn;

    /**
     * Constructor of the turn
     * 
     * @param turnNumber
     * @param playerTurn
     */
    public turn(int turnNumber, Player playerTurn) {
        this.turnNumber = turnNumber;
        this.playerTurn = playerTurn;
    }

    /**
     * Simple getter for turn number
     * @return int turn number
     */
    public int getTurnNumber() {
        return turnNumber;
    }

    /**
     * Simple setter for turn number
     * @param turnNumber turn number to set
     */
    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    /**
     * Simple getter for player turn
     * @return Player player turn
     */
    public Player getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Simple setter for player turn
     * @param playerTurn player turn to set
     */
    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }

    /**
     * Simple toString method
     * @return String turn
     */
    @Override
    public String toString() {
        return "turn [playerTurn=" + playerTurn + ", turnNumber=" + turnNumber + "]";
    }


    
}
