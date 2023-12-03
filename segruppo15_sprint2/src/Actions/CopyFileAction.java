/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actions;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.swing.JOptionPane;

/**
 *
 * @author zappu
 */
public class CopyFileAction implements Action, Serializable {
    private String filePath12;

    public CopyFileAction(String filePath12) {
        this.filePath12=filePath12;
    }
    
    /**
     *
     * @throws IOException
     */
    @Override
    public void exec() {
        //path del file da trasferire e file della cartella destinazione concatenati in un'unica stringa
        String paths[] = filePath12.split("//"); 
        
        Path source = Paths.get(paths[0]); //path del file da trasferire
        Path dest = Paths.get(paths[1]); //path della cartella destinazione
        
        try {
            Files.copy(source, dest.resolve(source.getFileName()),StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(null, "File copiato");
        } catch (IOException ex) {
            Logger.getLogger(MoveFileAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public StringProperty actionAttribute() {
        String paths[] = filePath12.split("//");
        StringProperty p;
        p = new SimpleStringProperty("Copy file: " +paths[0]+" Directory: "+paths[1]);
        return p;
    }
    
}
