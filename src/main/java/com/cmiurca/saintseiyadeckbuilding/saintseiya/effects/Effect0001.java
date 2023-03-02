package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

public class Effect0001 extends Effect{

    public Effect0001() {
        super(1, "Renforcer Seiya avec l'Armure de Pégase.", EffectType.STRENGTHEN);
    }

    @Override
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat) {
    }
}
