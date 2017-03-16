/*
 * Apache 2.0
 * Universidad El Bosque  * 
 */
package co.edu.uelbosque.essatueb.sortbigfiles;

/**
 *
 * @author user
 */
public class Persona {
    private int edad;
    private String documento;
    private String nombre;
    private String tipoDoc;
    private String tipoSangre;

   public Persona(){

   }

   public Persona (int pedad, String pdocumento, String pnombre, String ptipoDoc,
           String ptipoSangre){
        this.edad = pedad;
        this.documento = pdocumento;
        this.nombre = pnombre;
        this.tipoDoc = ptipoDoc;
        this.tipoSangre = ptipoSangre;
   } 
    

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipoDoc
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * @param tipoDoc the tipoDoc to set
     */
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    /**
     * @return the tipoSangre
     */
    public String getTipoSangre() {
        return tipoSangre;
    }

    /**
     * @param tipoSangre the tipoSangre to set
     */
    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    @Override
    public String toString() {
        return ""+this.edad; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
