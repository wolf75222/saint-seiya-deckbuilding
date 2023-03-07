package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.io.IOException;


/**
 * Effect0009 class, where the effect "Défausser - Détruire 2 Shun identiques de votre main puis ajouter à votre défausse 1 Shun de rang immédiatement supérieur" is created.
 * 
 * @author Sirwolf, elisemag
 * @version 1.1
 * @since 2023-02-04
 */
public class Effect0009 extends Effect {

    /**
     * The constructor of the effect.
     * 
     * @param id The id of the effect.
     * @param description The description of the effect.
     */
    public Effect0009(int id, String description) {
        super(9, "Défausser - Détruire 2 Shun identiques de votre main puis ajouter à votre défausse 1 Shun de rang immédiatement supérieur", EffectType.DISCARD);
    }

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    @Override
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat)  {
        // "Défausser - Détruire 2 Shun identiques de votre main puis ajouter à votre défausse 1 Shun de rang immédiatement supérieur"
        int id = 004;
        if(player[0].occurenceInHand(004) >= 2){
            player[0].moveCardFromHandToDestroyedCards(id);
            player[0].moveCardFromHandToDestroyedCards(id);
            id = 014;
            player[0].addCardToDiscard(id);
        }
    }
}
