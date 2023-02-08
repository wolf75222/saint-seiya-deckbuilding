package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
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


    @Override
    public void applyEffect() {

        // "Défausser - Détruire 2 Seiya identiques de votre main puis ajouter à votre défausse 1 Seiya de rang immédiatement supérieur"
    }
}
