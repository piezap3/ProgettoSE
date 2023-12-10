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
    
    /**
     * isVerified method for triggerTimeOfDay
     * @return 
     */
    @Override
    public boolean isVerified() {
        LocalTime currentTime = LocalTime.now();

    // Confronta direttamente this.time con l'orario corrente e verifica la differenza nei secondi
    long secondsDifference = java.time.Duration.between(this.time, currentTime).getSeconds();

    // Ritorna true se gli orari sono uguali o la differenza è entro 5 secondi
    return secondsDifference >= 0 && secondsDifference <= 5;
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
