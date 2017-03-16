/*
 * Apache 2.0
 * Universidad El Bosque  * 
 */
package co.edu.uelbosque.essatueb.sortbigfiles;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author user
 */
public class EdadComparatorTest {
    
    public EdadComparatorTest() {
    }
    
    @Test
    public void laPruebaDebeOrdenar2PersonasMayorMenor(){
        Persona p1=new Persona();
        p1.setEdad(20);
        Persona p2=new Persona();
        p2.setEdad(10);
        EdadComparator ec=new EdadComparator();
        int resultado=ec.compare(p1,p2);
        assertTrue(resultado>=1);
    }
    
    @Test
    public void laPruebaDebeOrdenar2PersonasMenorMayor(){
        Persona p1=new Persona();
        p1.setEdad(10);
        Persona p2=new Persona();
        p2.setEdad(20);
        EdadComparator ec=new EdadComparator();
        int resultado=ec.compare(p1,p2);
        assertTrue(resultado<0);
    }
    
    @Test
    public void laPruebaDebeOrdenar2PersonasIguales(){
        Persona p1=new Persona();
        p1.setEdad(20);
        Persona p2=new Persona();
        p2.setEdad(20);
        EdadComparator ec=new EdadComparator();
        int resultado=ec.compare(p1,p2);
        assertTrue(resultado==0);
    }
}
