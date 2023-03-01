package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.io.IOException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;


/**
 * Effect0006 class, where the effect "Défausser - Détruire 2 Seiya identiques de votre main puis ajouter à votre défausse 1 Seiya de rang immédiatement supérieur" is created.
 * 
 * @author Sirwolf
 * @version 1.1
 * @since 2023-02-04
 */
public class Effect0006 extends Effect {

    /**
     * The constructor of the effect.
     * 
     * @param id The id of the effect.
     * @param description The description of the effect.
     */
    public Effect0006(int id, String description) {
        super(6, "Défausser - Détruire 2 Seiya identiques de votre main puis ajouter à votre défausse 1 Seiya de rang immédiatement supérieur", EffectType.DISCARD);
    }

    public Effect0006() {
        super(6, "Défausser - Détruire 2 Seiya identiques de votre main puis ajouter à votre défausse 1 Seiya de rang immédiatement supérieur", EffectType.DISCARD);
    }

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     */
    @Override
    public  void applyEffect(Card [] card) throws IOException{
    }


    /**
     * The method that applies the effect.
     * @param player The player that the effect is applied to.
     */
    @Override
    public void applyEffect(Player [] player) throws IOException {
        // "Défausser - Détruire 2 Seiya identiques de votre main puis ajouter à votre défausse 1 Seiya de rang immédiatement supérieur"
        int id = 001;
        if(player[0].occurenceInHand(001) >= 2){
            player[0].moveCardFromHandToDestroyedCards(id);
            player[0].moveCardFromHandToDestroyedCards(id);
            id = 011;
            player[0].addCardToDiscard(id);
        }   
    }
    
    /**
     * The method that applies the effect.
     * @param playMat The playMat that the effect is applied to.
     */
    @Override
    public void applyEffect(PlayMat playMat) throws IOException{}

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     */
    public void applyEffect(Card [] card, Player [] player) throws IOException{}

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Card [] card, PlayMat playMat) throws IOException {}

    /**
     * The method that applies the effect.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Player [] player, PlayMat playMat) throws IOException{}
    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat) throws IOException{}
}
