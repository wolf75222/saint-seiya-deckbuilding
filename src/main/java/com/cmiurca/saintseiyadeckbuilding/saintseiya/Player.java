package com.cmiurca.saintseiyadeckbuilding.saintseiya;


import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;


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
    private ArrayList<Card> deck;

    /**
     * The hand of the player
     */
    private ArrayList<Card> hand;

    /**
     * The discard of the player
     */
    private ArrayList<Card> discard;

    /**
     * The destroyed Cards of the player
     */
    private ArrayList<Card> destroyedCards;

    /**
     * The armor of the player
     */
    private Card armor;

    /**
     * The injured characters of the player
     */
    private ArrayList<Card> injuredCharacters;


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
    public Player(String name, Hero hero, ArrayList<Card> deck, ArrayList<Card> hand, ArrayList<Card> discard, ArrayList<Card> destroyedCards, Card armor, ArrayList<Card> injuredCharacters) {
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
     * Constructor of the player with only name and hero
     * @param name name of the player
     * @param hero hero of the player
     */
    public Player(String name, Hero hero) {
        this.name = name;
        this.hero = hero;
        this.deck = new ArrayList<Card>();
        this.hand = new ArrayList<Card>();
        this.discard = new ArrayList<Card>();
        this.destroyedCards = new ArrayList<Card>();
        this.armor = null;
        this.injuredCharacters = new ArrayList<Card>();
    }


    /**
     * Constructor of the player with no parameters
     */
    public Player() {
        this.name = "Player";
        this.hero = Hero.SEIYA;
        this.deck = new ArrayList<Card>(90);
        this.hand = new ArrayList<Card>(10);
        this.discard = new ArrayList<Card>(90);
        this.destroyedCards = new ArrayList<Card>(90);
        this.armor = null;
        this.injuredCharacters = new ArrayList<Card>(10);
    }


    /**
     * Method that return all the things the palyer can do
     * @return String with all the things the player can do
     */
    public String help(PlayMat playMat) {
        String effect = "";
        for (Card card : hand) {
            if (card != null) {
                effect += card.getEffect().getDescription() + "\n";
            }
        }
        String aquire = "";
        for (int i = 0; i < playMat.getCardLocation().length; i++) {
            if (playMat.getCardInLocationFromIndex(i) != null) {
                if (canAcquireByStrength(playMat, i)) {
                    aquire += "Vous pouvez acquérir la carte " + playMat.getCardInLocationFromIndex(i).getName() + " par force\n";
                }
                if (canAcquireByCosmos(playMat, i)) {
                    aquire += "Vous pouvez acquérir la carte " + playMat.getCardInLocationFromIndex(i).getName() + " par cosmos\n";
                }
            }
        }
        String heal = "";
        for (Card card : injuredCharacters) {
            if (card != null) {
                heal += "Vous pouvez soigner la carte " + card.getName() + "\n";
            }
        }
        String help = "Voici les actions que vous pouvez faire : \n" + effect + aquire + heal;
        return help;
    }



    /**
     * Method to verify if a card can be aquired by strength with all the cards in the hand
     * @param index index of the card to be acquired
     * @return true if the card can be acquired by strength, false otherwise
     */
    public boolean canAcquireByStrength(PlayMat playMat, int index) {
        int acquisitionCostInStrength = playMat.getCardInLocationFromIndex(index).getAcquisitionCostInStrength();
        int strength = 0;
        for (Card card : hand) {
            if (card != null) {
                strength += card.getStrength();
            }
        }
        if (strength < acquisitionCostInStrength) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method to verify if a card can be aquired by cosmos with all the cards in the hand
     * @param index index of the card to be acquired
     * @return true if the card can be acquired by cosmos, false otherwise
     */
    public boolean canAcquireByCosmos(PlayMat playMat, int index) {
        int acquisitionCostInCosmos = playMat.getCardInLocationFromIndex(index).getAcquisitionCostInCosmos();
        int cosmos = 0;
        for (Card card : hand) {
            if (card != null) {
                cosmos += card.getCosmos();
            }
        }
        if (cosmos < acquisitionCostInCosmos) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * Method to acquire by Strength a card from the PlayMat
     * @param index index of the card to be acquired
     */
    public void acquireByStrength(PlayMat playMat, int index, ArrayList<Card> cards) {
        int acquisitionCostInStrength = playMat.getCardInLocationFromIndex(index).getAcquisitionCostInStrength();
        try {
            int strength = 0;
            ArrayList<Card> cardsToRemove = new ArrayList<>(); // nouvelle liste
            for (Card card : cards) {
                if (!hasCardInHand(card)) {
                    throw new IllegalArgumentException("Vous n'avez pas la carte " + card.getName() + " dans votre main");
                }
                strength += card.getStrength();
                cardsToRemove.add(card); // ajouter la carte à la nouvelle liste
            }
            if (strength < acquisitionCostInStrength) {
                throw new IllegalArgumentException("Vous n'avez pas assez de force pour acquérir cette carte");
            } else {
                addCardToDiscard(playMat.getCardInLocationFromIndex(index));
                playMat.removeCardFromLocationFromIndex(index);
                for (Card card : cardsToRemove) {
                    moveCardFromHandToDiscard(card);
                }
                /**
                 if (playMat.getCardInLocationFromIndex(index).getEffect().getType() == EffectType.DEFEATED) {
                 playMat.getCardInLocationFromIndex(index).applyEffect(...);
                 }
                 */
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }



    /**
     * Method to acquire by Cosmos a card from the PlayMat
     * @param index index of the card to be acquired
     */
    public void acquireByCosmos(PlayMat playMat, int index, ArrayList<Card> cards) {
        int acquisitionCostInCosmos = playMat.getCardInLocationFromIndex(index).getAcquisitionCostInCosmos();
        try {
            int cosmos = 0;
            ArrayList<Card> cardsToRemove = new ArrayList<>();
            for (Card card : cards) {
                if (!hasCardInHand(card)) {
                    throw new IllegalArgumentException("Vous n'avez pas la carte " + card.getName() + " dans votre main");
                }
                cosmos += card.getCosmos();
                cardsToRemove.add(card);
            }
            if (cosmos < acquisitionCostInCosmos) {
                throw new IllegalArgumentException("Vous n'avez pas assez de cosmos pour acquérir cette carte");
            } else {
                addCardToHand(playMat.getCardInLocationFromIndex(index));
                playMat.removeCardFromLocationFromIndex(index);
                for (Card card : cardsToRemove) {
                    moveCardFromHandToDiscard(card);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }


    /**
     * Method to heal a card from the Injured Characters
     * @param index index of the card to be healed
     */
    public void healCardFromInjuredCharacters(int index) {
        try {
            if (injuredCharacters.get(index) == null) {
                throw new IllegalArgumentException("La carte n'est pas dans les characters blessés");
            } else {
                injuredCharacters.get(index).addCare(1);
                moveCardFromInjuredCharactersToDiscard(injuredCharacters.get(index));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    /**
     * Method to apply the effect of a card
     * @param card card to be applied
     */
    public void applyEffect(Card card, ArrayList<Card> cards, PlayMat playMat, ArrayList<Player> players) {
        card.getEffect().applyEffect( cards, players, playMat);
   }


    /**
     * Method to check if the player has a card in the hand
     * @param card card to be checked
     */
    public boolean hasCardInHand(Card card) {
        return hand.contains(card);
    }

    /**
     * Method to check if the player has a card in the hand by id
     * @param id of card to be checked
     */
    public boolean hasCardInHandById(int id) {
        for (Card card : hand) {
            if (card.getId() == id) {
                return true;
            }
        }
        return false;
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
     * @return ArrayList<Card> deck
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }


    /**
     * Setter for deck
     * @param deck deck of the player
     */
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    /**
     * Getter for hand
     * @return ArrayList<Card> hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }


    /**
     * Setter for hand
     * @param hand hand of the player
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }


    /**
     * Getter for discard
     * @return ArrayList<Card> discard
     */
    public ArrayList<Card> getDiscard() {
        return discard;
    }

    /**
     * Setter for discard
     * @param discard discard of the player
     */
    public void setDiscard(ArrayList<Card> discard) {
        this.discard = discard;
    }

    /**
     * Getter for destroyedCards
     * @return ArrayList<Card> destroyedCards
     */
    public ArrayList<Card> getDestroyedCards() {
        return destroyedCards;
    }

    /**
     * Setter for destroyedCards
     * @param destroyedCards destroyed cards of the player
     */
    public void setDestroyedCards(ArrayList<Card> destroyedCards) {
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
        if (armor.getId() == this.hero.getArmorId())
            this.armor = armor;
    }

    /**
     * Getter for injuredCharacters
     * @return ArrayList<Card> injuredCharacters
     */
    public ArrayList<Card> getInjuredCharacters() {
        return injuredCharacters;
    }

    /**
     * Setter for injuredCharacters
     * @param injuredCharacters injured characters of the player
     */
    public void setInjuredCharacters(ArrayList<Card> injuredCharacters) {
        this.injuredCharacters = injuredCharacters;
    }

    /**
     * Method to draw a card from the deck
     * @return Card card
     */
    public Card drawCard() {
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }


    /**
     * Method to add a card to the hand
     * @param card card to be added to the hand
     */
    public void addCardToHand(Card card) {
        // Check if Hand is full
        try {
            if (hand.size() == 10) {
                throw new IllegalArgumentException("La main est pleine");
            } else {
                hand.add(card);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }


    /**
     * Method to add card to the hand
     * @param id of the card to be added to the hand
     */
    public void addCardToHand(int id)   {
        Card card = new Card(id);
        addCardToHand(card);
    }



    /**
     * Method to add a card to the discard
     * @param card card to be added to the discard
     */
    public void addCardToDiscard(Card card) {
        try {
            if (discard.size() == 90) {
                throw new IllegalArgumentException("La défausse est pleine");
            } else {
                discard.add(card);
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }


    /**
     * Method to add card to the discard
     * @param id of the card to be added to the discard
     */
    public void addCardToDiscard(int id)   {
        Card card = new Card(id);
        addCardToDiscard(card);
    }

    /**
     * Method to add a card to the destroyed cards
     * @param card card to be added to the destroyed cards
     */
    public void addCardToDestroyedCards(Card card) {
        try {
            if (destroyedCards.size() >= 90) {
                throw new IllegalArgumentException("La main de personnages détruits est pleine");
            } else {
                destroyedCards.add(card);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }




    /**
     * Method to add card to the destroyed cards
     * @param id of the card to be added to the destroyed cards
     */
    public void addCardToDestroyedCards(int id)  {
        Card card = new Card(id);
        addCardToDestroyedCards(card);
    }

    /**
     * Method to add a card to the injured characters
     * @param card card to be added to the injured characters
     */
    public void addCardToInjuredCharacters(Card card) {
        try {
            if (injuredCharacters.size() >= 90) {
                throw new IllegalArgumentException("La liste des personnages blessés est pleine");
            } else {
                injuredCharacters.add(card);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }



    /**
     * Method to add card to the injured characters
     * @param id of the card to be added to the injured characters
     */
    public void addCardToInjuredCharacters(int id)  {
        Card card = new Card(id);
        addCardToInjuredCharacters(card);
    }

    /**
     * Method to remove a card from the hand
     * @param card card to be removed from the hand
     */
    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }


    /**
     * Method to remove a card from the hand
     * @param id of the card to be removed from the hand
     */
    public void removeCardFromHand(int id) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getId() == id) {
                hand.remove(i);
                break;
            }
        }
    }


    /**
     * Method to remove a card from the discard
     * @param card card to be removed from the discard
     */
    public void removeCardFromDiscard(Card card) {
        discard.remove(card);
    }


    /**
     * Method to remove a card from the discard
     * @param id id of the card to be removed from the discard
     */
    public void removeCardFromDiscard(int id) {
        for (int i = 0; i < discard.size(); i++) {
            if (discard.get(i).getId() == id) {
                discard.remove(i);
                break;
            }
        }
    }


    /**
     * Method to remove a card from the destroyed cards
     * @param card card to be removed from the destroyed cards
     */
    public void removeCardFromDestroyedCards(Card card) {
        destroyedCards.remove(card);
    }


    /**
     * Method to remove a card from the destroyed cards
     * @param id of the card to be removed from the destroyed cards
     */
    public void removeCardFromDestroyedCards(int id) {
        for (int i = 0; i < destroyedCards.size(); i++) {
            if (destroyedCards.get(i).getId() == id) {
                destroyedCards.remove(i);
                break;
            }
        }
    }

    /**
     * Method to remove a card from the injured characters
     * @param card card to be removed from the injured characters
     */
    public void removeCardFromInjuredCharacters(Card card) {
        injuredCharacters.remove(card);
    }


    /**
     * Method to remove a card from the injured characters
     * @param id of the card to be removed from the injured characters
     */
    public void removeCardFromInjuredCharacters(int id) {
        injuredCharacters.removeIf(c -> c.getId() == id);
    }


    /**
     * Method to remove a card from the deck
     * @param card card to be removed from the deck
     */
    public void removeCardFromDeck(Card card) {
        deck.remove(card);
    }


    /**
     * Method to remove a card from the deck
     * @param id of the card to be removed from the deck
     */
    public void removeCardFromDeck(int id) {
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).getId() == id) {
                deck.remove(i);
                break;
            }
        }
    }


    /**
     * Method to add a card to the deck
     * @param card card to be added to the deck
     */
    public void addCardToDeck(Card card) {
        try {
            if (deck.size() >= 90) {
                throw new IllegalArgumentException("Le deck est plein");
            } else {
                deck.add(card);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }


    /**
     * Method to add a card to the deck
     * @param id of the card to be added to the deck
     */
    public void addCardToDeck(int id)  {
        Card card = new Card(id);
        addCardToDeck(card);
    }

    /**
     * Method that returns the occurence of a card in the hand
     * @param card card to be searched for
     * @return int occurence
     */
    public int occurenceInHand(Card card) {
        int occurence = 0;
        for (Card c : hand) {
            if (c == card) {
                occurence++;
            }
        }
        return occurence;
    }


    /**
     * Method that returns the occurence of a card in the hand
     * @param id of the card to be searched for
     * @return int occurence
     */
    public int occurenceInHand(int id) {
        int occurence = 0;
        for (Card card : hand) {
            if (card.getId() == id) {
                occurence++;
            }
        }
        return occurence;
    }


    /**
     * Method that returns the occurrence of a card in the discard
     * @param card card to be searched for
     * @return int occurrence
     */
    public int occurenceInDiscard(Card card) {
        int occurrence = 0;
        for (Card c : discard) {
            if (c == card) {
                occurrence++;
            }
        }
        return occurrence;
    }


    /**
     * Method that returns the occurrence of a card in the discard
     * @param id of the card to be searched for
     * @return int occurrence
     */
    public int occurrenceInDiscard(int id) {
        int occurrence = 0;
        for (Card c : discard) {
            if (c.getId() == id) {
                occurrence++;
            }
        }
        return occurrence;
    }

    /**
     * Method that returns the occurrence of a card in the destroyed cards
     * @param card card to be searched for
     * @return int occurrence
     */
    public int occurrenceInDestroyedCards(Card card) {
        int occurrence = 0;
        for (Card c : destroyedCards) {
            if (c == card) {
                occurrence++;
            }
        }
        return occurrence;
    }


    /**
     * Method that returns the occurence of a card in the destroyed cards
     * @param id id of the card to be searched for
     * @return int occurence
     */
    public int occurenceInDestroyedCards(int id) {
        int occurence = 0;
        for (Card card : destroyedCards) {
            if (card.getId() == id) {
                occurence++;
            }
        }
        return occurence;
    }



    /**
     * Method that returns the occurrence of a card in the injured characters
     * @param card card to be searched for
     * @return int occurrence
     */
    public int occurrenceInInjuredCharacters(Card card) {
        int occurrence = 0;
        for (Card c : injuredCharacters) {
            if (c.equals(card)) {
                occurrence++;
            }
        }
        return occurrence;
    }


    /**
     * Method that returns the occurence of a card in the injured characters
     * @param id of the card to be searched for
     * @return int occurence
     */
    public int occurenceInInjuredCharacters(int id) {
        int occurence = 0;
        for (Card c : injuredCharacters) {
            if (c.getId() == id) {
                occurence++;
            }
        }
        return occurence;
    }

    /**
     * Method that returns the occurence of a card in the deck
     * @param card card to be searched for
     * @return int occurence
     */
    public int occurenceInDeck(Card card) {
        int occurence = 0;
        for (Card c : deck) {
            if (c == card) {
                occurence++;
            }
        }
        return occurence;
    }


    /**
     * Method that returns the occurrence of a card in the deck
     * @param id of the card to be searched for
     * @return int occurrence
     */
    public int occurrenceInDeck(int id) {
        int occurrence = 0;
        for (Card c : deck) {
            if (c.getId() == id) {
                occurrence++;
            }
        }
        return occurrence;
    }

    /**
     * Method that returns all the positions of a card in the hand
     * @param card card to be searched for
     * @return ArrayList<Integer> positions
     */
    public ArrayList<Integer> positionsInHand(Card card) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i) == card) {
                positions.add(i);
            }
        }
        return positions;
    }


    /**
     * Method that returns all the positions of a card in the hand
     * @param id id of the card to be searched for
     * @return ArrayList<Integer> positions
     */
    public ArrayList<Integer> positionsInHand(int id) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getId() == id) {
                positions.add(i);
            }
        }
        return positions;
    }



    /**
     * Method that returns all the positions of a card in the discard
     * @param card card to be searched for
     * @return ArrayList<Integer> positions
     */
    public ArrayList<Integer> positionsInDiscard(Card card) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < discard.size(); i++) {
            if (discard.get(i) == card) {
                positions.add(i);
            }
        }
        return positions;
    }




    /**
     * Method that returns all the positions of a card in the destroyed cards
     * @param card card to be searched for
     * @return ArrayList<Integer> positions
     */
    public ArrayList<Integer> positionsInDestroyedCards(Card card) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < destroyedCards.size(); i++) {

        }
        return positions;
    }

    /**
     * Method that returns all the positions of a card in the destroyed cards
     * @param id of the card to be searched for
     * @return ArrayList<Integer> positions
     */
    public ArrayList<Integer> positionsInDestroyedCards(int id) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < destroyedCards.size(); i++) {
            if (destroyedCards.get(i).getId() == id) {
                positions.add(i);
            }
        }
        return positions;
    }




    /**
     * Method that returns all the positions of a card in the injured characters
     * @param card card to be searched for
     * @return ArrayList<Integer> positions
     */
    public ArrayList<Integer> positionsInInjuredCharacters(Card card) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < injuredCharacters.size(); i++) {
            if (injuredCharacters.get(i) == card) {
                positions.add(i);
            }
        }
        return positions;
    }


    /**
     * Method that returns all the positions of a card in the injured characters
     * @param id id of the card to be searched for
     * @return ArrayList<Integer> positions
     */
    public ArrayList<Integer> positionsInInjuredCharacters(int id) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < injuredCharacters.size(); i++) {
            if (injuredCharacters.get(i).getId() == id) {
                positions.add(i);
            }
        }
        return positions;
    }



    /**
     * Method that returns all the positions of a card in the deck
     * @param card card to be searched for
     * @return ArrayList<Integer> positions
     */
    public ArrayList<Integer> positionsInDeck(Card card) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i) == card) {
                positions.add(i);
            }
        }
        return positions;
    }


    /**
     * Method that returns all the positions of a card in the deck
     * @param id id of the card to be searched for
     * @return ArrayList<Integer> positions
     */
    public ArrayList<Integer> positionsInDeck(int id) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).getId() == id) {
                positions.add(i);
            }
        }
        return positions;
    }


    /**
     * Method thar move one card from the hand to the discard and removes it from the hand
     * @param card card to be moved
     */
    public void moveCardFromHandToDiscard(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToDiscard(card);
        removeCardFromHand(card);
    }

    /**
     * Method that move one card from the discard to the destroyed cards and removes it from the discard
     * @param card card to be moved
     */
    public void moveCardFromDiscardToDestroyedCards(Card card) {
        ArrayList<Integer> positions = positionsInDiscard(card);
        addCardToDestroyedCards(card);
        removeCardFromDiscard(card);
    }

    /**
     * Method that move one card from the hand to the discard and removes it from the hand
     * @param id id of the card to be moved
     */
    public void moveCardFromHandToDiscard(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToDiscard(id);
        removeCardFromHand(id);
    }

    /**
     * Method that move one card from the hand to the injured characters and removes it from the hand
     * @param card card to be moved
     */
    public void moveCardFromHandToInjuredCharacters(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToInjuredCharacters(card);
        removeCardFromHand(card);
    }

    /**
     * Method that move one card from the hand to the injured characters and removes it from the hand
     * @param id id of the card to be moved
     */
    public void moveCardFromHandToInjuredCharacters(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToInjuredCharacters(id);
        removeCardFromHand(id);
    }


    /**
     * Method that move one card from the hand to the destroyed cards and removes it from the hand
     * @param card card to be moved
     */
    public void moveCardFromHandToDestroyedCards(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToDestroyedCards(card);
        removeCardFromHand(card);
    }

    /**
     * Method that move one card from the hand to the destroyed cards and removes it from the hand
     * @param id id of the card to be moved
     */
    public void moveCardFromHandToDestroyedCards(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToDestroyedCards(id);
        removeCardFromHand(id);
    }


    /**
     * Method that move one card from the discard to the hand and removes it from the discard
     * @param card card to be moved
     */
    public void moveCardFromDiscardToHand(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToHand(card);
        removeCardFromDiscard(card);
    }

    /**
     * Method that move one card from the discard to the hand and removes it from the discard
     * @param id id of the card to be moved
     */
    public void moveCardFromDiscardToHand(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToHand(id);
        removeCardFromDiscard(id);
    }

    /**
     * Method that move one card from the hand to the deck and removes it from the hand
     * @param card card to be moved
     */
    public void moveCardFromHandToDeck(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToDeck(card);
        removeCardFromHand(card);
    }

    /**
     * Method that move one card from the hand to the deck and removes it from the hand
     * @param id id of the card to be moved
     */
    public void moveCardFromHandToDeck(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToDeck(id);
        removeCardFromHand(id); 
    }

    /**
     * Method that move one card from the deck to the hand and removes it from the deck
     * @param card card to be moved
     */
    public void moveCardFromDeckToHand(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToHand(card);
        removeCardFromDeck(card);
    }

    /**
     * Method that move one card from the deck to the hand and removes it from the deck
     * @param id id of the card to be moved
     */
    public void moveCardFromDeckToHand(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToHand(id);
        removeCardFromDeck(id);
    }

    /**
     * Method that move one card from the deck to the discard and removes it from the deck
     * @param card card to be moved
     */
    public void moveCardFromDeckToDiscard(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToDiscard(card);
        removeCardFromDeck(card);
    }

    /**
     * Method that move one card from the deck to the discard and removes it from the deck
     * @param id id of the card to be moved
     */
    public void moveCardFromDeckToDiscard(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToDiscard(id);
        removeCardFromDeck(id);
    }

    /**
     * Method that move one card from the discard to the deck and removes it from the discard
     * @param card card to be moved
     */
    public void moveCardFromDiscardToDeck(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToDeck(card);
        removeCardFromDiscard(card);
    }

    /**
     * Method that move one card from the discard to the deck and removes it from the discard
     * @param id id of the card to be moved
     */
    public void moveCardFromDiscardToDeck(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToDeck(id);
        removeCardFromDiscard(id);
    }

    /**
     * Method that move one card from the deck to the injured characters and removes it from the deck
     * @param card card to be moved
     */
    public void moveCardFromDeckToInjuredCharacters(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToInjuredCharacters(card);
        removeCardFromDeck(card);
    }

    /**
     * Method that move one card from the deck to the injured characters and removes it from the deck
     * @param id id of the card to be moved
     */
    public void moveCardFromDeckToInjuredCharacters(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToInjuredCharacters(id);
        removeCardFromDeck(id);
    }

    /**
     * Method that move one card from the injured characters to the deck and removes it from the injured characters
     * @param card card to be moved
     */
    public void moveCardFromInjuredCharactersToDeck(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToDeck(card);
        removeCardFromInjuredCharacters(card);
    }

    /**
     * Method that move one card from the injured characters to the deck and removes it from the injured characters
     * @param id id of the card to be moved
     */
    public void moveCardFromInjuredCharactersToDeck(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToDeck(id);
        removeCardFromInjuredCharacters(id);
    }

    /**
     * Method that move one card from the injured characters to the discard and removes it from the injured characters
     * @param card card to be moved
     */
    public void moveCardFromInjuredCharactersToDiscard(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToDiscard(card);
        removeCardFromInjuredCharacters(card);
    }

    /**
     * Method that move one card from the injured characters to the discard and removes it from the injured characters
     * @param id id of the card to be moved
     */
    public void moveCardFromInjuredCharactersToDiscard(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToDiscard(id);
        removeCardFromInjuredCharacters(id);
    }

    /**
     * Method that move one card from the discard to the injured characters and removes it from the discard
     * @param card card to be moved
     */
    public void moveCardFromDiscardToInjuredCharacters(Card card) {
        ArrayList<Integer> positions = positionsInHand(card);
        addCardToInjuredCharacters(card);
        removeCardFromDiscard(card);
    }

    /**
     * Method that move one card from the discard to the injured characters and removes it from the discard
     * @param id id of the card to be moved
     */
    public void moveCardFromDiscardToInjuredCharacters(int id)  {
        ArrayList<Integer> positions = positionsInHand(id);
        addCardToInjuredCharacters(id);
        removeCardFromDiscard(id);
    }

    /**
     * Method to show the cards in the hand
     * @return String with the cards in the hand
     */
    public String showHand() {
        String hand = "";
        for (Card card : this.hand) {
            if (card != null) {
                hand += card.getName() + ", ";
            } else {
                hand += "null, ";
            }
        }
        return hand;
    }


    /**
     * Method to show the cards in the deck
     * @return String with the cards in the deck
     */
    public String showDeck() {
        String deck = "";
        for (Card card : this.deck) {
            if (card != null) {
                deck += card.getName() + ", ";
            } else {
                deck += "null, ";
            }
        }
        return deck;
    }


    /**
     * Method toString to show the player
     * @return String with the player
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hero=" + hero +
                ", deck=" + deck +
                ", hand=" + hand +
                ", discard=" + discard +
                ", destroyedCards=" + destroyedCards +
                ", armor=" + armor +
                ", injuredCharacters=" + injuredCharacters +
                '}';
    }




    /**
     * Method to show the cards in the discard
     * @return String with the cards in the discard
     */
    public String showDiscard() {
        String discard = "";
        for (Card card : this.discard) {
            if (card != null) {
                discard += card.getName() + ", ";
            } else {
                discard += "null, ";
            }
        }
        return discard;
    }


    /**
     * Method to show the cards in the injured characters
     * @return String with the cards in the injured characters
     */
    public String showInjuredCharacters() {
        String injuredCharacters = "";
        for (Card card : this.injuredCharacters) {
            if (card != null) {
                injuredCharacters += card.getName() + ", ";
            } else {
                injuredCharacters += "null, ";
            }
        }
        return injuredCharacters;
    }


}
