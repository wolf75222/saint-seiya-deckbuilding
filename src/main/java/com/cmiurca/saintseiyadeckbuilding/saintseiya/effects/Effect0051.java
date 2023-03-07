package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.io.IOException;


/**
 * Effect0051 class, where the effect "Shun gagne +1Cosmos lorsqu'il est joué aux côtés d'Albior de Céphée.
                                        Défausser - Récupérer en main 1 Personnage présent dans votre défausse." is created.
 * 
 * @author EvanEtSens
 * @version 1.1
 * @since 2023-02-04
 */
public class Effect0051 extends Effect {

    /**
     * The constructor of the effect.
     * 
     * @param id The id of the effect.
     * @param description The description of the effect.
     */
    public Effect0051(int id, String description) {
        super(id, "Shun gagne +1Cosmos lorsqu'il est joué aux côtés d'Albior de Céphée.Défausser - Récupérer en main 1 Personnage présent dans votre défausse.", EffectType.DISCARD);
    }

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat)  {}
}
