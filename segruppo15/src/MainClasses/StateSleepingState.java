/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Represents the sleeping state of a rule.
 *
 * @author tti_a
 */
public class StateSleepingState implements RuleState, Serializable{
    private Rule rule;

    /**
     * Constructor for the StateSleepingState class.
     *
     * @param rule the rule associated with this sleeping state.
     */
    public StateSleepingState(Rule rule) {
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
     * Checks if the rule should transition to the active state based on the sleep time.
     */
    @Override
    public void update() {
        // Ottiene l'ora dell'ultima esecuzione della regola
        LocalTime lastFired = rule.getLastFired();
        // Ottiene il tempo di pausa della regola
        LocalTime sleepTime = rule.getSleepTime();
        
        // controlla se lastfired + sleeptime < now
        LocalTime wakeupTime = lastFired.plusHours(sleepTime.getHour())
                                .plusMinutes(sleepTime.getMinute())
                                .plusSeconds(sleepTime.getSecond());
        
        if (LocalTime.now().isAfter(wakeupTime)) {
            rule.setState(new StateActiveRule(rule));
        }
    }
    
}
