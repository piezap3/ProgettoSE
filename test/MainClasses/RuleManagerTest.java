package MainClasses;

import org.junit.Test;
import static org.junit.Assert.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Test class for RuleManager
 */
public class RuleManagerTest {

    @Test
    public void testConstructor() {
        // create a rule manager with the list
        RuleManager manager = new RuleManager();
        // check if the manager is not null
        assertNotNull(manager);
        // check if the manager has the same list
        assertSame(manager.getList(), manager.getList());
    }

    @Test
    public void testAdd() {
        // create a rule manager with the list
        RuleManager manager = new RuleManager();
        // create a sample rule
        Rule rule = new Rule("Test rule", null, null, EnumActivityType.NORMAL_FIRING, "00:00:00");
        // add the rule to the manager
        manager.add(rule);
        // check if the list contains the rule
        assertTrue(manager.getList().contains(rule));
    }

    @Test
    public void testRemove() {
        // create a rule manager with the list
        RuleManager manager = new RuleManager();
        // create a sample rule
        Rule rule = new Rule("Test rule", null, null, EnumActivityType.NORMAL_FIRING, "00:00:00");
        // add the rule to the manager
        manager.add(rule);
        // remove the rule from the manager
        manager.remove(rule);
        // check if the list does not contain the rule
        assertFalse(manager.getList().contains(rule));
    }

    @Test
    public void testActivate() {
        // create a rule manager with the list
        RuleManager manager = new RuleManager();
        // create a sample rule
        Rule rule = new Rule("Test rule", null, null, EnumActivityType.NORMAL_FIRING, "00:00:00");
        // add the rule to the manager
        manager.add(rule);
        // activate the rule
        manager.activate(rule);
        // check if the rule is active
        assertTrue(rule.isActive());
    }

    @Test
    public void testDeactivate() {
        // create a rule manager with the list
        RuleManager manager = new RuleManager();
        // create a sample rule
        Rule rule = new Rule("Test rule", null, null, EnumActivityType.NORMAL_FIRING, "00:00:00");
        // add the rule to the manager
        manager.add(rule);
        // deactivate the rule
        manager.deactivate(rule);
        // check if the rule is not active
        assertFalse(rule.isActive());
    }

    @Test
    public void testLoadList() {
        // create a rule manager with the list
        RuleManager manager = new RuleManager();
        // create another observable list of rules
        ObservableList<Rule> list2 = FXCollections.observableArrayList();
        // create a sample rule
        Rule rule = new Rule("Test rule", null, null, EnumActivityType.NORMAL_FIRING, "00:00:00");
        // add the rule to the second list
        list2.add(rule);
        // load the second list to the manager
        manager.loadList(list2);
        // check if the manager has the second list
        assertSame(list2, manager.getList());
    }
}
