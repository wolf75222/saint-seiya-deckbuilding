package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.util.ArrayList;

public class Effect0006 extends Effect {

	/**
	 * The constructor of the effect.
	 */
	public Effect0006() {
		super(6, "Défausser - Détruire 2 Seiya identiques de votre main puis ajouter à votre défausse 1 Seiya de rang immédiatement supérieur.", EffectType.OTHER);
	}

	/**
	 * The method that applies the effect.
	 * @param cards The cards that the effect is applied to.
	 * @param players The players that the effect is applied to.
	 * @param playMat The playMat that the effect is applied to.
	 */
	@Override
	public void applyEffect(ArrayList<Card> cards, ArrayList<Player> players, PlayMat playMat) {
		if (players.get(0).occurenceInHand(1) >= 2) {
			players.get(0).moveCardFromHandToDestroyedCards(1);
			players.get(0).moveCardFromHandToDestroyedCards(1);
			players.get(0).addCardToDiscard(11);
		}
		else {
			throw new IllegalArgumentException("Vous  n'avez pas assez de cartes Seiya dans votre main.");
		}
	}

}
