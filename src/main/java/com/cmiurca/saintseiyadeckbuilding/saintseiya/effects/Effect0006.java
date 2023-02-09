package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;


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
        super(id, description, EffectType.DISCARD);
    }

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     */
    @Override
    public  void applyEffect(Card [] card) {

        // "Défausser - Détruire 2 Seiya identiques de votre main puis ajouter à votre défausse 1 Seiya de rang immédiatement supérieur"
    }


    /**
     * The method that applies the effect.
     * @param player The player that the effect is applied to.
     */
    @Override
    public void applyEffect(Player [] player){}
    
    /**
     * The method that applies the effect.
     * @param playMat The playMat that the effect is applied to.
     */
    @Override
    public void applyEffect(PlayMat playMat){}

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     */
    public void applyEffect(Card [] card, Player [] player){}

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Card [] card, PlayMat playMat){}

    /**
     * The method that applies the effect.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Player [] player, PlayMat playMat){}
    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat){}
}
