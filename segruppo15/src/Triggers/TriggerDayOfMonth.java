/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mattiiaaa
 */
public class TriggerDayOfMonth implements Trigger, Serializable{
    private int dayOfMonth;
    private int i=0;
    private int month=LocalDate.now().getMonthValue();
    
    /**
     * Constructor
     * @param t String with day of the month 
     */
    public TriggerDayOfMonth(String t){
        this.dayOfMonth = Integer.parseInt(t); //from string to int
    }

    /**
     * isVerified method for triggerDayOfMonth
     * @return 
     */
    @Override
    public boolean isVerified() {
        LocalDate currentDate = LocalDate.now();
        // verify that dayofmonth is equal to currentdayofmonth
        isRightMonth();
        if(this.i==0){
        this.i++;
        return currentDate.getDayOfMonth() == dayOfMonth;
        }else{
            return false;
        }
    }

    @Override
    public StringProperty triggerAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("day of month Trigger: "+this.dayOfMonth);
        return p;
    }
    
    private void isRightMonth(){
        if(LocalDate.now().getMonthValue()>this.month || (LocalDate.now().getMonthValue()==1 && this.month==12)){
            this.i=0;
        }
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getI() {
        return i;
    }

    public int getMonth() {
        return month;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    
    
}
