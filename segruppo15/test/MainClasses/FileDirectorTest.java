/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package MainClasses;

import Actions.*;
import Triggers.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileDirectorTest {

    private FileDirector fileDirector;
    private ObservableList<Rule> ruleList;

    @Before
    public void setUp() {
        fileDirector = new FileDirector();
        ruleList = FXCollections.observableArrayList();
    }

    @Test
    public void testSaveAndLoadRules() {
        // Aggiungi alcune regole alla lista per il test
        Rule rule1 = new Rule("Rule1", new TriggerTimeOfDay("12:12:12"), new MessageAction("Prova"), EnumActivityType.NORMAL_FIRING, "00:00:00");
        Rule rule2 = new Rule("Rule2", new TriggerTimeOfDay("14:42:56"), new MessageAction("Prova2"), EnumActivityType.NORMAL_FIRING, "00:00:00");

        ruleList.add(rule1);
        ruleList.add(rule2);

        // Salva le regole in un file
        fileDirector.saveRules(ruleList);

        // Carica le regole da un file
        ObservableList<Rule> loadedRules = fileDirector.loadRules();

        // Verifica che le regole caricate siano identiche a quelle salvate
        assertEquals(ruleList.size(), loadedRules.size());

        for (int i = 0; i < ruleList.size(); i++) {
            Rule originalRule = ruleList.get(i);
            Rule loadedRule = loadedRules.get(i);

            assertEquals(originalRule.getName(), loadedRule.getName());
            assertEquals(originalRule.getActivityType(), loadedRule.getActivityType());
            assertEquals(originalRule.isActive(), loadedRule.isActive());
            assertEquals(originalRule.getSleepTime(), loadedRule.getSleepTime());
            // Aggiungi ulteriori asserzioni in base alle proprietà della tua classe Rule
        }
    }
}
