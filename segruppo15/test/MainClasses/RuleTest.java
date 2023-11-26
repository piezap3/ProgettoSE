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
        // Creazione regola di test
        Trigger trigger = new TriggerTimeOfDay("12:56:00"); 
        Action action = new MessageAction("Aiuto"); 
        EnumActivityType activityType = EnumActivityType.SLEEP_AFTER_FIRING;
        String sleepTime = "00:00:10"; 
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
        assertFalse(rule.verTrigger()); 
    }

    @Test
    public void testFire() {
        // Testa l'esecuzione della regola
        rule.fire();
        
        assertFalse(rule.isActive());
    }
    
    @Test
    public void testCheckAndRun() {
        // Chiama il metood da testare
        rule.checkAndRun();
        // Verifia il comportamento corretto
        assertTrue(rule.isActive());
    }
}
