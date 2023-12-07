/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrea
 */
public class ExternalProgramTriggerTest {
    
    // Creo un oggetto per catturare l'output del sistema
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    // Salvo l'output originale del sistema
    private final PrintStream originalOut = System.out;
    
    public ExternalProgramTriggerTest() {
    }
    
    @Before
    public void setUp() {
        // Imposto l'output del sistema sul mio oggetto
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void tearDown() {
        // Ripristino l'output originale del sistema
        System.setOut(originalOut);
    }

    /**
     * Test del metodo isVerified, della classe ExternalProgramTrigger.
     */
    @Test
    public void testIsVerified() {
        System.out.println("isVerified");
        // Simulo l'input e l'output del programma esterno
        String program = "C:\\Users\\tti_a\\Desktop\\test.py//python//1 2//3";
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        ExternalProgramTrigger instance = new ExternalProgramTrigger(program);
        boolean expResult = true;
        boolean result = instance.isVerified();
        // Verifico che il risultato sia uguale a quello atteso
        assertEquals(expResult, result);
        //Verifico che l'output del programma esterno sia uguale a quello atteso
        String expectedOutput = "Output del programma esterno: 3\r\n" + "Entrato\r\n" + "Il programma esterno è estato eseguito e ha restituito il codice di uscita: 0\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Test del metodo triggerAttribute, della classe ExternalProgramTrigger.
     */
    @Test
    public void testTriggerAttribute() {
        System.out.println("triggerAttribute");
        String program = "C:\\Users\\tti_a\\Desktop\\test.py//python//1 2//3";
        ExternalProgramTrigger instance = new ExternalProgramTrigger(program);
        String expResult = "External Program Trigger: C:\\Users\\tti_a\\Desktop\\test.py//python//1 2//3";
        String result = instance.triggerAttribute().get();
        // Verifico che il risultato sia uguale a quello atteso
        assertEquals(expResult, result);
    }
    
}
