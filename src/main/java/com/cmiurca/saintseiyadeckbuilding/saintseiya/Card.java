package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Card class, where the cards are created
 * 
 * @author Sirwolf
 * @version 1.0
 * @since 2023-02-04
 */
public class Card {

    /**
     * The name of the {@link Card}.
     */
    private String name;

    /**
     * The category of the {@link Card}.
     */
    private String category;

    /**
     * The acquisition cost in strength required to acquire the {@link Card}.
     */
    private int acquisitionCostInStrength;

    /**
     * The acquisition cost in cosmos required to acquire the {@link Card}.
     */
    private int acquisitionCostInCosmos;

    /**
     * The rank of the {@link Card}.
     */
    private String rank;

    /**
     * The id of the {@link Card}.
     */
    private int id;

    /**
     * The flame of the clock value of the {@link Card}.
     */
    private int flameOfTheClock;

    /**
     * The point of victory value of the {@link Card}.
     */
    private int pointOfVictory;

    /**
     * The effect of the {@link Card}.
     */
    private Effect effect;

    /**
     * The strength value of the {@link Card}.
     */
    private int strength;

    /**
     * The cosmos value of the {@link Card}.
     */
    private int cosmos;

    /**
     * The care value of the {@link Card}.
     */
    private int care;

    /**
     * Default constructor
     */
    public Card() {}
    
    /**
     * Creates a new Card instance with the specified parameters.
     * 
     * @param card The card to copy.
     */
    public Card(Card card) {
        this.name = card.getName();
        this.category = card.getCategory();
        this.acquisitionCostInStrength = card.getAcquisitionCostInStrength();
        this.acquisitionCostInCosmos = card.getAcquisitionCostInCosmos();
        this.rank = card.getRank();
        this.id = card.getId();
        this.flameOfTheClock = card.getFlameOfTheClock();
        this.pointOfVictory = card.getPointOfVictory();
        this.effect = card.getEffect();
        this.strength = card.getStrength();
        this.cosmos = card.getCosmos();
        this.care = card.getCare();
    }

    /**
     * Creates a new Card instance with the specified parameters.
     * 
     * @param name The name of the {@link Card}.
     * @param category The category of the {@link Card}.
     * @param acquisitionCostInStrength The acquisition cost in strength required to acquire the {@link Card}.
     * @param acquisitionCostInCosmos The acquisition cost in cosmos required to acquire the {@link Card}.
     * @param rank The rank of the {@link Card}.
     * @param id The id of the {@link Card}.
     * @param flameOfTheClock The flame of the clock value of the {@link Card}.
     * @param pointOfVictory The point of victory value of the {@link Card}.
     * @param effect The effect of the {@link Card}.
     * @param strength The strength value of the {@link Card}.
     * @param cosmos The cosmos value of the {@link Card}.
     * @param care The care value of the {@link Card}.
     */
    public Card(String name, String category, int acquisitionCostInStrength, int acquisitionCostInCosmos, String rank, int id, int flameOfTheClock, int pointOfVictory, Effect effect, int strength, int cosmos, int care) {
        this.name = name;
        this.category = category;
        this.acquisitionCostInStrength = acquisitionCostInStrength;
        this.acquisitionCostInCosmos = acquisitionCostInCosmos;
        this.rank = rank;
        this.id = id;
        this.flameOfTheClock = flameOfTheClock;
        this.pointOfVictory = pointOfVictory;
        this.effect = effect;
        this.strength = strength;
        this.cosmos = cosmos;
        this.care = care;
    }

    /**
     * Creates a new Card instance with the specified parameters.
     * 
     * @param id The id of the {@link Card}.
     */
    public Card(int id) {
        this.id = id;
        String effectClassName = "Effect" + String.format("%04d", id);
        try {
            Class<?> effectClass = Class.forName(effectClassName);
            Constructor<?> effectConstructor = effectClass.getConstructor();
            effect = (Effect) effectConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            // Lancez une exception ou affectez une valeur par défaut à l'effet
        }
        // TODO: Get the card from the database.
    }

    /**
     * Getter for name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for category
     * @return String category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Getter for acquisitionCostInStrength
     * @return int acquisitionCostInStrength
     */
    public int getAcquisitionCostInStrength() {
        return acquisitionCostInStrength;
    }

    /**
     * Getter for acquisitionCostInCosmos
     * @return int acquisitionCostInCosmos
     */
    public int getAcquisitionCostInCosmos() {
        return acquisitionCostInCosmos;
    }

    /**
     * Getter for rank
     * @return String rank
     */
    public String getRank() {
        return rank;
    }
    
    /**
     * Getter for id
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for flameOfTheClock
     * @return int flameOfTheClock
     */
    public int getFlameOfTheClock() {
        return flameOfTheClock;
    }

    /**
     * Getter for pointOfVictory
     * @return int pointOfVictory
     */
    public int getPointOfVictory() {
        return pointOfVictory;
    }


    /**
     * Getter for effect
     * @return Effect effect
     */
    public Effect getEffect() {
        return effect;
    }

    /**
     * Getter for strength
     * @return int strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Getter for cosmos
     * @return int cosmos
     */
    public int getCosmos() {
        return cosmos;
    }

    /**
     * Getter for care
     * @return int care
     */
    public int getCare() {
        return care;
    }

