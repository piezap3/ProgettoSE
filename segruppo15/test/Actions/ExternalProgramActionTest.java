/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import javafx.beans.property.StringProperty;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrea
 */
public class ExternalProgramActionTest {
    
    public ExternalProgramActionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of exec method, of class ExternalProgramAction.
     */
    @Test
    public void testExec() {
        ExternalProgramAction  epa = new ExternalProgramAction("python3//lib/test.py");
        
        // Simuliamo input e output per il test
        String simulatedInput = "2\narg1\narg2\n";
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // Esegui il metodo exec()
        epa.exec();
        
        // Ripristina input/output originali
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
        
        // Verifica l'output simulato
        String expectedOutput = "Inserisci il numero di argomenti da voler inserire: "+'\n'+"Inserisci gli argomenti: "+'\n'
                +"Argomento 1:"+'\n'+"Argomento 2:"+'\n'+"Output del programma esterno: "+'\n'+
                "Argomenti ricevuti:"+'\n'+"arg1"+'\n'+"arg2"+'\n'+
                "Il programma esterno è estato eseguito e ha restituito il codice di uscita: 0"; // Aggiungi qui l'output atteso
        
        // Ottieni l'output effettivo
        String actualOutput = outputStream.toString();
        
        assertEquals(expectedOutput.trim(), actualOutput.trim());
    }

    /**
     * Test of actionAttribute method, of class ExternalProgramAction.
     */
    @Test
    public void testActionAttribute() {
        String path = "python3//lib/test.py";
        
        ExternalProgramAction action = new ExternalProgramAction(path);
        
        StringProperty attribute = action.actionAttribute();
        assertEquals("External Program Action: "+path,attribute.get());
    }
    
}
