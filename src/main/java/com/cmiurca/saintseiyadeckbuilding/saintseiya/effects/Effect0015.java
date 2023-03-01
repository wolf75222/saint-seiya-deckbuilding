package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;

import java.io.IOException;


/**
 * Effect0015 class, where the effect "Mise en jeu - Détruire 1 Personnage de votre défausse ; piocher 1 carte." is created.
 * 
 * @author Sirwolf, EvanEtSens
 * @version 1.1
 * @since 2023-02-04
 */
public class Effect0015 extends Effect {

    /**
     * The constructor of the effect.
     * 
     * @param id The id of the effect.
     * @param description The description of the effect.
     */
    public Effect0015(int id, String description) {
        super(15, "Mise en jeu - Détruire 1 Personnage de votre défausse ; piocher 1 carte.", EffectType.SETTINGGAME);
    }

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     */
    @Override
    public  void applyEffect(Card [] card) throws IOException {
    }


    /**
     * The method that applies the effect.
     * @param player The player that the effect is applied to.
     */
    @Override
    public void applyEffect(Player [] player) throws IOException{
       
    }
    
    /**
     * The method that applies the effect.
     * @param playMat The playMat that the effect is applied to.
     */
    @Override
    public void applyEffect(PlayMat playMat) throws IOException{}

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     */
    public void applyEffect(Card [] card, Player [] player) throws IOException{
        //Mise en jeu - Détruire 1 Personnage de votre défausse ; piocher 1 carte."

        player[0].moveCardFromDiscardToDestroyedCards(card[0]);
        player[0].moveCardFromDeckToHand(card[0]);
    }

    /**
    Mise en jeu - Détruire 1 Personnage de votre défausse ; piocher 1 carte."
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Card [] card, PlayMat playMat) throws IOException{}

    /**
     * The method that applies the effect.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Player [] player, PlayMat playMat) throws IOException{}
    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat) throws IOException{}
}