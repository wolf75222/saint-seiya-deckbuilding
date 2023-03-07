package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.io.IOException;


/**
 * Effect0016 class, where the effect "Arrivée - Tous les joueurs piochent 1 carte puis soignent tous leurs Personnages blessés." is created.
 * 
 * @author Sirwolf, elisemag
 * @version 1.1
 * @since 2023-02-04
 */
public class Effect0016 extends Effect {

    /**
     * The constructor of the effect.
     * 
     * @param id The id of the effect.
     * @param description The description of the effect.
     */
    public Effect0016(int id, String description) {
        super(0016, "Arrivée - Tous les joueurs piochent 1 carte puis soignent tous leurs Personnages blessés.", EffectType.ARRIVAL);
    }

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    @Override
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat)  {
        //Arrivée - Tous les joueurs piochent 1 carte puis soignent tous leurs Personnages blessés.
        for (int i=0; i< player.length; i++){
            player[i].moveCardFromDeckToHand(card[0]);
            for(int j=0; j<player[i].getInjuredCharacters().length; j++){
                player[i].moveCardFromInjuredCharactersToDiscard(player[i].getInjuredCharacters()[j]);
            }
        }
    }
}
