/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.io.File;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author zappu
 */
public class TriggerFileSize implements Trigger {
    private String fileAndSize;
    private double size;
    private boolean onceTrigg = false;
    
    public TriggerFileSize(String fileAndSize) {
        this.fileAndSize=fileAndSize;
    }
    
    
    @Override
    public boolean isVerified() {
        String str[] = this.fileAndSize.split("//");
        
        File file = new File(str[0]);
        size = Double.parseDouble(str[1]);
        
        if(onceTrigg){
            return false;
        }
        try {
            if(file.length()<size){
                onceTrigg=true;
                return true;                
            }
            //return file.length() < size;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
            return false;
            }    
        return false;
    }
    
    
    
    @Override
    public StringProperty triggerAttribute(){
        String str[] = this.fileAndSize.split("//");
        File file = new File(str[0]);
        String nameFile = file.getName();
        StringProperty p;
        p = new SimpleStringProperty("Size of:" + nameFile +" < "+ str[1] +" byte");
        return p;
    }
}
