package com.cmiurca.saintseiyadeckbuilding.saintseiya;

/**
 * Effect class, where the effect is created.
 * 
 * @author Sirwolf
 * @version 1.3
 * @since 2023-02-04
 */
public abstract class Effect {

    /**
     * The id of the effect.
     */
    private final int id;
    
    /**
     * The description of the effect.
     */
    private final String description;
    
    /**
     * The type of the effect.
     */
    private final EffectType type;
    
    /**
     * The constructor of the effect.
     * 
     * @param id The id of the effect.
     * @param description The description of the effect.
     * @param type The type of the effect.
     */
    public Effect(int id, String description, EffectType type) {
        this.id = id;
        this.description = description;
        this.type = type;
    }

    /**
     * The getter of the id.
     * @return The id of the effect.
     */
    public int getId() {
        return id;
    }

    /**
     * The getter of the description.
     * @return The description of the effect.
     */
    public String getDescription() {
        return description;
    }

    /**
     * The getter of the type.
     * @return The type of the effect.
     */
    public EffectType getType() {
        return type;
    }

    /**
     * The method that applies the effect.
     */
    public abstract void applyEffect();
}


