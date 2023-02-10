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
    SEIYA,
    /**
     * Shiryu
     */
    SHIRYU,
    /**
     * Shun
     */
    SHUN,
    /**
     * Hyoga
     */
    HYOGA,
    /**
     * Ikki
     */
    IKKI;

    /**
     * Array of heroes
     */
    private static final Hero[] HEROES = Hero.values();


    /**
     * Method to get the hero
     * @param hero hero to get
     * @return Hero hero
     */
    public static Hero getHero(String hero) {
        switch (hero) {
            case "SEIYA":
                return SEIYA;
            case "SHIRYU":
                return SHIRYU;
            case "SHUN":
                return SHUN;
            case "HYOGA":
                return HYOGA;
            case "IKKI":
                return IKKI;
            default:
                return null;
        }
    }


}
