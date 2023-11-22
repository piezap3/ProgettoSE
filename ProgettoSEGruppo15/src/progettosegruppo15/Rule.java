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
    private EnumActivityType activityType;
    private int sleepTime; // in seconds

    /**
     * Constructor for Rule class
     * @param trigger: trigger of rule
     * @param action: action to run when the trigger activates
     * @param activityType: type of the rule
     * @param sleepTime: sleepTime of rule (in seconds)
     */
    public Rule(Trigger trigger, Action action, EnumActivityType activityType, int sleepTime) {
        this.trigger = trigger;
        this.action = action;
        this.activityType = activityType;
        this.sleepTime = sleepTime;
    }
}
