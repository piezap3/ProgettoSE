/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.swing.filechooser.FileSystemView;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mattiiaaa
 */
public class TriggerFileExistenceTest {
    
    public TriggerFileExistenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isVerified method (class TriggerFileExistence).
     */
    @Test
    public void testIsVerified() throws IOException {
        System.out.println("isVerified");
        // Crea un file di prova sul desktop
        String desktop = getDesktopPath();
        Path filePath = Paths.get(desktop, "test.txt");
        Files.createFile(filePath);
        // Crea un'istanza di TriggerFileExistence con il nome del file di prova
        TriggerFileExistence instance = new TriggerFileExistence("test.txt");
        // Verifica che il trigger sia verificato
        boolean expResult = true;
        boolean result = instance.isVerified();
        assertEquals(expResult, result);
        // Cancella il file di prova
        Files.delete(filePath);
        // Verifica che il trigger non sia più verificato
        expResult = false;
        result = instance.isVerified();
        assertEquals(expResult, result);
    }

    /**
     * Test of triggerAttribute method (class TriggerFileExistence).
     */
    @Test
    public void testTriggerAttribute() {
        System.out.println("triggerAttribute");
        // Crea un'istanza di TriggerFileExistence con un nome di file arbitrario
        TriggerFileExistence instance = new TriggerFileExistence("a.txt");
        // Verifica che il triggerAttribute restituisca la stringa corretta
        StringProperty expResult = new SimpleStringProperty("file existence trigger: a.txt");
        StringProperty result = instance.triggerAttribute();
        assertEquals(expResult.get(), result.get());
    }
    
    private String getDesktopPath() {
        // Ottieni l'istanza di FileSystemView
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        // Ottieni il percorso del desktop
        return fileSystemView.getHomeDirectory().getPath();
    }
}
