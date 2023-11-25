/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segruppo15.Actions;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
/**
 *
 * @author andrea
 */
public class AudioAction implements Action{
    private String filePath;
    public AudioAction(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void exec() {

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Player player = new Player(fileInputStream);
            //System.out.println("Riproduzione in corso: " + filePath);
            player.play();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (JavaLayerException ex) {
            Logger.getLogger(AudioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
