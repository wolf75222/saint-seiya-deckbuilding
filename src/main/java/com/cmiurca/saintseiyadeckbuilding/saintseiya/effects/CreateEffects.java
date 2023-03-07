package com.cmiurca.saintseiyadeckbuilding.saintseiya.effects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateEffects {

    public static void main(String[] args) {
        String directoryPath = "./src/main/java/com/cmiurca/saintseiyadeckbuilding/saintseiya/effects"; // Dossier courant
        String packageName = "com.cmiurca.saintseiyadeckbuilding.saintseiya.effects"; // Nom du package
        String effectClassName = "Effect"; // Nom de la classe d'effet
        int numEffects = 91; // Nombre d'effets à créer

        for (int i = 1; i < numEffects; i++) {
            // Générer le nom de fichier avec le préfixe et un numéro formaté
            String filename = String.format("%s%04d.java", effectClassName, i);
            // Vérifier si le fichier existe déjà
            File file = new File(directoryPath, filename);
            if (file.exists()) {
                System.out.println("Le fichier " + filename + " existe déjà, il ne sera pas créé.");
                continue;
            }
            // Créer le fichier dans le dossier courant
            try {
                file.createNewFile();
                // Écrire du contenu dans le fichier
                FileWriter writer = new FileWriter(file);
                writer.write("package " + packageName + ";\n\n");
                writer.write("import com.cmiurca.saintseiyadeckbuilding.saintseiya.Effect;\n");
                writer.write("import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;\n");
                writer.write("import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;\n");
                writer.write("import com.cmiurca.saintseiyadeckbuilding.saintseiya.PlayMat;\n");
                writer.write("import com.cmiurca.saintseiyadeckbuilding.saintseiya.EffectType;\n\n");
                writer.write("public class " + effectClassName + String.format("%04d", i) + " extends Effect {\n\n");
                writer.write("\t/**\n");
                writer.write("\t * The constructor of the effect.\n");
                writer.write("\t */\n");
                writer.write("\tpublic " + effectClassName + String.format("%04d", i) + "() {\n");
                writer.write("\t\tsuper(" + i + ", \"Description de l'effet\", EffectType.OTHER);\n");
                writer.write("\t}\n\n");
                writer.write("\t/**\n");
                writer.write("\t * The method that applies the effect.\n");
                writer.write("\t * @param card The card that the effect is applied to.\n");
                writer.write("\t * @param player The player that the effect is applied to.\n");
                writer.write("\t * @param playMat The playMat that the effect is applied to.\n");
                writer.write("\t */\n");
                writer.write("\t@Override\n");
                writer.write("\tpublic void applyEffect(Card [] card, Player [] player, PlayMat playMat) {\n");
                writer.write("\t\t// TODO : implémenter l'effet\n");
                writer.write("\t}\n\n");
                writer.write("}\n");
                writer.close();
                System.out.println("Le fichier " + filename + " a été créé.");
            } catch (IOException e) {
                System.out.println("Erreur lors de la création du fichier : " + e.getMessage());
            }
        }
    }
}
