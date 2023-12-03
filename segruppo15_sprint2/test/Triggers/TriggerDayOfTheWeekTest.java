/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @andrea
 */
public class TriggerDayOfTheWeekTest {
    
    public TriggerDayOfTheWeekTest() {
    }

    /**
     * Test of isVerified method, of class TriggerDayOfTheWeek.
     */
    @Test
    public void testIsVerified() {
        System.out.println("isVerified");
        // Creo un trigger con il giorno della settimana attuale
        String day = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        TriggerDayOfTheWeek instance = new TriggerDayOfTheWeek(day);
        // Il trigger dovrebbe essere verificato la prima volta
        boolean expResult = true;
        boolean result = instance.isVerified();
        assertEquals(expResult, result);
        // Il trigger non dovrebbe essere verificato di nuovo nello stesso giorno
        expResult = false;
        result = instance.isVerified();
        assertEquals(expResult, result);
        // Il trigger dovrebbe essere verificato di nuovo la settimana successiva, quindi inserendo il giorno dopo
        //active dove essere true ma isVerified restituisce false finché non arriva lo stesso giorno della settimana successiva
        System.out.println(instance.getActive());
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        day = tomorrow.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        instance = new TriggerDayOfTheWeek(day);
        System.out.println(instance.getActive());
        expResult = false;
        result = instance.isVerified();
        assertEquals(expResult, result);
    }

    /**
     * Test of triggerAttribute method, of class TriggerDayOfTheWeek.
     */
    @Test
    public void testTriggerAttribute() {
        System.out.println("triggerAttribute");
        // Creo un trigger con un giorno della settimana arbitrario
        String day = "Monday";
        TriggerDayOfTheWeek instance = new TriggerDayOfTheWeek(day);
        // Il trigger dovrebbe restituire la stringa corretta
        String expResult = "Day of Week Trigger: Monday";
        String result = instance.triggerAttribute().get();
        assertEquals(expResult, result);
    }
    
}
