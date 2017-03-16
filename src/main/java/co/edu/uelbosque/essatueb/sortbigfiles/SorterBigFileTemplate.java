/*
 * Apache 2.0
 * Universidad El Bosque  * 
 */
package co.edu.uelbosque.essatueb.sortbigfiles;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

/**
 *
 * @author Alejandro Leon
 */
public abstract class SorterBigFileTemplate {
    
    protected File toSort;
    protected int linesPerFile;
    protected File outPutDir;

    public SorterBigFileTemplate(File toSort, int linesPerFile, File outPutDir) {
        this.toSort = toSort;
        this.linesPerFile = linesPerFile;
        this.outPutDir=outPutDir;
    }
    
    
    /**
     * 
     * @param toSort File to sort
     * @param linesPerFile Number of Lines perFile
     * @return number of chunks generated
     */
    public int breakFileInChunksAndSortIt(Comparator c){
        int numberOfFile=0;
        while(hasMoreLines()){
            String lines[]=getNextLines();
            ArrayList<Persona> personas = new ArrayList<>();
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
                String persona[]=line.split(",");
             
                Persona p = new Persona(Integer.parseInt(persona[0]), persona[1], persona[2],
                        persona[3], persona [4]);
                personas.add(p);
            }
            personas.sort(c);
            for (int i = 0; i < lines.length; i++) {
                lines[i]=personas.get(i).toString();
                
            }
            saveToNewFile(lines,numberOfFile);
            numberOfFile++;
        }
        return numberOfFile;
    }

    /**
     * Read the next amount of lines for the file 
     * @return 
     */
    public abstract String[] getNextLines();

    /**
     * 
     * @return true when the file to sort has more lines to read 
     */
    public  abstract boolean hasMoreLines() ;

    /**
     * Save the lines to a file in the output folder with a consecutive
     * number at the end of file name
     * @param lines 
     */
    public abstract void saveToNewFile(String[] lines,int fileNumber);

    public File mergeTempSortedFiles(Comparator c){
          Queue<File> filesToOrder=getFilesToOrder();
          while(filesToOrder.size()>1){
              File archivo1=filesToOrder.poll();
              File archivo2=filesToOrder.poll();
              File tmpFileToOrder=mergeFiles(archivo1,archivo2);
              filesToOrder.add(tmpFileToOrder);
          }
          return filesToOrder.poll();
    }

    protected abstract File mergeFiles(File file1, File file2);

    protected abstract Queue<File> getFilesToOrder();
}
