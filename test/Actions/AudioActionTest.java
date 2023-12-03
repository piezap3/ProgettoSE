/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Actions;

import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class AudioActionTest {
    
    public AudioActionTest() {
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
     * Test of exec method, of class AudioAction.
     */
    @Test
    public void testExec() {
        // Percorso di un file audio esistente nel tuo sistema
        String filePath = "C:\\Users\\zappu\\Desktop\\audio.mp3";

        // Creazione di un'istanza di AudioAction
        AudioAction audioAction = new AudioAction(filePath);

        // Chiamata al metodo exec
        audioAction.exec();
    }

    
    @Test
    public void testActionAttribute() {
        // Percorso di un file audio esistente nel tuo sistema
        String filePath = "C:\\Users\\Marco\\Downloads\\audio.mp3";

        // Creazione di un'istanza di AudioAction
        AudioAction audioAction = new AudioAction(filePath);

        // Chiamata al metodo actionAttribute
        StringProperty attribute = audioAction.actionAttribute();
        
        // Verifica che l'attributo sia corretto
        assertEquals("Audio Action. File: "+filePath, attribute.get());
    }
    
}
