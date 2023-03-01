package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardData {
    private int id;
    private String nom;
    private String classe;
    private String rang;
    private int coutForce;
    private int coutCosmos;
    private int force;
    private int vie;
    private int cosmos;
    private int points;
    private String objet;
    private String effets;

    public CardData(@JsonProperty("id") int id,
                    @JsonProperty("nom") String nom,
                    @JsonProperty("classe") String classe,
                    @JsonProperty("rang") String rang,
                    @JsonProperty("cout force") int coutForce,
                    @JsonProperty("cout cosmos") int coutCosmos,
                    @JsonProperty("force") int force,
                    @JsonProperty("vie") int vie,
                    @JsonProperty("cosmos") int cosmos,
                    @JsonProperty("points") int points,
                    @JsonProperty("objet") String objet,
                    @JsonProperty("effets") String effets) {
        this.id = id;
        this.nom = nom;
        this.classe = classe;
        this.rang = rang;
        this.coutForce = coutForce;
        this.coutCosmos = coutCosmos;
        this.force = force;
        this.vie = vie;
        this.cosmos = cosmos;
        this.points = points;
        this.objet = objet;
        this.effets = effets;
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
