package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

public class Effect0003 extends Effect{

    public Effect0003() {
        super(3, "Renforcer Hyoga avec l'Armure du Cygne.", EffectType.STRENGTHEN);
    }

    @Override
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat) {
    }
}

