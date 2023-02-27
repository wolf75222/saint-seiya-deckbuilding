package com.cmiurca.saintseiyadeckbuilding.saintseiya;

/**
 * Turn class, where the turn is created
 * 
 * @author Sirwolf
 * @version 1.0
 * @since 2023-02-04
 */
public class Round {

    /**
     * Number of round
     */
    private int roundNumber;

    /**
     * Player who is playing
     */
    private Player playerTurn;

    /**
     * Players of the game
     */
    private Player [] players;

    /**
     * Constructor of the turn
     * 
     * @param roundNumber
     * @param playerTurn
     * @param players
     */
    public Round(int roundNumber, Player playerTurn, Player[] players) {
        this.roundNumber = roundNumber;
        this.playerTurn = playerTurn;
        this.players = players;
    }

    /**
     * Simple getter for turn number
     * @return int turn number
     */
    public int getRoundNumber() {
        return roundNumber;
    }

    /**
     * Simple setter for turn number
     * @param roundNumber turn number to set
     */
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    /**
     * Simple getter for player turn
     * @return Player player turn
     */
    public Player getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Simple getter for player turn index
     * @return int player turn index
     */
    public int getPlayerTurnIndex() {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == playerTurn) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Simple setter for player turn
     * @param playerTurn player turn to set
     */
    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }

    /**
     * Simple getter for players
     * @return Player[] players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Simple setter for players
     * @param players players to set
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * Simple toString method
     * @return String turn
     */
    @Override
    public String toString() {
        return "turn [playerTurn=" + playerTurn + ", turnNumber=" + roundNumber + "]";
    }

    public void nextTurn() {
        int playerTurnIndex = getPlayerTurnIndex();
        if (playerTurnIndex == players.length - 1) {
            playerTurnIndex = 0;
        } else {
            playerTurnIndex++;
        }
        playerTurn = players[playerTurnIndex];
    }

    public void turn() {

        // Main Phase
        //mainPhase();
        // Maintenance Phase
        //maintenancePhase();


    }

    public void mainPhase(int playerChoice) {

        switch (playerChoice) {
            case 1:
                // Jouer des Personnages
                break;
            case 2:
                // Jouer des Armures //TODO : Elise et Evan
                break;
            case 3:
                // Aquerrir des cartes du PlayMat en cumulant de la Force ou du cosmos //TODO : Elise et Evan
                break;
            case 4:
                // Activer les effets de certaines cartes
                break;
            case 5:
                // Soigner des personnages blessés //TODO : Elise et Evan

                break;
            default:
                break;
        }
    }

    public void maintenancePhase() {
        /* 
         * Cette phase met fin au tour du joueur. Elle consiste en une succession d’étapes permettant de reconstituer sa main et de préparer le terrain pour le joueur suivant.
            4. Décaler toutes les cartes restantes vers la droite du terrain (b).
            A noter : l’effet Flamme de la carte retirée s’applique à ce moment-là.
            Exemple de retrait de Flamme :
            • Un joueur acquiert un Chevalier d’Or depuis le terrain (tous les Chevaliers d’Or
            présent sur le terrain (voir la carte).
            • Si Ptolemy de la Flèche est révélé sur le terrain (voir la carte).
            1. Défausser toutes les cartes jouées ce tour (les Personnages blessés et l’Armure en jeu ne sont pas défaussés) ainsi que les cartes de sa main qu’on ne souhaite pas garder pour le prochain tour de jeu.
            A
            2. Piocher jusqu’à avoir 5 cartes en main.
            3. Retirer du jeu la carte présente sur le 6e emplacement du terrain (A).
            b
            c 3
            5. Compléter le terrain en révélant de nouvelles cartes depuis la réserve, aux emplacements vides, de droite à gauche (c).
            A noter : l’effet Arrivée d’une carte s’applique à ce moment-là.
            1
            6. Le joueur à sa gauche dev•ient le joueur actif et débute son tour de jeu.
         */

    }
}