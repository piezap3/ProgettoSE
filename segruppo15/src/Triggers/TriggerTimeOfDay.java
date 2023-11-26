/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * Trigger Time Of Day
 * @author zappu
 */
public class TriggerTimeOfDay implements Trigger, Serializable{
    private LocalTime time; 
    
    /**
     * Constructor
     * @param t string from JavaFX to convert to LocalTime
     */
    public TriggerTimeOfDay(String t) {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Convertire la stringa in un oggetto LocalTime
        LocalTime tim = LocalTime.parse(t, formatter);
        this.time=tim;
    }
    
    @Override
    public boolean isVerified() {
        int hour = this.time.getHour();
        int min = this.time.getMinute();
        int sec = this.time.getSecond();
        int secRange = 5;
        //System.out.println("This: "+this.time.toString()+"  Now: "+LocalTime.now().toString());
        if ((LocalTime.now().getHour()==hour) && (LocalTime.now().getMinute()==min)) {
            int secDifference = LocalTime.now().getSecond()-sec; // Secondi di ora - secondi memorizzati
            if ((secDifference > 0) && (secDifference < secRange))
                return true;
        }
        return false;
    }    

    /**
     * String Property to show in JavaFX Tab
     * @return String Property
     */
    @Override
    public StringProperty triggerAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("Time Trigger: "+this.time);
        return p;
    }
    
}
