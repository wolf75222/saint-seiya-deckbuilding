package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

public class CardData {
    private int id;
    private String nom;
    private String classe;
    private String rang;
    @JsonProperty("cout force")
    private int coutForce;

    @JsonProperty("cout cosmos")
    private int coutCosmos;
    private int force;
    private int vie;
    private int cosmos;
    private int points;
    private String objet;
    private String effets;

    public CardData() {}

    public CardData(JsonNode node) {
        System.out.println("CardData");
        ObjectMapper mapper = new ObjectMapper();

        id = node.has("id") ? node.get("id").asInt(-1) : -1;
        nom = node.has("nom") ? node.get("nom").asText("") : "";
        classe = node.has("classe") ? node.get("classe").asText("") : "";
        rang = node.has("rang") ? node.get("rang").asText("") : "";
        coutForce = node.has("cout force") ? node.get("cout force").asInt(-1) : -1;
        coutCosmos = node.has("cout cosmos") ? node.get("cout cosmos").asInt(-1) : -1;
        force = node.has("force") ? node.get("force").asInt(-1) : -1;
        vie = node.has("vie") ? node.get("vie").asInt(-1) : -1;
        cosmos = node.has("cosmos") ? node.get("cosmos").asInt(-1) : -1;
        points = node.has("points") ? node.get("points").asInt(-1) : -1;
        objet = node.has("objet") ? node.get("objet").asText("") : "";
        effets = node.has("effets") ? node.get("effets").asText("") : "";
    }




    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getClasse() {
        return classe;
    }

    public String getRang() {
        return rang;
    }

    public int getCoutForce() {
        return coutForce;
    }

    public int getCoutCosmos() {
        return coutCosmos;
    }

    public int getForce() {
        return force;
    }

    public int getVie() {
        return vie;
    }

    public int getCosmos() {
        return cosmos;
    }

    public int getPoints() {
        return points;
    }



    public String getObjet() {
        return objet;
    }

    public String getEffets() {
        return effets;
    }
}
