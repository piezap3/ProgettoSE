/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Actions;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
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
public class MultiActionTest {
    
    public MultiActionTest() {
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
     * Test of addAction method, of class MultiAction.
     */
    @Test
    public void testAddAction_Action() {
        System.out.println("addAction_Action");
        Action action = new MessageAction("Ciao"); // Creazione azione
        MultiAction instance = new MultiAction(); // Creazione istanza MultiAction
        instance.addAction(action);
        

        assertEquals(1, instance.getSizeChildActions());
    }

    /**
     * Test of addAction method, of class MultiAction.
     */
    @Test
    public void testAddAction_String_String() {
        System.out.println("addAction_String_String");
        String type = "tipo";
        String str = "string";
        MultiAction instance = new MultiAction(); // Creazione istanza MultiAction
        instance.addAction(type, str); // Viene passato il tipo di azione e la stringa associata 

        assertEquals(1, instance.getSizeChildActions());
    }

    /**
     * Test of exec method, of class MultiAction.
     */
    @Test
    public void testExec() {
        System.out.println("exec");
        MultiAction instance = new MultiAction(); // Creazione istanza MultiAction
        instance.addAction(new MessageAction("Ciao")); 
        instance.addAction(new AudioAction("C:\\Users\\zappu\\Desktop\\car2\\audio.mp3")); 
        instance.exec();
    }

    /**
     * Test of actionAttribute method, of class MultiAction.
     */
    @Test
    public void testActionAttribute() {
        System.out.println("actionAttribute"); 
        MultiAction instance = new MultiAction(); // Crea un'istanza di MultiAction
        StringProperty result = instance.actionAttribute(); // Invoca il metodo actionAttribute
        assertNotNull(result); // Verifica che il risultato non sia nullo
    }

    /**
     * Test of getQuantity method, of class MultiAction.
     */
    @Test
    public void testGetQuantity() {
         System.out.println("getQuantity");
        MultiAction instance = new MultiAction();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result); // se result = expResult => test passato
    }

    /**
     * Test of isValid method, of class MultiAction.
     */
    @Test
    public void testIsValid() {
       System.out.println("isValid"); 
        MultiAction instance = new MultiAction(); // Crea un'istanza di MultiAction
        boolean result = instance.isValid(); // Invoca il metodo isValid
        assertFalse(result); // Verifica che il risultato sia falso
    }

    /**
     * Test of printActionList method, of class MultiAction.
     */
    @Test
    public void testPrintActionList() {
        System.out.println("printActionList");
        MultiAction instance = new MultiAction();
        instance.addAction(new MessageAction("Ciao")); 
        instance.addAction(new AudioAction("C:\\Users\\zappu\\Desktop\\car2\\audio.mp3")); 
        instance.printActionList();
    }   
}
