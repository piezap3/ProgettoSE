/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mattiiaaa
 */
public class ExternalProgramTriggerTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    public ExternalProgramTriggerTest() {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Test of isVerified method, of class ExternalProgramTrigger.
     */
     @Test
    public void testIsVerified() {
        System.out.println("isVerified");

        // Simula l'input standard per il programma esterno
        String input = "3\n3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Crea un'istanza del trigger del programma esterno con l'output atteso
        String commandString = "python//lib/mol.py//3 3//9";
        ExternalProgramTrigger instance = new ExternalProgramTrigger(commandString);       
        // La prima chiamata a isVerified dovrebbe restituire true
        boolean expResult = true;
        boolean result = instance.isVerified();
        assertEquals(expResult, result);
        // La seconda chiamata a isVerified dovrebbe restituire false
        expResult = false;
        result = instance.isVerified();
        assertEquals(expResult, result);
        // L'output del programma esterno dovrebbe corrispondere all'output atteso
        String expOutput = "Output del programma esterno: 9\r\n" +
                           "Entrato\r\n" +
                           "Il programma esterno è estato eseguito e ha restituito il codice di uscita: 0\r\n";
        String output = outContent.toString();
        assertEquals(expOutput, output);
    }

    /**
     * Test of triggerAttribute method, of class ExternalProgramTrigger.
     */
    @Test
    public void testTriggerAttribute() {
        System.out.println("triggerAttribute");
        ExternalProgramTrigger instance = new ExternalProgramTrigger("python.exe//lib/mol.py//3 3//9");
        String expResult = "External Program Trigger: python.exe//lib/mol.py//3 3//9";
        String result = instance.triggerAttribute().get();
        assertEquals(expResult, result);
    }
    
}
