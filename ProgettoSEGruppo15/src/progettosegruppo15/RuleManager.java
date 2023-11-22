/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettosegruppo15;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that holds all methods to work with Rules
 * @author Marco
 */
public class RuleManager {
    private List<Rule> ruleList;
    
    /**
     * Class constructor. Returns with an empty list of Rules
     */
    public RuleManager() {
        this.ruleList = new ArrayList<>();
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
     * NOT IMPLEMENTED!!!!
     * Method to check if the rule should run the action
     * @return 
     */
    public int check() {
        return 0;
    }
    /**
     * Method to activate a Rule
     * @param r 
     */
    public void activate(Rule r) {
        int index = this.ruleList.indexOf(r);
        this.ruleList.get(index).setActive(true);
    }
    /**
     * Method to deactivate a Rule
     * @param r 
     */
    public void deactivate(Rule r) {
        int index = this.ruleList.indexOf(r);
        this.ruleList.get(index).setActive(false);
    }
}
