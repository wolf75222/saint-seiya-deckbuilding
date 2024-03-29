package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.util.ArrayList;

public class Effect0070 extends Effect {

	/**
	 * The constructor of the effect.
	 */
	public Effect0070() {
		super(70, "Spica gagne +1 de Force lorsqu'il combat aux côtés de Léda.", EffectType.OTHER);
	}

	/**
	 * The method that applies the effect.
	 * @param cards The cards that the effect is applied to.
	 * @param players The players that the effect is applied to.
	 * @param playMat The playMat that the effect is applied to.
	 */
	@Override
	public void applyEffect(ArrayList<Card> cards, ArrayList<Player> players, PlayMat playMat) {
		// TODO : implémenter l'effet
	}

}
