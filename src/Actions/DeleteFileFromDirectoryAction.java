/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actions;

import java.io.File;
import java.io.Serializable;
import java.time.LocalTime;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.swing.JOptionPane;

/**
 *
 * @author tti_a
 * 
 * 
 * classe creata;
 * cambaire la factory; cambaire il contorller per l'aggiunta di questa azione;
 * cambiare combobox con l'aggiunta di questa azione (nell'initialize)
 * cambiare la funzione creaaddrule nel controller
 * cambiare scene builder per aggiunta del pulsante?
 * 
 */
public class DeleteFileFromDirectoryAction implements Action, Serializable{
    private String filePath;

    public DeleteFileFromDirectoryAction(String filePath) {
        this.filePath = filePath;
    }
    
    
    @Override
    public void exec() {
        File fileToDelete=new File(this.filePath);
        if(fileToDelete.exists()){
            if(fileToDelete.delete()){
                JOptionPane.showMessageDialog(null, "File cancellato");
            }
        }
    }

    @Override
    public StringProperty actionAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("Delete File Action: "+this.filePath);
        return p;
    }
    
}
