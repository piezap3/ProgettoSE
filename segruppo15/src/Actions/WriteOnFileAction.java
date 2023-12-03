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

/**
 * Write on file actions. Adds a String at the end of a specified text file
 * @author Marco
 */
public class WriteOnFileAction implements Action, Serializable{
    private final String filePath;
    private final String toWrite;

    /**
     * Constructor
     * @param filePath text file
     * @param toWrite String to add at the end of text file
     */
    public WriteOnFileAction(String filePath, String toWrite) {
        this.filePath = filePath;
        this.toWrite = toWrite;
    }
    
    @Override
    public StringProperty actionAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("WriteOnFile Action: "+this.toWrite+" on "+this.filePath);
        return p;
    }

    @Override
    public void exec() {
        appendTextToFile(this.filePath,this.toWrite);
    }
    
    /**
     * Method to append a String to the end of a File
     * @param filePath text file
     * @param text String
     */
    public static void appendTextToFile(String filePath,String text) {
        if (!checkIfTextFile(filePath)) {
            System.out.println("Not a text file! File: "+filePath);
            return;
        }
        try {
            // Open file in append mode
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true));
            out.write(text);
            out.close();
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
