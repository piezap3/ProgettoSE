/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package MainClasses;

import static org.junit.Assert.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TableView;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author zappu
 */
public class RuleCheckerTest {
    private RuleChecker ruleChecker;
    private ObservableList<Rule> ruleList;
    private TableView<Rule> tableView;

    @Before
    public void setUp() {
        ruleList = FXCollections.observableArrayList();
        tableView = new TableView<>();
        ruleChecker = new RuleChecker(ruleList, tableView);
    }
    
    @BeforeClass
public static void setUpClass() {
    // Initialize JavaFX Toolkit
    new JFXPanel();
}

    @Test
    public void testUpdateList() {
        ObservableList<Rule> newList = FXCollections.observableArrayList(new Rule("Rule1", null, null, EnumActivityType.NORMAL_FIRING, "00:00:05"));
        ruleChecker.updateList(newList);
        assertEquals(newList, ruleChecker.getList());
    }

    @Test
    public void testCreateTask() {
        assertNotNull(ruleChecker.createTask());
    }
}
