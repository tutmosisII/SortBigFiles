/*
 * Apache 2.0
 * Universidad El Bosque  * 
 */
package co.edu.uelbosque.essatueb.sortbigfiles;

import java.util.Comparator;

/**
 *
 * @author user
 */
public class EdadComparator implements Comparator<Persona>{

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getEdad()-o2.getEdad();
    }
    
}
