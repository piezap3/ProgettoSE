/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Triggers;

import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tti_a
 */
public class TriggerTimeOfDayIT {
    
    public TriggerTimeOfDayIT() {
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
     * Test of isVerified method, of class TriggerTimeOfDay.
     */
    @Test
    public void testIsVerified() {
        System.out.println("isVerified");
        Trigger instance = TriggerFactory.getTrigger("TimeOfDay", "00:00:00");
        boolean expResult = false;
        boolean result = instance.isVerified();
        assertEquals(expResult, result);
    }

    /**
     * Test of triggerAttribute method, of class TriggerTimeOfDay.
     */
    @Test
    public void testTriggerAttribute() {
        System.out.println("triggerAttribute");
        Trigger instance = TriggerFactory.getTrigger("TimeOfDay", "00:00:00");
        String expResult = "Time Trigger: 00:00";
        StringProperty r = instance.triggerAttribute();
        String result = r.get();
        assertEquals(expResult, result);
    }
    
}
