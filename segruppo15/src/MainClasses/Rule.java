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
    private EnumActivityType activityType;
    private LocalTime sleepTime; // in seconds
    private LocalTime lastFired; // Last time rule was fired
    private RuleState state;
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
        this.activityType = activityType;
        this.sleepTime = sleepConverter(sleepTime);
        this.lastFired = null;
        this.state= new StateActiveRule(this);
    }
    /**
     * Method to get the activity type of the rule
     * @return EnumActivityType activityType
     */
    public EnumActivityType getActivityType() {
        return this.activityType;
    }
    /**
     * Method to set the last fired of the rule 
     * @param lastFired
     */
    public void setLastFired(LocalTime lastFired) {
        this.lastFired = lastFired;
    }
    
    /**
     * Method to get the last fired of the rule
     * @return LocalTime lastFired
     */
    public LocalTime getLastFired() {
        return lastFired;
    }
    
    /**
     * Method to set the state of the rule 
     * @param state
     */
    public void setState(RuleState state) {
        this.state = state;
    }
    
    /**
     * Method to get the state of the rule
     * @return RuleState state
     */
    public RuleState getState() {
        return state;
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
        // Se lo stato della regola è ActiveState, restituisce true
          return this.state instanceof StateActiveRule;
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
    
    /**
    * Converts a string representation of sleep time into a LocalTime object.
    *
    * @param sleepTime a string representing sleep time in "HH:mm:ss" format.
    * @return the LocalTime representation of the input sleep time.
    */
    public final LocalTime sleepConverter(String sleepTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(sleepTime,formatter);
    }
    
    /**
     * Method to check if rule should be sleeping or not
     */
    public void updateSleep() {
        state.update();
    }
    /**
     * Method to fire rule. Updates last fired of the rule
     */
    public void fire() {
        state.fire();
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
        if(isActive()){
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