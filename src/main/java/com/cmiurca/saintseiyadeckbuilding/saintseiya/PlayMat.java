package com.cmiurca.saintseiyadeckbuilding.saintseiya;

/**
 * PlayMat class, where the playmat is created
 * 
 * @author Sirwolf
 * @version 2.0
 * @since 2023-02-04
 */
public class PlayMat {
    
    /*
     * The card location of the playmat.
     */
    private Card [] cardLocation = new Card[6];
    
    /*
     * The common discard of the playmat.
     */
    private Card [] commonDiscard = new Card[90];
    
    /*
     * The card reserve of the playmat.
     */
    private Card [] cardReserve = new Card[90];

    /*
     * The on going effect of the playmat.
     */
    private Effect onGoingEffect;

    /**
     * number of flameOfTheClock Remaining
     */
    private int flameOfTheClockRemaining;

    /**
     * current game
     */
    private Game currentGame;

    /**
     * Constructor for PlayMat class
     * @param cardLocation card location of the playmat
     * @param commonDiscard common discard of the playmat
     * @param cardReserve card reserve of the playmat
     * @param onGoingEffect on going effect of the playmat
     * @param flameOfTheClockRemaining number of flameOfTheClock Remaining
     * @param currentGame current game
     */
    public PlayMat(Card [] cardLocation, Card [] commonDiscard, Card [] cardReserve, Effect onGoingEffect, int flameOfTheClockRemaining, Game currentGame) {
        this.cardLocation = cardLocation;
        this.commonDiscard = commonDiscard;
        this.cardReserve = cardReserve;
        this.onGoingEffect = onGoingEffect;
        this.flameOfTheClockRemaining = flameOfTheClockRemaining;
        this.currentGame = currentGame;

    }

    /**
     * Constructor for PlayMat class
     * @param currentGame current game
     */
    public PlayMat(Game currentGame) {
        this.currentGame = currentGame;
        this.cardLocation = new Card[6];
        this.commonDiscard = new Card[90];
        this.cardReserve = new Card[90];
        this.onGoingEffect = null;
        this.flameOfTheClockRemaining = 12;

    }

    /**
     * Getter for cardLocation
     * @return Card[] cardLocation
     */
    public Card[] getCardLocation() {
        return cardLocation;
    }

    /**
     * Setter for cardLocation
     * @param cardLocation card location of the playmat
     */
    public void setCardLocation(Card[] cardLocation) {
        this.cardLocation = cardLocation;
    }

    /**
     * Getter for commonDiscard
     * @return Card[] commonDiscard
     */
    public Card[] getCommonDiscard() {
        return commonDiscard;
    }

    /**
     * Setter for commonDiscard
     * @param commonDiscard common discard of the playmat
     */
    public void setCommonDiscard(Card[] commonDiscard) {
        this.commonDiscard = commonDiscard;
    }

    /**
     * Getter for cardReserve
     * @return Card[] cardReserve
     */
    public Card[] getCardReserve() {
        return cardReserve;
    }

    /**
     * Setter for cardReserve
     * @param cardReserve card reserve of the playmat
     */
    public void setCardReserve(Card[] cardReserve) {
        this.cardReserve = cardReserve;
    }

    
    /**
     * Getter for onGoingEffect
     * @return Effect onGoingEffect
     */
    public Effect getOnGoingEffect() {
        return onGoingEffect;
    }

    /**
     * Setter for onGoingEffect
     * @param onGoingEffect on going effect of the playmat
     */
    public void setOnGoingEffect(Effect onGoingEffect) {
        this.onGoingEffect = onGoingEffect;
    }

    /**
     * Getter for flameOfTheClockRemaining
     * @return int flameOfTheClockRemaining
     */
    public int getFlameOfTheClockRemaining() {
        return flameOfTheClockRemaining;
    }

