/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triggers;

import java.time.LocalTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mattiiaaa
 */
public class TriggerFactoryTest {
    
    public TriggerFactoryTest() {
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
     * Test of getTrigger method, of class TriggerFactory.
     */
    @Test
    public void testGetTrigger() {
        System.out.println("getTrigger");
        // Testa la creazione di diversi trigger con parametri validi
        String type = "TimeOfDay";
        String time = "12:00:00";
        Trigger expResult = new TriggerTimeOfDay(time);
        Trigger result = TriggerFactory.getTrigger(type, time);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.triggerAttribute().toString(), result.triggerAttribute().toString());
        
        type = "DayOfMonth";
        time = "15";
        expResult = new TriggerDayOfMonth(time);
        result = TriggerFactory.getTrigger(type, time);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.triggerAttribute().toString(), result.triggerAttribute().toString());
        
        type = "DayOfWeek";
        time = "Monday";
        expResult = new TriggerDayOfTheWeek(time);
        result = TriggerFactory.getTrigger(type, time);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.triggerAttribute().toString(), result.triggerAttribute().toString());
        
        type = "Annual";
        time = "2023-12-01";
        expResult = new TriggerAnnual(time);
        result = TriggerFactory.getTrigger(type, time);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.triggerAttribute().toString(), result.triggerAttribute().toString());
        
        type = "ExternalProgram";
        time = "lib//test.py//python//2 3//5";
        expResult = new ExternalProgramTrigger(time);
        result = TriggerFactory.getTrigger(type, time);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.triggerAttribute().toString(), result.triggerAttribute().toString());
        
        type = "FileExistence";
        time = "lib//test.txt";
        expResult = new TriggerFileExistence(time);
        result = TriggerFactory.getTrigger(type, time);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.triggerAttribute().toString(), result.triggerAttribute().toString());
        
        type = "FileSize";
        time = "lib\\test.txt//100";
        expResult = new TriggerFileSize(time);
        result = TriggerFactory.getTrigger(type, time);
        assertEquals(expResult.triggerAttribute().toString(), result.triggerAttribute().toString());
        
        // Testa la creazione di un trigger con un tipo non valido
        type = "Invalid";
        time = "test";
        expResult = null;
        result = TriggerFactory.getTrigger(type, time);
        assertEquals(expResult, result);
    }
    
}
