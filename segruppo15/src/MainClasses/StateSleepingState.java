/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import java.io.Serializable;
import java.time.LocalTime;

/**
 *
 * @author tti_a
 */
public class StateSleepingState implements RuleState, Serializable{
    private Rule rule;

    public StateSleepingState(Rule rule) {
        this.rule = rule;
    }
    
    
    @Override
    public void fire() {
        //
    }

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
