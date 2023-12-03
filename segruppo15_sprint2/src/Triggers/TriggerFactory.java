/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triggers;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Trigger Factory class
 * @author Marco
 */
public class TriggerFactory implements Serializable{
    /**
     * Method to create the right Trigger.
     * @param type type of Trigger
     * @param time time parameter of Trigger (Valid for:
     *      TimeOfDayTrigger: Time to active the Trigger
     * @return Trigger object. Null if invalid type
     */
    public static Trigger getTrigger(String type, String time) {
        switch(type) {
            case "TimeOfDay":
                // TIME OF DAY TRIGGER
                if (time == null) throw new IllegalArgumentException("Time is not specified!");
                return new TriggerTimeOfDay(time);
            case "DayOfMonth":
                if(time==null) throw new IllegalArgumentException("Day of the month is not specified!");
                return new TriggerDayOfMonth(time);
            case "DayOfWeek":
                if (time == null) throw new IllegalArgumentException("Day of the week is not specified!");
                return new TriggerDayOfTheWeek(time);
            case "Annual":
                if(time == null) throw new IllegalArgumentException("Date is not specified!");
                return new TriggerAnnual(time);
            default:
                return null;
        }
    }
}
