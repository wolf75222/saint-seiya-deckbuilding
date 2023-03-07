package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.io.IOException;


/**
 * Effect0007 class, where the effect "Défausser - Détruire 2 Shiryu identiques de votre main puis ajouter à votre défausse 1 Shiryu de rang immédiatement supérieur" is created.
 * 
 * @author Sirwolf, elisemag
 * @version 1.1
 * @since 2023-02-04
 */
public class Effect0007 extends Effect {

    /**
     * The constructor of the effect.
     * 
     * @param id The id of the effect.
     * @param description The description of the effect.
     */
    public Effect0007(int id, String description) {
        super(7, "Défausser - Détruire 2 Shiryu identiques de votre main puis ajouter à votre défausse 1 Shiryu de rang immédiatement supérieur", EffectType.DISCARD);
    }

    /**
     * The constructor of the effect.
     */
    public Effect0007() {
        super(7, "Défausser - Détruire 2 Shiryu identiques de votre main puis ajouter à votre défausse 1 Shiryu de rang immédiatement supérieur", EffectType.DISCARD);
    }

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    @Override
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat)  {
        // "Défausser - Détruire 2 Shiryu identiques de votre main puis ajouter à votre défausse 1 Shiryu de rang immédiatement supérieur"
        int id = 002;
        if(player[0].occurenceInHand(002) >= 2){
            player[0].moveCardFromHandToDestroyedCards(id);
            player[0].moveCardFromHandToDestroyedCards(id);
            id = 012;
            player[0].addCardToDiscard(id);
        }


    }
}
