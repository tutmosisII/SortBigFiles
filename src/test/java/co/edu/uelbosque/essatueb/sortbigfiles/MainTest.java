/*
 * Apache 2.0
 * Universidad El Bosque  * 
 */
package co.edu.uelbosque.essatueb.sortbigfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 *
 * @author user
 */
public class MainTest {
    
    public MainTest() {
        
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldFireAnExeption(){
        Main.main(new String[0]);
    }
    
    @Test
    public void theFilePathShouldBeValidAndReadable() throws IOException{
        String dir = System.getProperty("user.dir");
        File test_txt=new File(dir+"/test.txt");
        Files.createFile(test_txt.toPath());
        boolean existe=Main.validar(test_txt.toPath());
        assertTrue(existe);
    }
    
    @Test
    public void theFileDoesNotExist(){
        String dir = System.getProperty("user.dir");
        File test_txt=new File(dir+"/testNoExiste.txt");
        boolean existe=Main.validar(test_txt.toPath());
        assertFalse(existe);
    }
    
    
    @AfterClass
    public void cleanTest() throws IOException{
        String dir = System.getProperty("user.dir");
        File test_txt=new File(dir+"/test.txt");
        Files.deleteIfExists(test_txt.toPath());
    }
}
