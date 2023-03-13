package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import java.util.ArrayList;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;

public class Effect0001 extends Effect {

    /**
     * The constructor of the effect.
     */
    public Effect0001() {
        super(1, "Renforcer Seiya avec l'Armure de Pégase.", EffectType.STRENGTHEN);
    }

    /**
     * The method that applies the effect.
     * @param cards The cards that the effect is applied to.
     * @param players The players that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    @Override
    public void applyEffect(ArrayList<Card> cards, ArrayList<Player> players, PlayMat playMat) {

    }
}

