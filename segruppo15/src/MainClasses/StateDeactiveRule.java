/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import java.io.Serializable;

/**
 * Represents the deactivated state of a rule.
 *
 * @author tti_a
 */
public class StateDeactiveRule implements RuleState, Serializable{
    private Rule rule;

    /**
     * Constructor for the StateDeactiveState class.
     *
     * @param rule the rule associated with this sleeping state.
     */
    public StateDeactiveRule(Rule rule) {
        this.rule = rule;
    }
    
    /**
     * In this state, the rule is not eligible for updates, so the method is empty.
     */
    @Override
    public void fire() {
        //
    }
    
    /**
     * In this state, the rule is not eligible for updates, so the method is empty.
     */
    @Override
    public void update() {
        //
    }
    
}
