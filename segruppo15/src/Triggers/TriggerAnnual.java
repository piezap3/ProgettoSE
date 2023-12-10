/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author zappu
 */
public class TriggerAnnual implements Trigger {
    private LocalDate date;
    private LocalDate lastVerified; // aggiungo questo attributo per memorizzare l'ultimo giorno in cui il trigger è stato verificato
    private Boolean active=true;//booleano per far attivare una sola volta il trigger in quel giorno dell'anno
    
    /**
     * Constructor
     * @param t String with date
     */
    public TriggerAnnual(String t) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate dat = LocalDate.parse(t, formatter);
        this.date=dat;
        this.lastVerified = LocalDate.MIN; // inizializzo questo attributo con una data minima
    }

    /**
     * isVerified method for triggerAnnual
     * @return 
     */
    @Override
    public boolean isVerified() {
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        isRightDate();
        if(this.active){
            this.active=false;
            // aggiorno l'ultimo giorno in cui il trigger è stato verificato con la data attuale
            this.lastVerified = LocalDate.now();
            return (LocalDate.now().getDayOfMonth())==day && (LocalDate.now().getMonthValue())==month && (LocalDate.now()).getYear()>=year;
        }
        return false;
    }

    @Override
    public StringProperty triggerAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("Annual Trigger: "+this.date);
        return p;
    }
    
    //funzione per attivare active solo quando la data attuale è diversa dall'ultimo giorno in cui il trigger è stato verificato
    private void isRightDate(){
        if(!LocalDate.now().isEqual(this.lastVerified)){
            this.active=true;
        }
    } 
    
}
