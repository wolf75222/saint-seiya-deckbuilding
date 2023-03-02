package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    String name = "Sirwolf";
    Hero hero = Hero.SEIYA;

    Player player = new Player(name, hero);

    @Test
    void getName() {
        assertEquals(name, player.getName());
    }

    @Test
    void setName() {
        String newName = "Sirwolf2";
        player.setName(newName);
        assertEquals(newName, player.getName());
    }

    @Test
    void getHero() {
        assertEquals(hero, player.getHero());
    }

    @Test
    void setHero() {
        Hero newHero = Hero.HYOGA;
        player.setHero(newHero);
        assertEquals(newHero, player.getHero());
    }


    @Test
    void setDeck() {
        Card [] deck = new Card[90];
        for (int i = 0; i < 90; i++) {
            deck[i] = new Card(6);
        }
        player.setDeck(deck);
        assertEquals(deck, player.getDeck());

    }


    @Test
    void getDeck() {
        Card [] deck = new Card[90];
        for (int i = 0; i < 90; i++) {
            deck[i] = new Card(6);
        }
        player.setDeck(deck);
        assertEquals(deck, player.getDeck());
    }


    @Test
    void getHand() {
        Card [] hand = new Card[6];
        for (int i = 0; i < 6; i++) {
            hand[i] = new Card(6);
        }
        player.setHand(hand);
        assertEquals(hand, player.getHand());
    }

    @Test
    void setHand() {
        Card [] hand = new Card[6];
        for (int i = 0; i < 6; i++) {
            hand[i] = new Card(6);
        }
        player.setHand(hand);
        assertEquals(hand, player.getHand());
    }

    @Test
    void getDiscard() {
        Card [] discard = new Card[90];
        for (int i = 0; i < 90; i++) {
            discard[i] = new Card(6);
        }
        player.setDiscard(discard);
        assertEquals(discard, player.getDiscard());
    }

    @Test
    void setDiscard() {
        Card [] discard = new Card[90];
        for (int i = 0; i < 90; i++) {
            discard[i] = new Card(6);
        }
        player.setDiscard(discard);
        assertEquals(discard, player.getDiscard());
    }

    @Test
    void getDestroyedCards() {
        Card [] destroyedCards = new Card[90];
        for (int i = 0; i < 90; i++) {
            destroyedCards[i] = new Card(6);
        }
        player.setDestroyedCards(destroyedCards);
        assertEquals(destroyedCards, player.getDestroyedCards());
    }

    @Test
    void setDestroyedCards() {
        Card [] destroyedCards = new Card[90];
        for (int i = 0; i < 90; i++) {
            destroyedCards[i] = new Card(6);
        }
        player.setDestroyedCards(destroyedCards);
        assertEquals(destroyedCards, player.getDestroyedCards());

    }

    @Test
    void getArmor() {
        Card armor = new Card(player.getHero().getArmorId());
        player.setArmor(armor);
        assertEquals(armor, player.getArmor());
    }

    @Test
    void setArmor() {
        Card armor = new Card(player.getHero().getArmorId());
        player.setArmor(armor);
        assertEquals(armor, player.getArmor());
    }

    @Test
    void getInjuredCharacters() {
        Card [] injuredCharacters = new Card[90];
        for (int i = 0; i < 90; i++) {
            injuredCharacters[i] = new Card(6);
        }
        player.setInjuredCharacters(injuredCharacters);
        assertEquals(injuredCharacters, player.getInjuredCharacters());
    }

    @Test
    void setInjuredCharacters() {
        Card [] injuredCharacters = new Card[90];
        for (int i = 0; i < 90; i++) {
            injuredCharacters[i] = new Card(6);
        }
        player.setInjuredCharacters(injuredCharacters);
        assertEquals(injuredCharacters, player.getInjuredCharacters());
    }

    @Test
    void drawCard() {}

    @Test
    void addCardToHand() {
    }

    @Test
    void testAddCardToHand() {
    }

    @Test
    void addCardToDiscard() {
    }

    @Test
    void testAddCardToDiscard() {
    }

    @Test
    void addCardToDestroyedCards() {
    }

    @Test
    void testAddCardToDestroyedCards() {
    }

    @Test
    void addCardToInjuredCharacters() {
    }

    @Test
    void testAddCardToInjuredCharacters() {
    }

    @Test
    void removeCardFromHand() {
    }

    @Test
    void testRemoveCardFromHand() {
    }

    @Test
    void removeCardFromDiscard() {
    }

    @Test
    void testRemoveCardFromDiscard() {
    }

    @Test
    void removeCardFromDestroyedCards() {
    }

    @Test
    void testRemoveCardFromDestroyedCards() {
    }

    @Test
    void removeCardFromInjuredCharacters() {
    }

    @Test
    void testRemoveCardFromInjuredCharacters() {
    }

    @Test
    void removeCardFromDeck() {
    }

    @Test
    void testRemoveCardFromDeck() {
    }

    @Test
    void addCardToDeck() {
    }

    @Test
    void testAddCardToDeck() {
    }

    @Test
    void occurenceInHand() {
    }

    @Test
    void testOccurenceInHand() {
    }

    @Test
    void occurenceInDiscard() {
    }

    @Test
    void testOccurenceInDiscard() {
    }

    @Test
    void occurenceInDestroyedCards() {
    }

    @Test
    void testOccurenceInDestroyedCards() {
    }

    @Test
    void occurenceInInjuredCharacters() {
    }

    @Test
    void testOccurenceInInjuredCharacters() {
    }

    @Test
    void occurenceInDeck() {
    }

    @Test
    void testOccurenceInDeck() {
    }

    @Test
    void positionsInHand() {
    }

    @Test
    void testPositionsInHand() {
    }

    @Test
    void positionsInDiscard() {
    }

    @Test
    void testPositionsInDiscard() {
    }

    @Test
    void positionsInDestroyedCards() {
    }

    @Test
    void testPositionsInDestroyedCards() {
    }

    @Test
    void positionsInInjuredCharacters() {
    }

    @Test
    void testPositionsInInjuredCharacters() {
    }

    @Test
    void positionsInDeck() {
    }

    @Test
    void testPositionsInDeck() {
    }

    @Test
    void moveCardFromHandToDiscard() {
    }

    @Test
    void moveCardFromDiscardToDestroyedCards() {
    }

    @Test
    void testMoveCardFromHandToDiscard() {
    }

    @Test
    void moveCardFromHandToInjuredCharacters() {
    }

    @Test
    void testMoveCardFromHandToInjuredCharacters() {
    }

    @Test
    void moveCardFromHandToDestroyedCards() {
    }

    @Test
    void testMoveCardFromHandToDestroyedCards() {
    }

    @Test
    void moveCardFromDiscardToHand() {
    }

    @Test
    void testMoveCardFromDiscardToHand() {
    }

    @Test
    void moveCardFromHandToDeck() {
    }

    @Test
    void testMoveCardFromHandToDeck() {
    }

    @Test
    void moveCardFromDeckToHand() {
    }

    @Test
    void testMoveCardFromDeckToHand() {
    }

    @Test
    void moveCardFromDeckToDiscard() {
    }

    @Test
    void testMoveCardFromDeckToDiscard() {
    }

    @Test
    void moveCardFromDiscardToDeck() {
    }

    @Test
    void testMoveCardFromDiscardToDeck() {
    }

    @Test
    void moveCardFromDeckToInjuredCharacters() {
    }

    @Test
    void testMoveCardFromDeckToInjuredCharacters() {
    }

    @Test
    void moveCardFromInjuredCharactersToDeck() {
    }

    @Test
    void testMoveCardFromInjuredCharactersToDeck() {
    }

    @Test
    void moveCardFromInjuredCharactersToDiscard() {
    }

    @Test
    void testMoveCardFromInjuredCharactersToDiscard() {
    }

    @Test
    void moveCardFromDiscardToInjuredCharacters() {
    }

    @Test
    void testMoveCardFromDiscardToInjuredCharacters() {
    }

    @Test
    void acquireByStrength() {
    }

    @Test
    void hasCardInHand() {
    }

    @Test
    void hasCardInHandById() {
    }

    @Test
    void testGetName() {
    }

    @Test
    void testSetName() {
    }

    @Test
    void testGetHero() {
    }

    @Test
    void testSetHero() {
    }

    @Test
    void testGetDeck() {
    }

    @Test
    void testSetDeck() {
    }

    @Test
    void testGetHand() {
    }

    @Test
    void testSetHand() {
    }

    @Test
    void testGetDiscard() {
    }

    @Test
    void testSetDiscard() {
    }

    @Test
    void testGetDestroyedCards() {
    }

    @Test
    void testSetDestroyedCards() {
    }

    @Test
    void testGetArmor() {
    }

    @Test
    void testSetArmor() {
    }

    @Test
    void testGetInjuredCharacters() {
    }

    @Test
    void testSetInjuredCharacters() {
    }

    @Test
    void testDrawCard() {
    }

    @Test
    void testAddCardToHand1() {
    }

    @Test
    void testAddCardToHand2() {
    }

    @Test
    void testAddCardToDiscard1() {
    }

    @Test
    void testAddCardToDiscard2() {
    }

    @Test
    void testAddCardToDestroyedCards1() {
    }

    @Test
    void testAddCardToDestroyedCards2() {
    }

    @Test
    void testAddCardToInjuredCharacters1() {
    }

    @Test
    void testAddCardToInjuredCharacters2() {
    }

    @Test
    void testRemoveCardFromHand1() {
    }

    @Test
    void testRemoveCardFromHand2() {
    }

    @Test
    void testRemoveCardFromDiscard1() {
    }

    @Test
    void testRemoveCardFromDiscard2() {
    }

    @Test
    void testRemoveCardFromDestroyedCards1() {
    }

    @Test
    void testRemoveCardFromDestroyedCards2() {
    }

    @Test
    void testRemoveCardFromInjuredCharacters1() {
    }

    @Test
    void testRemoveCardFromInjuredCharacters2() {
    }

    @Test
    void testRemoveCardFromDeck1() {
    }

    @Test
    void testRemoveCardFromDeck2() {
    }

    @Test
    void testAddCardToDeck1() {
    }

    @Test
    void testAddCardToDeck2() {
    }

    @Test
    void testOccurenceInHand1() {
    }

    @Test
    void testOccurenceInHand2() {
    }

    @Test
    void testOccurenceInDiscard1() {
    }

    @Test
    void testOccurenceInDiscard2() {
    }

    @Test
    void testOccurenceInDestroyedCards1() {
    }

    @Test
    void testOccurenceInDestroyedCards2() {
    }

    @Test
    void testOccurenceInInjuredCharacters1() {
    }

    @Test
    void testOccurenceInInjuredCharacters2() {
    }

    @Test
    void testOccurenceInDeck1() {
    }

    @Test
    void testOccurenceInDeck2() {
    }

    @Test
    void testPositionsInHand1() {
    }

    @Test
    void testPositionsInHand2() {
    }

    @Test
    void testPositionsInDiscard1() {
    }

    @Test
    void testPositionsInDiscard2() {
    }

    @Test
    void testPositionsInDestroyedCards1() {
    }

    @Test
    void testPositionsInDestroyedCards2() {
    }

    @Test
    void testPositionsInInjuredCharacters1() {
    }

    @Test
    void testPositionsInInjuredCharacters2() {
    }

    @Test
    void testPositionsInDeck1() {
    }

    @Test
    void testPositionsInDeck2() {
    }

    @Test
    void testMoveCardFromHandToDiscard1() {
    }

    @Test
    void testMoveCardFromDiscardToDestroyedCards() {
    }

    @Test
    void testMoveCardFromHandToDiscard2() {
    }

    @Test
    void testMoveCardFromHandToInjuredCharacters1() {
    }

    @Test
    void testMoveCardFromHandToInjuredCharacters2() {
    }

    @Test
    void testMoveCardFromHandToDestroyedCards1() {
    }

    @Test
    void testMoveCardFromHandToDestroyedCards2() {
    }

    @Test
    void testMoveCardFromDiscardToHand1() {
    }

    @Test
    void testMoveCardFromDiscardToHand2() {
    }

    @Test
    void testMoveCardFromHandToDeck1() {
    }

    @Test
    void testMoveCardFromHandToDeck2() {
    }

    @Test
    void testMoveCardFromDeckToHand1() {
    }

    @Test
    void testMoveCardFromDeckToHand2() {
    }

    @Test
    void testMoveCardFromDeckToDiscard1() {
    }

    @Test
    void testMoveCardFromDeckToDiscard2() {
    }

    @Test
    void testMoveCardFromDiscardToDeck1() {
    }

    @Test
    void testMoveCardFromDiscardToDeck2() {
    }

    @Test
    void testMoveCardFromDeckToInjuredCharacters1() {
    }

    @Test
    void testMoveCardFromDeckToInjuredCharacters2() {
    }

    @Test
    void testMoveCardFromInjuredCharactersToDeck1() {
    }

    @Test
    void testMoveCardFromInjuredCharactersToDeck2() {
    }

    @Test
    void testMoveCardFromInjuredCharactersToDiscard1() {
    }

    @Test
    void testMoveCardFromInjuredCharactersToDiscard2() {
    }

    @Test
    void testMoveCardFromDiscardToInjuredCharacters1() {
    }

    @Test
    void testMoveCardFromDiscardToInjuredCharacters2() {
    }

    @Test
    void showHand() {
    }

    @Test
    void showDeck() {
    }

    @Test
    void testToString() {
    }

    @Test
    void showDiscard() {
    }

    @Test
    void showInjuredCharacters() {
    }
}