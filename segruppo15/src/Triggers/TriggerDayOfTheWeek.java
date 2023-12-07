/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mattiiaaa
 */
public class TriggerDayOfTheWeek implements Trigger, Serializable{
    private String day;
    private Boolean active=true; //booleano per far attivare una sola volta il trigger in quel giorno della settimana

    public TriggerDayOfTheWeek(String day) {
        this.day = day;
    }

    @Override
    public boolean isVerified() {
        String dayString = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        isRightDay();
        if(this.active){
            active=false;
            return day.equals(dayString);
        }
        return false;
    }

    @Override
    public StringProperty triggerAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("Day of Week Trigger: "+this.day);
        return p;
    }
    
    //funzione per attivare active solo quando this.day è diverso dal giorno attuale
    private void isRightDay(){
        if(!this.day.equals(LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH))){
            this.active=true;
        }
    } 

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    
}
