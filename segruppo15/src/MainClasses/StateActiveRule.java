/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import static MainClasses.EnumActivityType.FIRE_ONCE;
import static MainClasses.EnumActivityType.NORMAL_FIRING;
import static MainClasses.EnumActivityType.SLEEP_AFTER_FIRING;
import java.io.Serializable;
import java.time.LocalTime;

/**
 *
 * @author tti_a
 */
public class StateActiveRule implements RuleState, Serializable{
    private Rule rule;

    public StateActiveRule(Rule rule) {
        this.rule = rule;
    }
    
    
    @Override
    public void fire() {
        if(rule.getTrigger().isVerified()){
        System.out.println("eseguo la multiaction"+rule.getAction());
        rule.getAction().exec();
        
        rule.setLastFired(LocalTime.now());
         // if fire once or sleep => become inactive
        switch (rule.getActivityType()) {
            case FIRE_ONCE:
                rule.setState(new StateDeactiveRule(rule));
                break;
            case SLEEP_AFTER_FIRING:
                rule.setState(new StateSleepingState(rule));
                break;
            case NORMAL_FIRING:
                break;
            default:
                throw new AssertionError();
        }
        
       }
    }

    @Override
    public void update() {
        //
    }
    
}
