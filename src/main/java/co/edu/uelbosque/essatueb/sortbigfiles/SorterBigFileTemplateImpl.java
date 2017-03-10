/*
 * Apache 2.0
 * Universidad El Bosque  * 
 */
package co.edu.uelbosque.essatueb.sortbigfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class SorterBigFileTemplateImpl extends SorterBigFileTemplate{

    public SorterBigFileTemplateImpl() {
        super(null, 0, null);
    }

    
    public SorterBigFileTemplateImpl(File toSort, int linesPerFile, File outPutDir) {
        super(toSort, linesPerFile, outPutDir);
    }

    @Override
    public String[] getNextLines() {
        ArrayList<String> lineas=new ArrayList<>();
        for (int i = 0; i < this.linesPerFile; i++) {
            try {
                lineas.add(br.readLine());
             } catch (IOException ex) {
                Logger.getLogger(SorterBigFileTemplateImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String l[]=new String[lineas.size()];
        int i=0;
        for (String string : lineas) {
               l[i]=lineas.get(i);
               i++;
        }
        return l;
    }

    @Override
    public boolean hasMoreLines() {
        try {
            return br.ready();
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public void saveToNewFile(String[] lines, int fileNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    BufferedReader br;
    void setBufferReader(BufferedReader br) {
       this.br=br;
    }
    
}
