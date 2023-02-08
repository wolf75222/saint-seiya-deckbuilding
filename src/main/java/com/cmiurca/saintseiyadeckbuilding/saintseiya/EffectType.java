package com.cmiurca.saintseiyadeckbuilding.saintseiya;

/**
 * EffectType enum, where the effect type is created.
 * 
 * @author Sirwolf
 * @version 1.3
 * @since 2023-02-04
 */
public enum EffectType {
    /**
     * The effect type.
     */
    STRENGTHEN("Strengthen"),
    DISCARD("Discard"),
    SETTINGGAME("Setting Game"),
    ARRIVAL("Arrival"),
    HURT("Hurt"),
    DEFEATED("Defeated"),
    DESTROY("Destroy"),
    FREEZE("Freeze"),
    MARKED("Marked"),
    OTHER("Other");

    /**
     * The description of the effect type.
     */
    private String description;

    /**
     * The constructor of the effect type.
     * 
     * @param description The description of the effect type.
     */
    private EffectType(String description) {
        this.description = "";
    }

    /**
     * The getter of the description.
     * @return The description of the effect type.
     */
    public String getDescription() {
        return description;
    }

    /**
     * The setter of the description.
     * @param description The description of the effect type.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The getter of the effect type.
     * @param description The description of the effect type.
     * @return The effect type.
     */
    public static EffectType getEffectType(String description) {
        for (EffectType effectType : EffectType.values()) {
            if (effectType.getDescription().equals(description)) {
                return effectType;
            }
        }
        return null;
    }

    /**
     * The toString method of the effect type.
     * @return The description of the effect type.
     */
    @Override
    public String toString() {
        return description;
    }





}

