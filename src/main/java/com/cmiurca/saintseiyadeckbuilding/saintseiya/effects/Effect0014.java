package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.util.ArrayList;

public class Effect0014 extends Effect {

	/**
	 * The constructor of the effect.
	 */
	public Effect0014() {
		super(14, "Mise en jeu - Si Shun utilise son cosmos pour acquérir un Personnage du terrain ; piocher 1 carte.", EffectType.SETTINGGAME);
	}

	/**
	 * The method that applies the effect.
	 * @param cards The cards that the effect is applied to.
	 * @param players The players that the effect is applied to.
	 * @param playMat The playMat that the effect is applied to.
	 */
	@Override
	public void applyEffect(ArrayList<Card> cards, ArrayList<Player> players, PlayMat playMat) {
		if (players.get(0).occurenceInHand(4) >= 1 && players.get(0).canAcquireByCosmos(playMat)) {
			players.get(0).drawCard();
		}
		else {
			throw new IllegalArgumentException("Vous  n'avez pas assez de cartes Shun dans votre main.");
		}

	}

}
