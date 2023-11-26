/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package MainClasses;


import Actions.*;
import MainClasses.*;
import Triggers.*;
import java.time.LocalTime;
import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class RuleTest {

    private Rule rule;

    @Before
    public void setUp() {
        // Create a sample rule for testing
        Trigger trigger = new TriggerTimeOfDay("12:56:00"); // Assumi che SampleTrigger implementi l'interfaccia Trigger
        Action action = new MessageAction("Aiuto"); // Assumi che SampleAction implementi l'interfaccia Action
        EnumActivityType activityType = EnumActivityType.SLEEP_AFTER_FIRING;
        String sleepTime = "00:00:10"; // 10 secondi di tempo di attesa
        rule = new Rule("TestRule", trigger, action, activityType, sleepTime);
        
    }
       
    @Test
    public void testRuleInitialization() {
        // Verifica che la regola sia inizializzata correttamente
        assertNotNull(rule);
        assertEquals("TestRule", rule.getName());
        assertEquals(EnumActivityType.SLEEP_AFTER_FIRING, rule.getActivityType());
        assertTrue(rule.isActive());
        assertNotNull(rule.getSleepTime());
        //assertNull(rule.getLastFired());
    }
    
    @Test
    public void testSetActive() {
        // Testa l'impostazione dello stato attivo della regola
        assertTrue(rule.isActive());
        rule.setActive(false);
        assertFalse(rule.isActive());
        rule.setActive(true);
        assertTrue(rule.isActive());
    }

    @Test
    public void testSetSleepTime() {
        // Testa l'impostazione del tempo di attesa della regola
        assertEquals(LocalTime.parse("00:00:10"), rule.getSleepTime());
        rule.setSleepTime("00:00:20");
        assertEquals(LocalTime.parse("00:00:20"), rule.getSleepTime());
    }

    @Test
    public void testVerTrigger() {
        // Testa la verifica del trigger della regola
        assertFalse(rule.verTrigger()); // Si presume che il trigger non sia verificato inizialmente
        // Potrebbe essere necessario fornire un'implementazione specifica del trigger per il tuo sistema
        // e aggiornare questo test di conseguenza.
    }

    @Test
    public void testFire() {
        // Testa l'esecuzione della regola
        rule.fire();
        //assertNotNull(rule.getLastFired());
        assertFalse(rule.isActive()); // Si presume che diventi inattivo dopo l'esecuzione
    }
    
    @Test
    public void testCheckAndRun() {
        // Create an instance of the class to be tested
        Rule rule = new Rule("Test rule", new TriggerTimeOfDay("12:56:00"), new MessageAction("Aiuto"), EnumActivityType.FIRE_ONCE,"00:00:10");
        // Call the method to be tested
        rule.checkAndRun();
        // Verify that the expected behavior occurred
        assertTrue(rule.isActive());
    }
}
