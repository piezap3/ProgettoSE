/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segruppo15.Actions;

import javax.swing.JOptionPane;

/**
 * Action to show message
 * @author tti_a
 */
public class MessageAction implements Action{
    private final String message;

    /**
     * Constructor
     * @param message: message to print
     */
    public MessageAction(String message) {
        this.message = message;
    }
    /**
     * Perform action
     */
    @Override
    public void exec() {
        JOptionPane.showMessageDialog(null, message);
    }
    
}
