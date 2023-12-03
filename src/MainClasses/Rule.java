/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClasses;

import Actions.*;
import Triggers.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class that implements single rules.
 * @author Marco
 */
public class Rule implements Serializable{
      private String name;
    private Trigger trigger;
    private Action action;
    private boolean isActive;
    private EnumActivityType activityType;
    private LocalTime sleepTime; // in seconds
    private LocalTime lastFired; // Last time rule was fired
    
    /**
     * Constructor for Rule class
     * @param name: name of rule
     * @param trigger: trigger of rule
     * @param action: action to run when the trigger activates
     * @param activityType: type of the rule
     * @param sleepTime: sleepTime of rule (in seconds). Effective only if ActivityType is Sleep after Firing
     */
    public Rule(String name, Trigger trigger, Action action, EnumActivityType activityType, String sleepTime) {
        this.name = name;
        this.trigger = trigger;
        this.action = action;
        this.isActive = true;
        this.activityType = activityType;
        this.sleepTime = sleepConverter(sleepTime);
        this.lastFired = null;
    }
    /**
     * Method to get the activity type of the rule
     * @return EnumActivityType activityType
     */
    public EnumActivityType getActivityType() {
        return this.activityType;
    }
    /**
     * Method to set the ActivityType of a Rule according to EnumActivityType
     * @param act 
     */
    public void setActivityType(EnumActivityType act) {
        this.activityType = act;
    }
    /**
     * Method to check if rule is active or not
     * @return boolean isActive
     */
    public boolean isActive() {
        return this.isActive;
    }
    /**
     * Method to set active-ness of a Rule
     * @param b 
     */
    public void setActive(boolean b) {
        this.isActive = b;
    }
    /**
     * Method to get sleep time of rule
     * @return int sleepTime
     */
    public LocalTime getSleepTime() {
        return this.sleepTime;
    }
    /**
     * Method to set the sleepTime. Ineffective if ActivityType is not Sleep after Firing
     * @param st 
     */
    public void setSleepTime(String st) {
        this.sleepTime = sleepConverter(st);
    }
    public final LocalTime sleepConverter(String sleepTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(sleepTime,formatter);
    }
    /**
     * Method to check if rule should be sleeping or not
     */
    public void updateSleep() {
        // Return if is already active
        if (this.isActive() == true) return;
        
        // Return if rule activity isn't SLEEP_AFTER_FIRING
        if (this.getActivityType() != EnumActivityType.SLEEP_AFTER_FIRING) return;
        
        
        LocalTime lastF = this.lastFired;
        LocalTime sleep = this.getSleepTime();
        System.out.println("sono in update sleep, lastF: "+lastF+" sleep time: "+sleep);
        // Check if lastfired + sleeptime < now
        LocalTime sumTime = lastF.plusHours(sleep.getHour())
                                .plusMinutes(sleep.getMinute())
                                .plusSeconds(sleep.getSecond());
        
        this.isActive = !sumTime.isAfter(LocalTime.now());

    }
    /**
     * Method to check if rule trigger is verified
     * @return True if trigger is verified. False otherwise
     */
    public boolean verTrigger() {
        return this.trigger.isVerified();
    }
    /**
     * Method to fire rule. Updates last fired of the rule
     */
    public void fire() {
        this.action.exec();
        this.lastFired = LocalTime.now();
        // if fire once or sleep => become inactive
        if (this.getActivityType() != EnumActivityType.NORMAL_FIRING) {
            this.setActive(false);
        }
    }
    /**
     * Method that fires rule if:
     *  - rule is active
     *  - trigger is verified
     */
    public void checkAndRun() {
        
        this.updateSleep();
        if (this.isActive()){
            if (this.verTrigger()) {
                // Run rule
                this.fire();
            }
        }
    }
    /**
     * Method to get name of rule
     * @return name string
     */
    public String getName(){
        return this.name;
    }
    /**
     * Method to get trigger of rule
     * @return Trigger
     */
    public Trigger getTrigger(){
        return trigger;
    }
    /**
     * Method to get action of rule
     * @return Action
     */
    public Action getAction(){
        return action;
    }
    /**
     * Method to get string property of rule activeness
     * @return StringProperty
     */
    public StringProperty getActivity(){
        if(isActive){
            StringProperty p;
            p = new SimpleStringProperty("Attivata");
            return p;
        }else{
            StringProperty p;
            p = new SimpleStringProperty("Disattivata");
            return p;
        }
    }
}