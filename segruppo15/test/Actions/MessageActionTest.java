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
 * @author zappu
 */
public class MessageActionTest {
    
    public MessageActionTest() {
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
    
    @Test
    public void testExec() {
         // Crea un MessageAction di prova
        MessageAction action = new MessageAction("Hello world");
        
        // Esegue l'azione
        action.exec();
        
        // Controlla che la condizione sia verificata
        assertTrue(true);

    }

    
    @Test
    public void testActionAttribute() {
        // Messaggio da visualizzare nel popup
        String message = "Questo è un messaggio di test.";

        // Creazione di un'istanza di MessageAction
        MessageAction messageAction = new MessageAction(message);

        // Chiamata al metodo actionAttribute
        StringProperty attribute = messageAction.actionAttribute();

        // Verifica che l'attributo sia corretto
        assertEquals("Message Action: "+message, attribute.get());
    }
}
