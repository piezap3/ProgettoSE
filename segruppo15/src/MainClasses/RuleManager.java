/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClasses;

import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class that holds all methods to work with Rules
 * @author Marco
 */

public class RuleManager implements Serializable{
    private static RuleManager instance;
    private ObservableList<Rule> ruleList;
    
    /**
     * Class constructor. Creates an empty observable list of Rules
     */
    private RuleManager() {
        this.ruleList = FXCollections.observableArrayList();
    }
    
    /**
     * The getInstance method is responsible for providing a unique instance of the RuleManager class using the Singleton pattern. 
     * @return RuleManager
     */
    public static synchronized RuleManager getInstance(){
        if(instance==null){
            instance=new RuleManager();
        }
        return instance;
    }
    
    /**
     * Method to add a Rule in the list
     * @param r 
     */
    public void add(Rule r) {
        this.ruleList.add(r);
    }
    /**
     * Method to remove a specific Rule from the list
     * @param r 
     */
    public void remove(Rule r) {
        this.ruleList.remove(r);
    }
    /**
     * Method to activate a Rule
     * @param r 
     */
    public void activate(Rule r) {
        int index = this.ruleList.indexOf(r);
        this.ruleList.get(index).setState(new StateActiveRule(r));
    }
    /**
     * Method to deactivate a Rule
     * @param r 
     */
    public void deactivate(Rule r) {
        int index = this.ruleList.indexOf(r);
        this.ruleList.get(index).setState(new StateDeactiveRule(r));
    }
    /**
     * Method to get list of rules
     * @return List of Rule
     */
    public ObservableList<Rule> getList() {
        return this.ruleList;
    }
    
    /**
     * Method to change the list pointer to manager
     * @param l new list
     * @return 1 if successful, -1 if not
     */
    public int loadList(ObservableList<Rule> l) {
        if (l.isEmpty()) return -1;
        this.ruleList = l;
        return 1;
    }
}
