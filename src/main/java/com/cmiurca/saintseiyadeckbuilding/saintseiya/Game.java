package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import java.util.ArrayList;

/**
 * Game class, where the game is created
 * 
 * @author LittleBigOwI, Sirwolf
 * @version 1.3
 * @since 2023-02-04
 */
public class Game {
    
    /**
     * Number of players in game
     */
    private int playerCount;

    /**
     * Array of players in game
     */
    private ArrayList<Player> players;

    /**
     * PlayMat of the game
     */
    private PlayMat playMat;

    /**
     * Current Player index
     */
    private int currentPlayerIndex;

    /**
     * Simple getter for current player index
     * @return int current player index
     */
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    /**
     * Simple setter for current player index
     * @param currentPlayerIndex
     */
    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    /**
     * Simple getter for number of players in game
     * @return int number of players
     */
    public int getPlayerCount() {
        return this.playerCount;
    }

    /** 
     * Simple setter for number of players in game
     * @param playerCount number of players to set
     */
    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    /** 
     * Simple getter for players in game
     * @return Player[] array of players
     */
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /** 
     * Simple getter for playMat in game
     * @return PlayMat playMat
     */
    public PlayMat getPlayMat() {
        return this.playMat;
    }

    /** 
     * Simple setter for playMat in game
     * @param playMat playMat to set
     */
    public void setPlayMat(PlayMat playMat) {
        this.playMat = playMat;
    }

    /** 
     * Simple setter for players in game
     * @param players array of players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }


    /**
     * Constructor for Game class
     * @param playerCount number of players in game
     */
    public Game(int playerCount) {
        this.playerCount = playerCount;
        this.players = new ArrayList<>(playerCount);
        this.playMat = new PlayMat(this);
        this.currentPlayerIndex = 0;
    }

    /**
     * Constructor for Game class
     */
    public Game(){
        this.playerCount = 5;
        this.players = new ArrayList<>(playerCount);
        this.playMat = new PlayMat(this);
        this.currentPlayerIndex = 0;
    }

    /**
     * Method to initialize players
     */
    public void initPlayers(){
        for (int i = 0; i < this.playerCount; i++) {
            this.players.add(new Player());
        }
    }
    /**
     * Method to start the game
     */
    public void startGame() {
        System.out.println("Starting game with " + this.playerCount + " players");
        
    }

    /**
     * Method to set the hero of a player
     * @param playerIndex index of player
     * @param hero hero to set
     */
    public void setPlayerHero(int playerIndex, Hero hero) {
        this.players.get(playerIndex).setHero(hero);
    }

