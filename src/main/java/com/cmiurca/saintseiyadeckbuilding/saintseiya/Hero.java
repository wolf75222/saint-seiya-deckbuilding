package com.cmiurca.saintseiyadeckbuilding.saintseiya;

/**
 * Hero enum, where the hero is created
 * 
 * @author Sirwolf
 * @version 1.0
 * @since 2023-02-04
 */
public enum Hero {

    /**
     * Seiya
     */
    SEIYA(6),
    /**
     * Shiryu
     */
    SHIRYU(7),
    /**
     * Shun
     */
    SHUN(9),
    /**
     * Hyoga
     */
    HYOGA(8),
    /**
     * Ikki
     */
    IKKI(10);

    /**
     * Array of heroes
     */
    private static final Hero[] HEROES = Hero.values();

    /**
     * Size of heroes array
     */
    private static final int SIZE = HEROES.length;

    /**
     * armorId of hero
     */
    private int armorId;

    public int getArmorId() {
        return armorId;
    }

    private Hero(int armorId) {
        this.armorId = armorId;
    }

}
