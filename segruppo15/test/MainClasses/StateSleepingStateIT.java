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
public class StateSleepingStateIT {
     // Dichiaro alcune variabili che userò nei test
    private Rule instance; // La regola associata allo stato
    private Trigger trigger; // Il trigger della regola
    private Action action; // L'azione della regola
    private EnumActivityType activityType; // Il tipo di attività della regola
    private String sleepTime; // Il tempo di riposo della regola
    
    
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
        activityType = EnumActivityType.SLEEP_AFTER_FIRING; // Assegno un valore al tipo di attività
        sleepTime = "00:00:00"; // Assegno un valore al tempo di riposo
        instance = new Rule("TestRule", trigger, action, activityType, sleepTime); // Creo la regola da associare allo stato
    }
    @After
    public void tearDown() {
    }

    /**
     * Test of fire method, of class StateActiveRule.
     */
    @Test
    public void testFire() {
        System.out.println("fire");
        instance.setState(new StateSleepingState(instance));
        //eseguo fire ma non deve succedere nulla
        instance.getState().fire();
        //se siamo arrivati a questo punto, consideriamo il test superato
        assertTrue(true);
    }
    
    /**
     * Test of update method, of class StateSleepingState.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        instance.setState(new StateSleepingState(instance));
        //setto lastFired della regola a 00:00:00
        instance.setLastFired(LocalTime.of(0, 0, 0));
        //la regola deve riposare per 00:00:10 e attivarsi successivamente
        instance.setSleepTime("00:00:10");
        //eseguo l'update 
        instance.updateSleep();
        
        boolean expres=true;
        //controllo che lo state della regola sia stateActiveRule
        boolean res=instance.getState()instanceof StateActiveRule;
        
        assertEquals(expres, res);
    }
    
}
