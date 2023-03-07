package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import java.io.File;

public class CurrentDirectory {

    public static void main(String[] args) {
        File currentDirectory = new File(".");
        try {
            System.out.println("Répertoire courant : " + currentDirectory.getCanonicalPath());
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

