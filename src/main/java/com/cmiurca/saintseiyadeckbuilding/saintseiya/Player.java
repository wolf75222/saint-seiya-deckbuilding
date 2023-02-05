package com.cmiurca.saintseiyadeckbuilding.saintseiya;


/**
 * Player class, where the player is created
 * 
 * @author Sirwolf
 * @version 1.0
 * @since 2023-02-04
 */
public class Player {

    /**
     * The name of the player
     */
    private String name;

    /**
     * The hero of the player
     */
    private Hero hero;

    /**
     * The deck of the player
     */
    private Card [] deck;

    /**
     * The hand of the player
     */
    private Card [] hand;
    
    /**
     * The discard of the player
     */
    private Card [] discard;
    
    /**
     * The destroyed Cards of the player
     */
    private Card [] destroyedCards;

    /**
     * The armor of the player
     */
    private Card armor;

    /**
     * The injured characters of the player
     */
    private Card [] injuredCharacters; 


    /**
     * Constructor of the player
     * @param name name of the player
     * @param hero hero of the player
     * @param deck deck of the player
     * @param hand hand of the player
     * @param discard discard of the player
     * @param destroyedCards destroyed cards of the player
     * @param armor armor of the player
     * @param injuredCharacters injured characters of the player
     */
    public Player(String name, Hero hero, Card [] deck, Card [] hand, Card [] discard, Card [] destroyedCards, Card armor, Card [] injuredCharacters) {
        this.name = name;
        this.hero = hero;
        this.deck = deck;
        this.hand = hand;
        this.discard = discard;
        this.destroyedCards = destroyedCards;
        this.armor = armor;
        this.injuredCharacters = injuredCharacters;
    }

    /**
     * Getter for name
     * @return String name
     */
    public String getName() {
        return name;
    }

    
    /**
     * Setter for name
     * @param name name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for hero
     * @return Hero hero
     */
    public Hero getHero() {
        return hero;
    }

    /**
     * Setter for hero  
     * @param hero hero of the player
     */
    public void setHero(Hero hero) {
        this.hero = hero;
    }


    /**
     * Getter for deck
     * @return Card[] deck
     */
    public Card[] getDeck() {
        return deck;
    }


    /**
     * Setter for deck
     * @param deck deck of the player
     */
    public void setDeck(Card[] deck) {
        this.deck = deck;
    }

    /**
     * Getter for hand
     * @return Card[] hand
     */
    public Card[] getHand() {
        return hand;
    }


    /**
     * Setter for hand
     * @param hand hand of the player
     */
    public void setHand(Card[] hand) {
        this.hand = hand;
    }
    

    /**
     * Getter for discard
     * @return Card[] discard
     */
    public Card[] getDiscard() {
        return discard;
    }

    /**
     * Setter for discard
     * @param discard discard of the player
     */
    public void setDiscard(Card[] discard) {
        this.discard = discard;
    }

    /**
     * Getter for destroyedCards
     * @return Card[] destroyedCards
     */
    public Card[] getDestroyedCards() {
        return destroyedCards;
    }

    /**
     * Setter for destroyedCards
     * @param destroyedCards destroyed cards of the player
     */
    public void setDestroyedCards(Card[] destroyedCards) {
        this.destroyedCards = destroyedCards;
    }
    
    /**
     * Getter for armor
     * @return Card armor
     */
    public Card getArmor() {
        return armor;
    }

    /**
     * Setter for armor
     * @param armor armor of the player
     */
    public void setArmor(Card armor) {
        this.armor = armor;
    } 

    /**
     * Getter for injuredCharacters
     * @return Card[] injuredCharacters
     */
    public Card[] getInjuredCharacters() {
        return injuredCharacters;
    }    
    
    /**
     * Setter for injuredCharacters
     * @param injuredCharacters injured characters of the player
     */
    public void setInjuredCharacters(Card[] injuredCharacters) {
        this.injuredCharacters = injuredCharacters;
    }

    /**
     * Method to draw a card from the deck
     * @return Card card
     */
    public Card drawCard() {
        Card card = deck[0];
        deck[0] = null;
        return card;
    }
    
    /**
     * Method to add a card to the hand
     * @param card card to be added to the hand
     */
    public void addCardToHand(Card card) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                hand[i] = card;
                break;
            }
        }

    }
    
    /**
     * Method to add a card to the discard
     * @param card card to be added to the discard
     */
    public void addCardToDiscard(Card card) {
        for (int i = 0; i < discard.length; i++) {
            if (discard[i] == null) {
                discard[i] = card;
                break;
            }
        }
    }
    
    /**
     * Method to add a card to the destroyed cards
     * @param card card to be added to the destroyed cards
     */
    public void addCardToDestroyedCards(Card card) {
        for (int i = 0; i < destroyedCards.length; i++) {
            if (destroyedCards[i] == null) {
                destroyedCards[i] = card;
                break;
            }
        }

    }

    /**
     * Method to add a card to the injured characters
     * @param card card to be added to the injured characters
     */
    public void addCardToInjuredCharacters(Card card) {
        for (int i = 0; i < injuredCharacters.length; i++) {
            if (injuredCharacters[i] == null) {
                injuredCharacters[i] = card;
                break;
            }
        }
    }

    /**
     * Method to remove a card from the hand
     * @param card card to be removed from the hand
     */
    public void removeCardFromHand(Card card) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == card) {
                hand[i] = null;
                break;
            }
        }
    }

    /**
     * Method to remove a card from the discard
     * @param card card to be removed from the discard
     */
    public void removeCardFromDiscard(Card card) {
        for (int i = 0; i < discard.length; i++) {
            if (discard[i] == card) {
                discard[i] = null;
                break;
            }
        }

    }

    /**
     * Method to remove a card from the destroyed cards
     * @param card card to be removed from the destroyed cards
     */
    public void removeCardFromDestroyedCards(Card card) {
        for (int i = 0; i < destroyedCards.length; i++) {
            if (destroyedCards[i] == card) {
                destroyedCards[i] = null;
                break;
            }
        }

    }

    /**
     * Method to remove a card from the injured characters
     * @param card card to be removed from the injured characters
     */
    public void removeCardFromInjuredCharacters(Card card) {
        for (int i = 0; i < injuredCharacters.length; i++) {
            if (injuredCharacters[i] == card) {
                injuredCharacters[i] = null;
                break;
            }
        }
    }

    /**
     * Method to remove a card from the deck
     * @param card card to be removed from the deck
     */
    public void removeCardFromDeck(Card card) {
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] == card) {
                deck[i] = null;
                break;
            }
        }
    }

    /**
     * Method to add a card to the deck
     * @param card card to be added to the deck
     */
    public void addCardToDeck(Card card) {
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] == null) {
                deck[i] = card;
                break;
            }
        }
    }

    

}
