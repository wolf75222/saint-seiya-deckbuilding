package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;


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
     * Constructeur par ID qui crée une carte à partir d'un fichier JSON qui contient les données de la carte.
     *
     * @param id L'identifiant de la carte.
     * @throws IOException Si une erreur se produit lors de la lecture du fichier JSON.
     */
    public Card(int id) throws IOException {
        ClassLoader classLoader = JsonTableau.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("convertie.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode;

        try {
            rootNode = objectMapper.readTree(inputStream);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
            return;
        }

        for (JsonNode node : rootNode) {
            if (node.path("id").asInt() == id) {
                try {
                    if(node.path("id").asText() == ""){
                        this.id = 0;
                    }
                    else{
                        this.id = Integer.parseInt(node.path("id").asText());
                    }
                } catch (NumberFormatException e) {
                    this.id = 0;
                    System.out.println("Erreur lors de la conversion de l'identifiant de la carte : " + e.getMessage());
                }
                try {
                    if(node.path("nom").asText() == ""){
                        this.name = "Inconnu";
                    }
                    else{
                        this.name = node.path("nom").asText();
                    }
                } catch (NumberFormatException e) {
                    this.name = "Inconnu";
                    System.out.println("Erreur lors de la conversion du nom de la carte : " + e.getMessage());
                }
                try {
                    if(node.path("classe").asText() == ""){
                        this.category = "Inconnu";
                    }
                    else{
                        this.category = node.path("classe").asText();
                    }
                } catch (NumberFormatException e) {
                    this.category = "Inconnu";
                    System.out.println("Erreur lors de la conversion de la classe de la carte : " + e.getMessage());
                }
                try {
                    if(node.path("rang").asText() == ""){
                        this.rank = "Inconnu";
                    }
                    else{
                        this.rank = node.path("rang").asText();
                    }
                } catch (NumberFormatException e) {
                    this.rank = "Inconnu";
                    System.out.println("Erreur lors de la conversion du rang de la carte : " + e.getMessage());
                }
                try {
                    if(node.path("cout force").asText() == ""){
                        this.acquisitionCostInStrength = 0;
                    }
                    else{
                        this.acquisitionCostInStrength = Integer.parseInt(node.path("cout force").asText());
                    }
                } catch (NumberFormatException e) {
                    this.acquisitionCostInStrength = 0;
                    System.out.println("Erreur lors de la conversion du coût en force de la carte : " + e.getMessage());
                }
                try {
                    if(node.path("cout cosmos").asText() == ""){
                        this.acquisitionCostInCosmos = 0;
                    }
                    else{
                        this.acquisitionCostInCosmos = Integer.parseInt(node.path("cout cosmos").asText());
                    }
                } catch (NumberFormatException e) {
                    this.acquisitionCostInCosmos = 0;
                    System.out.println("Erreur lors de la conversion du coût en cosmos de la carte : " + e.getMessage());
                }
                try {
                    if(node.path("force").asText() == ""){
                        this.strength = 0;
                    }
                    else{
                        this.strength = Integer.parseInt(node.path("force").asText());
                    }
                } catch (NumberFormatException e) {
                    this.strength = 0;
                    System.out.println("Erreur lors de la conversion de la force de la carte : " + e.getMessage());
                }
                try {
                    if(node.path("vie").asText() == ""){
                        this.care = 0;
                    }
                    else{
                        this.care = Integer.parseInt(node.path("vie").asText());
                    }
                } catch (NumberFormatException e) {
                    this.care = 0;
                    System.out.println("Erreur lors de la conversion de la vie de la carte : " + e.getMessage());
                }
                try {
                    if(node.path("cosmos").asText() == ""){
                        this.cosmos = 0;
                    }
                    else{
                        this.cosmos = Integer.parseInt(node.path("cosmos").asText());
                    }
                } catch (NumberFormatException e) {
                    this.cosmos = 0;
                    System.out.println("Erreur lors de la conversion du cosmos de la carte : " + e.getMessage());
                }
                try {
                    if(node.path("points").asText() == ""){
                        this.pointOfVictory = 0;
                    }
                    else{
                        this.pointOfVictory = Integer.parseInt(node.path("points").asText());
                    }
                } catch (NumberFormatException e) {
                    this.pointOfVictory = 0;
                    System.out.println("Erreur lors de la conversion des points de victoire de la carte : " + e.getMessage());
                }


                /**
                {
                    "id": "1",
                        "nom": "Seiya de P\u00e9gase",
                        "classe": "H\u00e9ros",
                        "rang": "Tr\u00e8s Commun",
                        "cout force": "",
                        "cout cosmos": "",
                        "force": "1",
                        "vie": "1",
                        "cosmos": "",
                        "points": "",
                        "objet": "",
                        "effets": "Renforcer Seiya avec l'Armure de P\u00e9gase."
                }
                */


                String effectClassName = "com.cmiurca.saintseiyadeckbuilding.saintseiya.effects.Effect" + String.format("%04d", id);
                try {
                    Class<?> effectClass = Class.forName(effectClassName);
                    Constructor<?> effectConstructor = effectClass.getConstructor();
                    this.effect = (Effect) ((Constructor<?>) effectConstructor).newInstance();
                } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                         InvocationTargetException e) {
                    System.out.println("Erreur lors de la création de l'effet de la carte : " + e.getMessage());
                }









                //System.out.println(node.path("nom").asText());

            }
        }


    }





    /**
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("./saint_seiya_cartes.json"));
            JSONArray cards = (JSONArray) obj;

            Iterator<String> iterator = cards.iterator();
            JSONObject card = (JSONObject)parser.parse(iterator.next());
            while(iterator.hasNext() && !card.get("id").equals(id + "")) {
                card = (JSONObject)parser.parse(iterator.next());
            }
            System.out.print(card.get("nom"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }*

    /**
     * CreateEffect method to create an effect from a card id and a description
     * @param id
     * @param effectDescription
     * @return Effect
     */
    private Effect createEffect(int id, String effectDescription) {
        String effectClassName = "Effect" + String.format("%04d", id);
        try {
            Class<?> effectClass = Class.forName(effectClassName);
            Constructor<?> effectConstructor = effectClass.getConstructor();
            return (Effect) ((Constructor<?>) effectConstructor).newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            // Lancez une exception ou affectez une valeur par défaut à l'effet
            return null;
        }
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

    /**
     * Method to apply the effect of the {@link Card}
     * @param card The card to apply the effect
     * @param player The player to apply the effect
     * @param playMat The playMat to apply the effect
     */
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat) throws IOException{
        if(this.effect != null){
            this.effect.applyEffect(card, player, playMat);
        }

    }



}