    /**
     * Setter for flameOfTheClockRemaining
     * @param flameOfTheClockRemaining number of flameOfTheClock Remaining
     */
    public void setFlameOfTheClockRemaining(int flameOfTheClockRemaining) {
        this.flameOfTheClockRemaining = flameOfTheClockRemaining;
    }

    /**
     * Getter for currentGame
     * @return Game currentGame
     */
    public Game getCurrentGame() {
        return currentGame;
    }

    /**
     * Setter for currentGame
     * @param currentGame current game
     */
    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    /**
     * Method to add a card to the card location
     * @param card card to be added
     * @param location location of the card
     */
    public void addCardToLocation(Card card, int location) {
        this.cardLocation[location] = card;
    }

    /**
     * Method to add a card to the common discard
     * @param card card to be added
     */
    public void addCardToCommonDiscard(Card card) {
        for (int i = 0; i < commonDiscard.length; i++) {
            if (commonDiscard[i] == null) {
                commonDiscard[i] = card;
                break;
            }
        }
    }

    /**
     * Method to add a card to the card reserve
     * @param card card to be added
     */
    public void addCardToCardReserve(Card card) {
        for (int i = 0; i < cardReserve.length; i++) {
            if (cardReserve[i] == null) {
                cardReserve[i] = card;
                break;
            }
        }
    }

    /**
     * Method to remove a card from the card location
     * @param location location of the card
     */
    public void removeCardFromLocation(int location) {
        this.cardLocation[location] = null;
    }

    /**
     * Method to remove a card from the common discard
     * @param card card to be removed
     */
    public void removeCardFromCommonDiscard(Card card) {
        for (int i = 0; i < commonDiscard.length; i++) {
            if (commonDiscard[i] == card) {
                commonDiscard[i] = null;
                break;
            }
        }
    }

    /**
     * Method to remove a card from the card reserve
     * @param card card to be removed
     */
    public void removeCardFromCardReserve(Card card) {
        for (int i = 0; i < cardReserve.length; i++) {
            if (cardReserve[i] == card) {
                cardReserve[i] = null;
                break;
            }
        }
    }

    /**
     * Method to remove flame of the clock
     * @param amount of flame of the clock to be removed
     * @param currentGame current game
     */
    public void removeFlameOfTheClock(int amount, Game currentGame) {
        if (this.flameOfTheClockRemaining - amount <= 0){
            this.flameOfTheClockRemaining = 0;
            currentGame.endGame();
        }
        else{
        this.flameOfTheClockRemaining -= amount;
        }
    }

    /**
     * Method to add flame of the clock
     * @param amount amount of flame of the clock to be added
     */
    public void addFlameOfTheClock(int amount) {
        this.flameOfTheClockRemaining += amount;
    }

    /**
     * Method to check if the card location is empty
     * @param location location of the card
     * @return boolean true if the card location is empty
     */
    public boolean isCardLocationEmpty(int location) {
        return this.cardLocation[location] == null;
    }

    /**
     * Method to check if the common discard is empty
     * @return boolean true if the common discard is empty
     */
    public boolean isCommonDiscardEmpty() {
        for (int i = 0; i < commonDiscard.length; i++) {
            if (commonDiscard[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to check if the card reserve is empty
     * @return boolean true if the card reserve is empty
     */
    public boolean isCardReserveEmpty() {
        for (int i = 0; i < cardReserve.length; i++) {
            if (cardReserve[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to check if the card location is full
     * @param location location of the card
     * @return boolean true if the card location is full
     */
    public boolean isCardLocationFull(int location) {
        return this.cardLocation[location] != null;
    }

    /**
     * Method to check if the common discard is full
     * @return boolean true if the common discard is full
     */
    public boolean isCommonDiscardFull() {
        for (int i = 0; i < commonDiscard.length; i++) {
            if (commonDiscard[i] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to check if the card reserve is full
     * @return boolean true if the card reserve is full
     */
    public boolean isCardReserveFull() {
        for (int i = 0; i < cardReserve.length; i++) {
            if (cardReserve[i] == null) {
                return false;
            }
        }
        return true;
    }




}
