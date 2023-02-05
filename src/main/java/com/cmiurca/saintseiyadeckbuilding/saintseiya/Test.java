package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import java.io.File;
import java.util.Arrays;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * Test
 * @author Sirwolf
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ComplileAllFiles();

    }

    /**
     * Compile all java files in the current directory
     */
    public static void ComplileAllFiles() {
        File dir = new File(".");
        File[] javaFiles = dir.listFiles((d, name) -> name.endsWith(".java"));
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        Arrays.stream(javaFiles).forEach(file -> {
            int result = compiler.run(null, null, null, file.getPath());
            if (result == 0) {
                System.out.println(file.getName() + " est compilé avec succès");
            } else {
                System.out.println(file.getName() + " a échoué à la compilation");
            }
        });
    }


}