    /**
     * Setter for name
     * @param name The name of the {@link Card}.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for category
     * @param category The category of the {@link Card}.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Setter for acquisitionCostInStrength
     * @param acquisitionCostInStrength The acquisition cost in strength required to acquire the {@link Card}.
     */
    public void setAcquisitionCostInStrength(int acquisitionCostInStrength) {
        this.acquisitionCostInStrength = acquisitionCostInStrength;
    }

    /**
     * Setter for acquisitionCostInCosmos
     * @param acquisitionCostInCosmos The acquisition cost in cosmos required to acquire the {@link Card}.
     */
    public void setAcquisitionCostInCosmos(int acquisitionCostInCosmos) {
        this.acquisitionCostInCosmos = acquisitionCostInCosmos;
    }

    /**
     * Setter for rank
     * @param rank The rank of the {@link Card}.
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Setter for id
     * @param id The id of the {@link Card}.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for flameOfTheClock
     * @param flameOfTheClock The flame of the clock value of the {@link Card}.
     */
    public void setFlameOfTheClock(int flameOfTheClock) {
        this.flameOfTheClock = flameOfTheClock;
    }

    /**
     * Setter for pointOfVictory
     * @param pointOfVictory The point of victory value of the {@link Card}.
     */
    public void setPointOfVictory(int pointOfVictory) {
        this.pointOfVictory = pointOfVictory;
    }

    /**
     * Setter for effect
     * @param effect The effect of the {@link Card}.
     */
    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    /**
     * Setter for strength
     * @param strength The strength value of the {@link Card}.
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Setter for cosmos
     * @param cosmos The cosmos value of the {@link Card}.
     */
    public void setCosmos(int cosmos) {
        this.cosmos = cosmos;
    }

    /**
     * Setter for care
     * @param care The care value of the {@link Card}.
     */
    public void setCare(int care) {
        this.care = care;
    }

    /**
     * Method to display the {@link Card}.
     * @return String
     */
    @Override
    public String toString() {
        return "Card{" + "name=" + name + ", category=" + category + ", acquisitionCostInStrength=" + acquisitionCostInStrength + ", acquisitionCostInCosmos=" + acquisitionCostInCosmos + ", rank=" + rank + ", id=" + id + ", flameOfTheClock=" + flameOfTheClock + ", pointOfVictory=" + pointOfVictory + ", effect=" + effect + ", strength=" + strength + ", cosmos=" + cosmos + ", care=" + care + '}';
    }

    /**
     * Method to compare two cards
     * @param obj The card to compare
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.category == null) ? (other.category != null) : !this.category.equals(other.category)) {
            return false;
        }
        if (this.acquisitionCostInStrength != other.acquisitionCostInStrength) {
            return false;
        }
        if (this.acquisitionCostInCosmos != other.acquisitionCostInCosmos) {
            return false;
        }
        if ((this.rank == null) ? (other.rank != null) : !this.rank.equals(other.rank)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.flameOfTheClock != other.flameOfTheClock) {
            return false;
        }
        if (this.pointOfVictory != other.pointOfVictory) {
            return false;
        }
        if (this.effect != other.effect && (this.effect == null || !this.effect.equals(other.effect))) {
            return false;
        }
        if (this.strength != other.strength) {
            return false;
        }
        if (this.cosmos != other.cosmos) {
            return false;
        }
        if (this.care != other.care) {
            return false;
        }
        return true;
    }   

    /**
     * Method to add strength to the {@link Card}.
     * @param strengthToAdd The strength to add
     */
    public void addStrength(int strengthToAdd) {
        this.strength += strengthToAdd;
    }

    /**
     * Method to add cosmos to the {@link Card}.
     * @param cosmosToAdd The cosmos to add
     */
    public void addCosmos(int cosmosToAdd) {
        this.cosmos += cosmosToAdd;
    }

    /**
     * Method to add care to the {@link Card}.
     * @param careToAdd The care to add
     */
    public void addCare(int careToAdd) {
        this.care += careToAdd;
    }

    /**
     * Method to remove strength to the {@link Card}.
     * @param strengthToRemove The strength to remove
     */
    public void removeStrength(int strengthToRemove) {
        this.strength -= strengthToRemove;
    }

    /**
     * Method to remove cosmos to the {@link Card}.
     * @param cosmosToRemove The cosmos to remove
     */
    public void removeCosmos(int cosmosToRemove) {
        this.cosmos -= cosmosToRemove;
    }

    /**
     * Method to remove care to the {@link Card}.
     * @param careToRemove The care to remove
     */
    public void removeCare(int careToRemove) {
        this.care -= careToRemove;
    }

    /**
     * Method to remove acquisitionCostInStrength to the {@link Card}
     * @param acquisitionCostInStrengthToRemove The acquisitionCostInStrength to remove
     */
    public void removeAcquisitionCostInStrength(int acquisitionCostInStrengthToRemove) {
        this.acquisitionCostInStrength -= acquisitionCostInStrengthToRemove;
    }

    /**
     * Method to remove acquisitionCostInCosmos to the {@link Card}
     * @param acquisitionCostInCosmosToRemove The acquisitionCostInCosmos to remove
     */
    public void removeAcquisitionCostInCosmos(int acquisitionCostInCosmosToRemove) {
        this.acquisitionCostInCosmos -= acquisitionCostInCosmosToRemove;
    }

}
