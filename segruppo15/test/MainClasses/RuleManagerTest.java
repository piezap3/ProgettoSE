/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClasses;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class RuleManagerTest {
    
    public RuleManagerTest() {
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
     * Test of getInstance method (class RuleManager).
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        // Verifica che il metodo restituisca sempre la stessa istanza di RuleManager
        RuleManager expResult = RuleManager.getInstance();
        RuleManager result = RuleManager.getInstance();
        assertSame(expResult, result);
    }

    /**
     * Test of add method (class RuleManager).
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        // Crea una regola di prova
        Rule r = new Rule("test", null, null, null, "00:00:00");
        // Aggiunge la regola alla lista di RuleManager
        RuleManager instance = RuleManager.getInstance();
        instance.add(r);
        // Verifica che la lista contenga la regola aggiunta
        assertTrue(instance.getList().contains(r));
    }

    /**
     * Test of remove method, of class RuleManager.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        // Crea una regola di prova
        Rule r = new Rule("test", null, null, null, "00:00:00");
        // Aggiunge la regola alla lista di RuleManager
        RuleManager instance = RuleManager.getInstance();
        instance.add(r);
        // Rimuove la regola dalla lista di RuleManager
        instance.remove(r);
        // Verifica che la lista non contenga più la regola rimossa
        assertFalse(instance.getList().contains(r));
    }

    /**
     * Test of activate method, of class RuleManager.
     */
    @Test
    public void testActivate() {
        System.out.println("activate");
        // Crea una regola di prova non attiva
        Rule r = new Rule("test", null, null, null, "00:00:00");
        // Aggiunge la regola alla lista di RuleManager
        RuleManager instance = RuleManager.getInstance();
        instance.add(r);
        // Attiva la regola
        instance.activate(r);
        // Verifica che la regola sia attiva
        assertTrue(r.isActive());
    }

    /**
     * Test of deactivate method, of class RuleManager.
     */
    @Test
    public void testDeactivate() {
        System.out.println("deactivate");
        // Crea una regola di prova attiva
        Rule r = new Rule("test", null, null, null, "00:00:00");
        // Aggiunge la regola alla lista di RuleManager
        RuleManager instance = RuleManager.getInstance();
        instance.add(r);
        // Disattiva la regola
        instance.deactivate(r);
        // Verifica che la regola non sia più attiva
        assertFalse(r.isActive());
    }

    /**
     * Test of getList method, of class RuleManager.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        // Crea una lista di regole di prova
        List<Rule> testList = new ArrayList<>();
        testList.add(new Rule("test1", null, null, null, "00:00:00"));
        testList.add(new Rule("test2", null, null, null, "00:00:00"));
        testList.add(new Rule("test3", null, null, null, "00:00:00"));
        // Aggiunge le regole alla lista di RuleManager
        RuleManager instance = RuleManager.getInstance();
        for (Rule r : testList) {
            instance.add(r);
        }
        // Verifica che la lista di RuleManager sia uguale alla lista di prova
        ObservableList<Rule> expResult = FXCollections.observableArrayList(testList);
        ObservableList<Rule> result = instance.getList();
        assertEquals(expResult, result);
    }

    /**
     * Test of loadList method, of class RuleManager.
     */
    @Test
    public void testLoadList() {
        System.out.println("loadList");
        // Crea una lista di regole di prova
        ObservableList<Rule> l = FXCollections.observableArrayList();
        l.add(new Rule("test1", null, null, null, "00:00:00"));
        l.add(new Rule("test2", null, null, null, "00:00:00"));
        l.add(new Rule("test3", null, null, null, "00:00:00"));
        // Cambia il puntatore della lista di RuleManager alla lista di prova
        RuleManager instance = RuleManager.getInstance();
        int expResult = 1;
        int result = instance.loadList(l);
        // Verifica che il metodo restituisca 1 in caso di successo
        assertEquals(expResult, result);
        // Verifica che la lista di RuleManager sia uguale alla lista di prova
        assertEquals(l, instance.getList());
    }
    
}
