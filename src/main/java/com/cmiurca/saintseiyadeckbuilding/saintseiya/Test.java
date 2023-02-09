package com.cmiurca.saintseiyadeckbuilding.saintseiya;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


    /**
     * Main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = "com/cmiurca/saintseiyadeckbuilding/saintseiya";
        System.out.println(TEXT_PURPLE + "Test: "  + path + TEXT_RESET);
        System.out.println(TEXT_PURPLE + " - " + "Compilation de tous les fichiers .java dans le dossier courant : " + TEXT_RESET);
        compileAllFiles(path);
        System.out.println(TEXT_PURPLE + " - " + "Vérification de l'exécution des fichiers .class :" + TEXT_RESET);
        checkExecution(path);
    
        path = "com/cmiurca/saintseiyadeckbuilding/saintseiya/effects";
        System.out.println(TEXT_PURPLE + "Test: " + path + TEXT_RESET);
        System.out.println(TEXT_PURPLE + " - " + "Compilation de tous les fichiers .java dans le dossier com/cmiurca/saintseiyadeckbuilding/saintseiya/effects : " + TEXT_RESET);
        compileAllFiles(path);
        System.out.println(TEXT_PURPLE + " - " + "Vérification de l'exécution des fichiers .class :" + TEXT_RESET);
        checkExecution(path);

        path = "com/cmiurca/saintseiyadeckbuilding/saintseiya";
        System.out.println(TEXT_CYAN + "Removing: " + path + TEXT_RESET);
        System.out.println(TEXT_CYAN + " - " +  "Removing .class files from directory " + path + " and its subdirectories..." + TEXT_RESET);
        removeClassFiles(path);
        System.out.println(TEXT_CYAN +  " - " + "Removal complete." + TEXT_RESET);
    }
    

    /**
     * Compile all java files in the path directory
     * @param path the path to the directory containing the java files
     */
    public static void compileAllFiles(String path) {
        File dir = new File(path);
        File[] javaFiles;
        if (path.equals("com/cmiurca/saintseiyadeckbuilding/saintseiya/effects")) {
            javaFiles = getAllJavaFiles(dir);
        } else {
            javaFiles = dir.listFiles((d, name) -> name.endsWith(".java"));
        }
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(TEXT_BLUE + " - " + "Nombre de fichiers Java dans le répertoire courant : " + javaFiles.length + TEXT_RESET);
        Arrays.stream(javaFiles).forEach(file -> {
            int result = compiler.run(null, null, null, file.getPath());
            if (result == 0) {
                System.out.println(TEXT_GREEN + " --> " + file.getName() + " ✔" + TEXT_RESET);
            } else {
                System.out.println(TEXT_RED + " --> " + file.getName() + " ✖" + TEXT_RESET);
            }
        });
    }
    
    /**
     * Get all java files in the directory and subdirectories
     * @param dir the directory to search in
     * @return an array of all java files in the directory and subdirectories
     */
    private static File[] getAllJavaFiles(File dir) {
        List<File> javaFiles = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                javaFiles.addAll(Arrays.asList(getAllJavaFiles(file)));
            } else if (file.getName().endsWith(".java")) {
                javaFiles.add(file);
            }
        }
        return javaFiles.toArray(new File[0]);
    }
    
    

    /**
    * Check for errors during the execution of compiled files
    * @param path the path to the directory containing the java files
    */
    public static void checkExecution(String path) {
        File dir = new File(path);
        File[] classFiles = dir.listFiles((d, name) -> name.endsWith(".class"));
        System.out.println(TEXT_BLUE + " - " + "Number of Java files in the current directory: " + classFiles.length + TEXT_RESET);
    
        Arrays.stream(classFiles).forEach(file -> {
            if (!file.getName().substring(0, file.getName().length() - 6).equals("Test")) {
                String className = "com.cmiurca.saintseiyadeckbuilding.saintseiya";
                if (file.getParentFile().getName().equals("effects")) {
                    className = "com.cmiurca.saintseiyadeckbuilding.saintseiya.effects";
                }
                className = className + "." + file.getName().substring(0, file.getName().length() - 6);
                try {
                    Class<?> c = Class.forName(className);
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

    /**
     * Remove all .class files in the specified directory and its subdirectories
     * @param path the path to the directory
     */
    public static void removeClassFiles(String path) {
        File dir = new File(path);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    removeClassFiles(file.getAbsolutePath());
                } else if (file.getName().endsWith(".class")) {
                    if (file.delete()) {
                        System.out.println(TEXT_GREEN + " --> " + file.getName() + " has been deleted." + TEXT_RESET);
                    } else {
                        System.out.println(TEXT_RED + " --> Failed to delete " + file.getName() + TEXT_RESET);
                    }
                }
            }
        }
    }



}



               

