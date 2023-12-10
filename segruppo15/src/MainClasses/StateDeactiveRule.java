/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import java.io.Serializable;

/**
 *
 * @author tti_a
 */
public class StateDeactiveRule implements RuleState, Serializable{
    private Rule rule;

    public StateDeactiveRule(Rule rule) {
        this.rule = rule;
    }
    
    
    @Override
    public void fire() {
        //
    }

    @Override
    public void update() {
        //
    }
    
}
