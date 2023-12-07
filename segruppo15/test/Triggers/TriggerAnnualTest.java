/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zappu
 */
public class TriggerAnnualTest {
    
    public TriggerAnnualTest() {
    }

    /**
     * Test of isVerified method (class TriggerAnnual).
     */
    @Test
    public void testIsVerified() {
        System.out.println("isVerified");
        // Creo un trigger annuale con la data di oggi
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = today.format(formatter);
        TriggerAnnual instance = new TriggerAnnual(date);
        // Il trigger dovrebbe essere verificato
        boolean expResult = true;
        boolean result = instance.isVerified();
        assertEquals(expResult, result);
        // Il trigger non dovrebbe essere verificato di nuovo nello stesso giorno
        expResult = false;
        result = instance.isVerified();
        assertEquals(expResult, result);
    }

    /**
     * Test of triggerAttribute method (class TriggerAnnual).
     */
    @Test
    public void testTriggerAttribute() {
        System.out.println("triggerAttribute");
        // Creo un trigger annuale con una data arbitraria
        String date = "2023-12-25";
        TriggerAnnual instance = new TriggerAnnual(date);
        // Il trigger dovrebbe restituire la stringa corretta
        String expResult = "Annual Trigger: 2023-12-25";
        String result = instance.triggerAttribute().get();
        assertEquals(expResult, result);
    }
    
}
