/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actions;

import java.io.Serializable;
import java.time.LocalTime;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.swing.JOptionPane;

/**
 * Message Action. Prints a message on screen
 * @author andrea
 */
public class MessageAction implements Action, Serializable{
    private final String message;
    
    /**
     * Constructor
     * @param message to print on screen 
     */
    public MessageAction(String message) {
        this.message = message;
    }
    
    @Override
    public void exec() {
        JOptionPane.showMessageDialog(null, "MessageTrigger!\n"+message+"\n"+LocalTime.now().toString());
    }

    /**
     * String Property to show in JavaFX Tab
     * @return String Property
     */
    @Override
    public StringProperty actionAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("Message Action: "+this.message);
        return p;
    }
    
}
