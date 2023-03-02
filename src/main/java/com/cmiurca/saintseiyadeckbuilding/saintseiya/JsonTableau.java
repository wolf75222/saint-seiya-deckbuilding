package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonTableau {

    public static void main(String[] args) {

        // Vérifier que l'argument est présent
        if (args.length == 0) {
            System.out.println("Veuillez fournir un id en argument.");
            return;
        }

        // Récupérer l'id depuis les arguments
        int id = Integer.parseInt(args[0]);

        // Charger le fichier JSON
        File jsonFile = new File("tableau.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode;

        try {
            rootNode = objectMapper.readTree(jsonFile);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier JSON : " + e.getMessage());
            return;
        }

        // Parcourir les objets du tableau et trouver celui avec l'id voulu
        for (JsonNode node : rootNode) {
            if (node.path("id").asInt() == id) {
                // Afficher le nom
                System.out.println(node.path("nom").asText());
                return;
            }
        }

        // Si aucun objet avec l'id voulu n'a été trouvé, afficher un message
        System.out.println("Aucun objet avec l'id " + id + " n'a été trouvé.");
    }
}
