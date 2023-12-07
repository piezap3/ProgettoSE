/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mattiiaaa
 */
public class TriggerDayOfMonthTest {
    
    public TriggerDayOfMonthTest() {
    }

    /**
     * Test of isVerified method (class TriggerDayOfMonth).
     */
    @Test
    public void testIsVerified() {
        System.out.println("isVerified");
        // Creo un trigger con il giorno del mese attuale
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        String dayString = String.valueOf(day);
        TriggerDayOfMonth instance = new TriggerDayOfMonth(dayString);
        
        // Il trigger dovrebbe essere verificato la prima volta
        boolean expResult = true;
        boolean result = instance.isVerified();
        assertEquals(expResult, result);
        
        // Il trigger non dovrebbe essere verificato di nuovo nello stesso mese
        expResult = false;
        result = instance.isVerified();
        assertEquals(expResult, result);
        
        // Il trigger dovrebbe essere verificato di nuovo il mese successivo
        LocalDate nextMonth = today.plusMonths(1);
        instance.setMonth(nextMonth.getMonthValue());
        expResult = true;
        result = instance.isVerified();
        assertEquals(expResult, result);
    }

    /**
     * Test of triggerAttribute method (class TriggerDayOfMonth).
     */
    @Test
    public void testTriggerAttribute() {
        System.out.println("triggerAttribute");
        // Creo un trigger con un giorno del mese arbitrario
        String dayString = "15";
        TriggerDayOfMonth instance = new TriggerDayOfMonth(dayString);
        // Il trigger dovrebbe restituire la stringa corretta
        String expResult = "day of month Trigger: 15";
        String result = instance.triggerAttribute().get();
        assertEquals(expResult, result);
    }
    
}
