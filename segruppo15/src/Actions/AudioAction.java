/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actions;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
/**
 * Audio action: reproduces audio file
 * @author andrea
 */
public class AudioAction implements Action, Serializable{
    private String filePath;
    
    /**
     * Constructor
     * @param filePath String with filePath to reproduce
     */
    public AudioAction(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * play audio file 
     */
    @Override
    public void exec() {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Player player = new Player(fileInputStream);
            //System.out.println("Riproduzione in corso: " + filePath);
            player.play();
            JOptionPane.showMessageDialog(null, "File audio in esecuzione");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (JavaLayerException ex) {
            Logger.getLogger(AudioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * String Property to show in JavaFX Tab
     * @return String Property
     */
    @Override
    public StringProperty actionAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("Audio Action. File: "+this.filePath);
        return p;
    }

    
    
    
}
