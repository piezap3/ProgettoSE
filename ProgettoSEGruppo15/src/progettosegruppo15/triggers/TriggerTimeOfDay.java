/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segruppo15.Triggers;
import java.time.LocalTime;
/**
 * Trigger that is verified after specified time of day
 * @author tti_a
 */
public class TriggerTimeOfDay implements Trigger{
    private LocalTime time; //utente

    /**
     * Constructor
     * @param time: time to fire in LocalTime 
     */
    public TriggerTimeOfDay(LocalTime time) {
        this.time=time;
    }
    
    /**
     * Method that checks if trigger is verified
     * @return True if trigger is verified. False otherwise
     */
    @Override
    public boolean isVerified() {
        LocalTime current=LocalTime.now();
        return this.time.isAfter(current);
    }    
}
