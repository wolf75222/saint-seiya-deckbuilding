package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.util.ArrayList;

public class Effect0086 extends Effect {

	/**
	 * The constructor of the effect.
	 */
	public Effect0086() {
		super(86, "Détruire - Le coût d'un Chevalier présent sur le terrain est réduit de -2 de Force et -2 de Cosmos (coût minimum de 1 de Force et 1 de Cosmos).", EffectType.OTHER);
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
