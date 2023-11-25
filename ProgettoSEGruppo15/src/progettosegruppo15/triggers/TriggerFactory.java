/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segruppo15.Triggers;

import java.time.LocalTime;

/**
 * Trigger Factory class
 * @author Marco
 */
public class TriggerFactory {
    public static Trigger getTrigger(String type, LocalTime time) {
        switch(type) {
            case "TimeOfDay":
                // TIME OF DAY TRIGGER
                if (time == null) throw new IllegalArgumentException("time is not specified!");
                return new TriggerTimeOfDay(time);
            default:
                return null;
        }
    }
}
