package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

public class Effect0002 extends Effect{

    public Effect0002() {
        super(2, "Renforcer Shiryu avec l'Armure du Dragon.", EffectType.STRENGTHEN);
    }

    @Override
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat) {
    }
}
