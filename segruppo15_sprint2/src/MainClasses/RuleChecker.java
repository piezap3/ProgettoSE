/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClasses;

import java.io.Serializable;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;

/**
 * Service for rule checking
 * @author Marco
 */
public class RuleChecker extends ScheduledService implements Serializable{
    private ObservableList<Rule> ruleList;
    TableView<Rule> tab;
    /**
     * Constructor
     * @param l list of type ObservableList of Rule
     * @param tab TableView of JavaFX
     */
    public RuleChecker(ObservableList<Rule> l,TableView<Rule> tab) {
        this.ruleList = l;
        this.tab = tab;
    }
    
    /**
     * Method to update list to check
     * @param l Observable list of rules
     */
    public void updateList(ObservableList<Rule> l) {
        this.ruleList = l;
    }

    // TASK. Needs to be with setperiod() and start()
    @Override
    protected Task createTask() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (Rule r : ruleList) {
                    r.checkAndRun();
                }
                tab.refresh();
                return null;
            }   
        };
    }

    
}
