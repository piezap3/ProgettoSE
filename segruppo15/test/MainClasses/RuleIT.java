/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package MainClasses;

import Actions.Action;
import Actions.MessageAction;
import Triggers.Trigger;
import Triggers.TriggerDayOfMonth;
import java.time.LocalTime;
import javafx.beans.property.SimpleStringProperty;
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
public class RuleIT {
    
    // Dichiaro alcune variabili che userò nei test
    private Rule instance; // La regola da testare
    private Trigger trigger; // Il trigger della regola
    private Action action; // L'azione della regola
    private EnumActivityType activityType; // Il tipo di attività della regola
    private String sleepTime; // Il tempo di riposo della regola
    
    public RuleIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        trigger = new TriggerDayOfMonth("10"); // Creo un oggetto Trigger (dovresti implementare questa classe)
        action = new MessageAction("ciao"); // Creo un oggetto Action (dovresti implementare questa classe)
        activityType = EnumActivityType.NORMAL_FIRING; // Assegno un valore al tipo di attività
        sleepTime = "00:00:00"; // Assegno un valore al tempo di riposo
        instance = new Rule("TestRule", trigger, action, activityType, sleepTime);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getActivityType method, of class Rule.
     */
    @Test
    public void testGetActivityType() {
        System.out.println("getActivityType");
        EnumActivityType expResult = EnumActivityType.NORMAL_FIRING;
        EnumActivityType result = instance.getActivityType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastFired method, of class Rule.
     */
    @Test
    public void testSetLastFired() {
        System.out.println("setLastFired");
        LocalTime lastFired = LocalTime.now();
        instance.setLastFired(lastFired);
    }

    /**
     * Test of getLastFired method, of class Rule.
     */
    @Test
    public void testGetLastFired() {
        System.out.println("getLastFired");
        LocalTime lastFired = LocalTime.of(10, 00, 00);
        instance.setLastFired(lastFired);
        
        LocalTime expResult = LocalTime.of(10, 00, 00);;
        LocalTime result = instance.getLastFired();
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class Rule.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        //cambio lo stato della regola da active a deactive
        RuleState state = new StateDeactiveRule(instance);
        instance.setState(state);
        //se instance.getState è istanza di stateDeactive possiamo ritenere il test superato
        assertTrue(instance.getState()instanceof StateDeactiveRule);
    }

    /**
     * Test of getState method, of class Rule.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        RuleState expResult = new StateActiveRule(instance);
        RuleState result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActivityType method, of class Rule.
     */
    @Test
    public void testSetActivityType() {
        System.out.println("setActivityType");
        EnumActivityType act = EnumActivityType.FIRE_ONCE;
        instance.setActivityType(act);
        assertEquals(act, instance.getActivityType());
    }

    /**
     * Test of isActive method, of class Rule.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        boolean expResult = true;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSleepTime method, of class Rule.
     */
    @Test
    public void testGetSleepTime() {
        System.out.println("getSleepTime");
        LocalTime expResult = LocalTime.of(00, 00, 00);
        LocalTime result = instance.getSleepTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSleepTime method, of class Rule.
     */
    @Test
    public void testSetSleepTime() {
        System.out.println("setSleepTime");
        String st = "00:00:10";
        instance.setSleepTime(st);
        assertEquals(st, instance.getSleepTime().toString());
    }

    /**
     * Test of sleepConverter method, of class Rule.
     */
    @Test
    public void testSleepConverter() {
        System.out.println("sleepConverter");
        String sleepTime = "00:00:10";
        LocalTime expResult = LocalTime.of(0, 0, 10);
        LocalTime result = instance.sleepConverter(sleepTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateSleep method, of class Rule.
     */
    @Test
    public void testUpdateSleep() {
        System.out.println("updateSleep");
        instance.updateSleep();
    }

    /**
     * Test of fire method, of class Rule.
     */
    @Test
    public void testFire() {
        System.out.println("fire");
        instance.fire();
    }

    /**
     * Test of getName method, of class Rule.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "TestRule";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTrigger method, of class Rule.
     */
    @Test
    public void testGetTrigger() {
        System.out.println("getTrigger");
        Trigger expResult = trigger;
        Trigger result = instance.getTrigger();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAction method, of class Rule.
     */
    @Test
    public void testGetAction() {
        System.out.println("getAction");
        Action expResult = action;
        Action result = instance.getAction();
        assertEquals(expResult, result);
    }

    /**
     * Test of getActivity method, of class Rule.
     */
    @Test
    public void testGetActivity() {
        System.out.println("getActivity");
        String stringValue = "Attivata";
        StringProperty expResult = new SimpleStringProperty(stringValue);
        StringProperty result = instance.getActivity();
        assertEquals(expResult.toString(), result.toString());
    }
    
}
