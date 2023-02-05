package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import java.io.File;
import java.util.Arrays;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Test, a class to test the compilation of all java files in the current directory and some other stuff
 * @author Sirwolf
 * @version 1.2
*/
public class Test {

    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        String path = "com/cmiurca/saintseiyadeckbuilding/saintseiya";
        System.out.println("Test: ");
        System.out.println(" - " + "Compilation de tous les fichiers .java dans le dossier courant : ");
        complileAllFiles(path);
        System.out.println(" - " + "Vérification de l'exécution des fichiers .class :");
        checkExecution(path);
    }

    /**
     * Compile all java files in the path directory
     */
    public static void complileAllFiles(String path) {
        File dir = new File(path);
        File[] javaFiles = dir.listFiles((d, name) -> name.endsWith(".java"));
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        System.out.println(" - " +"Nombre de fichiers Java dans le répertoire courant : " + javaFiles.length);
        Arrays.stream(javaFiles).forEach(file -> {
            int result = compiler.run(null, null, null, file.getPath());
            if (result == 0) {
                System.out.println(" --> " + file.getName() + " ✔");
            } else {
                System.out.println(" --> " + file.getName() + " ✖");
            }
        });
    }

    /**
    * Check for errors during the execution of compiled files
    */
    public static void checkExecution(String path) {
        File dir = new File(path);
        File[] classFiles = dir.listFiles((d, name) -> name.endsWith(".class"));
        System.out.println(TEXT_BLUE + " - " + "Nombre de fichiers Java dans le répertoire courant : " + classFiles.length + TEXT_RESET);
    
        Arrays.stream(classFiles).forEach(file -> {
            if (!file.getName().substring(0, file.getName().length() - 6).equals("Test")) {
                try {
                    Class<?> c = Class.forName("com.cmiurca.saintseiyadeckbuilding.saintseiya." + file.getName().substring(0, file.getName().length() - 6));
                    try {
                        Method m = c.getDeclaredMethod("main", String[].class);
                        m.invoke(null, (Object) new String[] {});
                        System.out.println(TEXT_GREEN + " --> " + file.getName() + " ✔" + TEXT_RESET);
                    } catch (NoSuchMethodException e) {
                        System.out.println(TEXT_YELLOW + " --> " + file.getName() + " /!\\ (doesn't have a main method), skipping..." + TEXT_RESET);
                    }
                } catch (ClassNotFoundException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    System.out.println(TEXT_RED + " --> " + file.getName() + " \u2716" + TEXT_RESET);
                    e.printStackTrace();
                }
            }
        });
    }
    


    



}



               

