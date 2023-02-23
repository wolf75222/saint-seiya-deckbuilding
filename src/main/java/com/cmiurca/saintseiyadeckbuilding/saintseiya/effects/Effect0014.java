package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;


/**
 * Effect0014 class, where the effect "Mise en jeu - Si Shun utilise son cosmos pour acquérir un Personnage du terrain ; piocher 1 carte." is created.
 * 
 * @author Sirwolf, elisemag
 * @version 1.1
 * @since 2023-02-04
 */
public class Effect0014 extends Effect {

    /**
     * The constructor of the effect.
     * 
     * @param id The id of the effect.
     * @param description The description of the effect.
     */
    public Effect0014(int id, String description) {
        super(14, "Mise en jeu - Si Shun utilise son cosmos pour acquérir un Personnage du terrain ; piocher 1 carte.", EffectType.SETTINGGAME);
    }

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     */
    @Override
    public  void applyEffect(Card [] card) {
    }


    /**
     * The method that applies the effect.
     * @param player The player that the effect is applied to.
     */
    @Override
    public void applyEffect(Player [] player){}
    
    /**
     * The method that applies the effect.
     * @param playMat The playMat that the effect is applied to.
     */
    @Override
    public void applyEffect(PlayMat playMat){}

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     */
    public void applyEffect(Card [] card, Player [] player){}

    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Card [] card, PlayMat playMat){}

    /**
     * The method that applies the effect.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Player [] player, PlayMat playMat){}
    /**
     * The method that applies the effect.
     * @param card The card that the effect is applied to.
     * @param player The player that the effect is applied to.
     * @param playMat The playMat that the effect is applied to.
     */
    public void applyEffect(Card [] card, Player [] player, PlayMat playMat){}
}
