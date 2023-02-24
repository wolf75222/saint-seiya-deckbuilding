package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;


/**
 * Effect0017 class, where the effect "Arrivée - Pope et tous les Chevaliers d'Or retirés du jeu sont mélangés dans la réserve" is created.
 * 
 * @author Sirwolf, elisemag
 * @version 1.1
 * @since 2023-02-04
 */
public class Effect0017 extends Effect {

    /**
     * The constructor of the effect.
     * 
     * @param id The id of the effect.
     * @param description The description of the effect.
     */
    public Effect0017(int id, String description) {
        super(0017, "Arrivée - Pope et tous les Chevaliers d'Or retirés du jeu sont mélangés dans la réserve", EffectType.ARRIVAL);
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
    public void applyEffect(PlayMat playMat){
        //Arrivée - Pope et tous les Chevaliers d'Or retirés du jeu sont mélangés dans la réserve
        Card[] riviere = playmat.getCardLocation();
        int location = 0;
        Card pope;
        for(int i=0; i<riviere.length; i++){
            if(riviere[i].getId()==17){
                location = i; 
                pope = riviere[i];
            }
        }
        playmat.RemoveCardFromLocation(location);
        playmat.addCardToCardReserve(pope);
        

        Card[] defausse = playmat.getCommonDiscard();
        for(int j=0; j<defausse.length; j++){
            if(defausse[j].getCategory().equals("Chevalier d'Or")){
                playmat.removeCardFromCommonDiscard(defausse[j]);
            }
        }
    }

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
