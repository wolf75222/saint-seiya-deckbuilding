package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.util.ArrayList;

public class Effect0015 extends Effect {

	/**
	 * The constructor of the effect.
	 */
	public Effect0015() {
		super(15, "Mise en jeu - Détruire 1 Personnage de votre défausse ; piocher 1 carte.", EffectType.SETTINGGAME);
	}

	/**
	 * The method that applies the effect.
	 * @param cards The cards that the effect is applied to.
	 * @param players The players that the effect is applied to.
	 * @param playMat The playMat that the effect is applied to.
	 */
	@Override
	public void applyEffect(ArrayList<Card> cards, ArrayList<Player> players, PlayMat playMat) {
		// si la carte dans cards est dans la defausse du joueur
		if (players.get(0).occurenceInDiscard(cards.get(0)) >= 1) {
			players.get(0).moveCardFromDiscardToDestroyedCards(cards.get(0));
			players.get(0).drawCard();
		}

		else {
			throw new IllegalArgumentException("Vous  n'avez pas assez de cartes Personnage dans votre défausse.");
		}
	}

}
