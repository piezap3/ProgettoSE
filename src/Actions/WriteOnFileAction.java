/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.swing.JOptionPane;

/**
 * Write on file actions. Adds a String at the end of a specified text file
 * @author Marco
 */
public class WriteOnFileAction implements Action, Serializable{
    private String filePathAndStringToAppend; // Stringa contente la stringa da scrivere sul file concatenata al path del file stesso

    /**
     * Constructor
     * @param filePathAndStringToAppend
     */
    public WriteOnFileAction(String filePathAndStringToAppend) {
        this.filePathAndStringToAppend = filePathAndStringToAppend;
    }
    
    @Override
    public StringProperty actionAttribute() {
        String divStr[] = filePathAndStringToAppend.split("//");
        StringProperty p;
        p = new SimpleStringProperty("Write: "+divStr[1]+" On File: "+divStr[0]);
        return p;
    }

    @Override
    public void exec() {
        // Divisione della stringa passata in input all'azione
        String divStr[] = filePathAndStringToAppend.split("//");
        appendTextToFile(divStr[0],divStr[1]);
    }
    
    /**
     * Method to append a String to the end of a File
     * @param filePath text file
     * @param text String
     */
    public static void appendTextToFile(String filePath,String text) {
        // Controllo se il file è stato letto  correttamente
        if (!checkIfTextFile(filePath)) {
            System.out.println("Not a text file! File: "+filePath);
            return;
        }
        try {
            // Il file viene aperto in modalità "append", in modo da non sovrascrivere i possibili dati già presenti
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true));
            out.write(text);
            out.close();
            JOptionPane.showMessageDialog(null, "Stringa scritta");
        } catch (IOException ex) {
            System.out.println("Error opening file! Log:\n"+ex);
        }
    }
    /**
     * Method to check if a filePath is a text file. Checks if filePath ends in ".txt"
     * @param filePath
     * @return 
     */
    public static boolean checkIfTextFile(String filePath) {
        return filePath.endsWith(".txt");
    }

}