    /**
     * Method to set the hero of all players
     * @param heroes
     */
    public void setAllPlayerHero(Hero[] heroes) {
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setHero(heroes[i]);
        }
    }

    /**
     * Method to set the name of all players
     * @param names
     */
    public void setALLPlayerName(String[] names) {
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setName(names[i]);
        }
    }

    
    /**
     * Method to set the name of a player
     * @param playerIndex index of player
     * @param name name to set
     */
    public void setPlayerName(int playerIndex, String name) {
        this.players.get(playerIndex).setName(name);
    }
    
    /**
     * Method to set the deck of a player
     * @param playerIndex index of player
     * @param deck arraylist deck to set
     */
    public void setPlayerDeck(int playerIndex, ArrayList<Card> deck) {
        this.players.get(playerIndex).setDeck(deck);
    }

    /**
     * Method to set the deck of all players
     * @param decks
     */
    public void setAllPlayerDeck(ArrayList<ArrayList<Card>> decks) {
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setDeck(decks.get(i));
        }
    }

    /**
     * Method to set the hand of a player
     * @param playerIndex index of player
     * @param hand hand to set
     */
    public void setPlayerHand(int playerIndex, ArrayList<Card> hand) {
        this.players.get(playerIndex).setHand(hand);
    }

    /**
     * Method to set the hand of all players
     * @param hands
     */
    public void setAllPlayerHand(ArrayList<ArrayList<Card>> hands) {
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setHand(hands.get(i));
        }
    }

    /**
     * Method to set the discard of a player
     * @param playerIndex index of player
     * @param discard discard to set
     */
    public void setPlayerDiscard(int playerIndex, ArrayList<Card> discard) {
        this.players.get(playerIndex).setDiscard(discard);
    }

    /**
     * Method to set the discard of all players
     * @param discards
     */
    public void setAllPlayerDiscard(ArrayList<ArrayList<Card>> discards) {
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setDiscard(discards.get(i));
        }
    }

    /**
     * Method to set the destroyed cards of a player
     * @param playerIndex index of player
     * @param destroyedCards destroyed cards to set
     */
    public void setPlayerDestroyedCards(int playerIndex, ArrayList<Card> destroyedCards) {
        this.players.get(playerIndex).setDestroyedCards(destroyedCards);
    }

    /**
     * Method to set the destroyed cards of all players
     * @param destroyedCards
     */
    public void setAllPlayerDestroyedCards(ArrayList<ArrayList<Card>> destroyedCards) {
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setDestroyedCards(destroyedCards.get(i));
        }
    }

    /**
     * Method to set the Player armor
     * @param playerIndex index of player
     */
    public void setPlayerArmor(int playerIndex)  {
        this.players.get(playerIndex).setArmor(new Card(this.players.get(playerIndex).getHero().getArmorId()));
    }

    /**
     * Method to set the Players armors
     */
    public void setAllPlayerArmor()   {
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setArmor(new Card(this.players.get(i).getHero().getArmorId()));
        }
    }

    /**
     * Method to set the Player injured characters
     * @param playerIndex
     * @param injuredCharacters
     */
    public void setPlayerInjuredCharacters(int playerIndex, ArrayList<Card> injuredCharacters) {
        this.players.get(playerIndex).setInjuredCharacters(injuredCharacters);
    }
        
    /**
     * Method to set the Players injured characters
     * @param injuredCharacters
     */
    public void setAllPlayerInjuredCharacters(ArrayList<ArrayList<Card>> injuredCharacters) {
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setInjuredCharacters(injuredCharacters.get(i));
        }
    }

    /**
     * Method to set the cardLocation of the playMat
     * @param cardLocation Card[] to set the playMat cardLocation
     */
    public void setPlayMatCardLocation(Card[] cardLocation) {
        this.playMat.setCardLocation(cardLocation);
    }

    /**
     * Method to end the game
     */
    public void endGame() {
        System.out.println("Ending game with " + this.playerCount + " players");
        //...
    }

    /**
     * Method to add a player to the game
     * @param player player to add
     */
    public void addPlayer(Player player) {
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i) == null) {
                this.players.set(i, player);
                break;
            }
        }
    }

    /**
     * Method to remove a player from the game
     * @param player player to remove
     */
    public void removePlayer(Player player) {
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i) == player) {
                this.players.set(i, null);
                break;
            }
        }
    }

    /**
     * Method to remove a player from the game
     * @param playerIndex index of player to remove
     */
    public void removePlayer(int playerIndex) {
        this.players.set(playerIndex, null);
    }

    /**
     * Method to get a player from the game
     * @param playerIndex index of player to get
     * @return Player player
     */
    public Player getPlayer(int playerIndex) {
        return this.players.get(playerIndex);
    }

    /**
     * To string method for Game
     * @return String representation of Game
     */
    @Override
    public String toString() {
        return "Game{" +
                "playerCount=" + playerCount +
                ", players=" + players.toString() +
                ", playMat=" + "playMat" +
                ", currentPlayerIndex=" + currentPlayerIndex +
                '}';
    }

    /**
     * Method nextPlayer to set the next player as the current player
     */
    public void nextPlayer() {
        if (this.currentPlayerIndex == this.playerCount - 1 || this.players.get(this.currentPlayerIndex + 1) == null) {
            this.currentPlayerIndex = 0;
        } else {
            this.currentPlayerIndex++;
        }
    }




}
