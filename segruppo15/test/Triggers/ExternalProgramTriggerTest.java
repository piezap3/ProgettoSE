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
        ExternalProgramTrigger instance = new ExternalProgramTrigger("lib/mol.py//python3//3 3//9");       

        // Simula l'input standard per il programma esterno
        String input = "1\n3 3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));

           
        // La prima chiamata a isVerified dovrebbe restituire true
        boolean expResult = true;
        boolean result = instance.isVerified();
        assertEquals(expResult, result);
        // La seconda chiamata a isVerified dovrebbe restituire false
        expResult = false;
        result = instance.isVerified();
        assertEquals(expResult, result);
    }

    /**
     * Test of triggerAttribute method, of class ExternalProgramTrigger.
     */
    @Test
    public void testTriggerAttribute() {
        System.out.println("triggerAttribute");
        ExternalProgramTrigger instance = new ExternalProgramTrigger("lib/mol.py//python3//3 3//9");
        String expResult = "External Program Trigger: lib/mol.py//python3//3 3//9";
        String result = instance.triggerAttribute().get();
        assertEquals(expResult, result);
    }
    
}
