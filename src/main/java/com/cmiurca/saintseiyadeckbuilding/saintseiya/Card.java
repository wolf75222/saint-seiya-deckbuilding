package com.cmiurca.saintseiyadeckbuilding.saintseiya;

/**
 * Card class, where the cards are created
 * 
 * @author Sirwolf
 * @version 1.0
 * @since 2023-02-04
 */
public class Card {

    /**
     * The name of the card.
     */
    private String name;

    /**
     * The category of the card.
     */
    private String category;

    /**
     * The acquisition cost in strength required to acquire the card.
     */
    private int acquisitionCostInStrength;

    /**
     * The acquisition cost in cosmos required to acquire the card.
     */
    private int acquisitionCostInCosmos;

    /**
     * The rank of the card.
     */
    private String rank;

    /**
     * The id of the card.
     */
    private int id;

    /**
     * The flame of the clock value of the card.
     */
    private int flameOfTheClock;

    /**
     * The point of victory value of the card.
     */
    private int pointOfVictory;

    /**
     * The effect of the card.
     */
    private Effect effect;

    /**
     * The strength value of the card.
     */
    private int strength;

    /**
     * The cosmos value of the card.
     */
    private int cosmos;

    /**
     * The care value of the card.
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
     * @param name The name of the card.
     * @param category The category of the card.
     * @param acquisitionCostInStrength The acquisition cost in strength required to acquire the card.
     * @param acquisitionCostInCosmos The acquisition cost in cosmos required to acquire the card.
     * @param rank The rank of the card.
     * @param id The id of the card.
     * @param flameOfTheClock The flame of the clock value of the card.
     * @param pointOfVictory The point of victory value of the card.
     * @param effect The effect of the card.
     * @param strength The strength value of the card.
     * @param cosmos The cosmos value of the card.
     * @param care The care value of the card.
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
     * @param name The name of the card.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for category
     * @param category The category of the card.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Setter for acquisitionCostInStrength
     * @param acquisitionCostInStrength The acquisition cost in strength required to acquire the card.
     */
    public void setAcquisitionCostInStrength(int acquisitionCostInStrength) {
        this.acquisitionCostInStrength = acquisitionCostInStrength;
    }

    /**
     * Setter for acquisitionCostInCosmos
     * @param acquisitionCostInCosmos The acquisition cost in cosmos required to acquire the card.
     */
    public void setAcquisitionCostInCosmos(int acquisitionCostInCosmos) {
        this.acquisitionCostInCosmos = acquisitionCostInCosmos;
    }

    /**
     * Setter for rank
     * @param rank The rank of the card.
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Setter for id
     * @param id The id of the card.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for flameOfTheClock
     * @param flameOfTheClock The flame of the clock value of the card.
     */
    public void setFlameOfTheClock(int flameOfTheClock) {
        this.flameOfTheClock = flameOfTheClock;
    }

    /**
     * Setter for pointOfVictory
     * @param pointOfVictory The point of victory value of the card.
     */
    public void setPointOfVictory(int pointOfVictory) {
        this.pointOfVictory = pointOfVictory;
    }

    /**
     * Setter for effect
     * @param effect The effect of the card.
     */
    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    /**
     * Setter for strength
     * @param strength The strength value of the card.
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Setter for cosmos
     * @param cosmos The cosmos value of the card.
     */
    public void setCosmos(int cosmos) {
        this.cosmos = cosmos;
    }

    /**
     * Setter for care
     * @param care The care value of the card.
     */
    public void setCare(int care) {
        this.care = care;
    }

    /**
     * Method to display the card
     * @return String
     */
    @Override
    public String toString() {
        return "Card{" + "name=" + name + ", category=" + category + ", acquisitionCostInStrength=" + acquisitionCostInStrength + ", acquisitionCostInCosmos=" + acquisitionCostInCosmos + ", rank=" + rank + ", id=" + id + ", flameOfTheClock=" + flameOfTheClock + ", pointOfVictory=" + pointOfVictory + ", effect=" + effect + ", strength=" + strength + ", cosmos=" + cosmos + ", care=" + care + '}';
    }



}
