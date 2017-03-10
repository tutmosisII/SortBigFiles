/*
 * Apache 2.0
 * Universidad El Bosque  * 
 */
package co.edu.uelbosque.essatueb.sortbigfiles;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Alejandro Leon
 */
public class Main {
    public static void main(String[] args) {
        if(args.length==0)
            throw new IllegalArgumentException("No file to work with");
        if(args.length>1)
            throw new IllegalArgumentException("To Many Arguments");
        File fileToWorkWith=new File(args[0]);
        if(!validar(fileToWorkWith.toPath()))
            throw new IllegalArgumentException("File "+args[0]+" doesn't exists or is not readable");

    }

    public static boolean validar(Path path) {  
        return Files.isReadable(path);
    }
}
