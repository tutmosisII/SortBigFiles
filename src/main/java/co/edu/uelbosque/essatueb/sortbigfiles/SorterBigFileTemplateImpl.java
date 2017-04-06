/*
 * Apache 2.0
 * Universidad El Bosque  * 
 */
package co.edu.uelbosque.essatueb.sortbigfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

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
         this.outPutDir.mkdirs();
         try{
         FileWriter fw=new FileWriter(this.outPutDir+"/Part"+fileNumber+".txt");
         for (int i = 0; i < lines.length; i++) {
            String line = lines[i]+"\n";
            fw.write(line);
        }
         fw.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
        }
    }

    @Override
    protected File mergeFiles(File file1, File file2) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Retorna una pila con los archivos a procesar.
     * 
     * @throws IOException 
     */
    @Override
    protected Queue<File> getFilesToOrder() throws IOException {
    	Queue pila=new LinkedList<>();
    	Stream<Path> paths=Files.list(this.outPutDir.toPath());
    	Iterator<Path> i=paths.iterator();
    	while(i.hasNext()){
    		Path tmp=i.next();
    		File f=tmp.toFile();
    		pila.add(f);
    	}
    	return pila;
    }

    BufferedReader br;
    void setBufferReader(BufferedReader br) {
       this.br=br;
    }
    
}
