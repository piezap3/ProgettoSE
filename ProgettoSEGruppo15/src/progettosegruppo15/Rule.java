/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettosegruppo15;

/**
 * Class that implements single rules.
 * @author Marco
 */
public class Rule {
    private Trigger trigger;
    private Action action;
    private boolean isActive;
    private EnumActivityType activityType;
    private int sleepTime; // in seconds

    /**
     * Constructor for Rule class
     * @param trigger: trigger of rule
     * @param action: action to run when the trigger activates
     * @param activityType: type of the rule
     * @param sleepTime: sleepTime of rule (in seconds). Effective only if ActivityType is Sleep after Firing
     */
    public Rule(Trigger trigger, Action action, EnumActivityType activityType, int sleepTime) {
        this.trigger = trigger;
        this.action = action;
        this.isActive = true;
        this.activityType = activityType;
        this.sleepTime = sleepTime;
    }
    /**
     * Method to set the ActivityType of a Rule according to EnumActivityType
     * @param act 
     */
    public void setActivityType(EnumActivityType act) {
        this.activityType = act;
    }
    /**
     * Method to set active-ness of a Rule
     * @param b 
     */
    public void setActive(boolean b) {
        this.isActive = b;
    }
    /**
     * Method to set the sleepTime. Ineffective if ActivityType is not Sleep after Firing
     * @param st 
     */
    public void setSleepTime(int st) {
        this.sleepTime = st;
    }
}
