package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.io.IOException;


/**
 * Effect0011 class, where the effect "Mise en jeu - Si votre défausse comprend au moins 1 Seiya ; piocher 1 carte" is created.
 * 
 * @author Sirwolf, elisemag
 * @version 1.1
 * @since 2023-02-04
 */
public class Effect0011 extends Effect {

    /**
     * The constructor of the effect.
     * 
     * @param id The id of the effect.
     * @param description The description of the effect.
     */
    public Effect0011(int id, String description) {
        super(11, "Mise en jeu - Si votre défausse comprend au moins 1 Seiya ; piocher 1 carte", EffectType.SETTINGGAME);
    }

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    @Override
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat)  {
        // "Mise en jeu - Si votre défausse comprend au moins 1 Seiya ; piocher 1 carte"
        if(player[0].occurenceInDiscard(0001)> 0 || player[0].occurenceInDiscard(0011)>0){
            player[0].moveCardFromDeckToHand(card[0]);
        }

    }
}
