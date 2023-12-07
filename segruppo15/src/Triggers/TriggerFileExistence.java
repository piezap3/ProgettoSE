/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triggers;

import java.io.Serializable;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author tti_a
 */
public class TriggerFileExistence implements Trigger, Serializable{
    private String fileName;
    private boolean controll=false;
    
    public TriggerFileExistence(String t){
        this.fileName=t;
    }
    
    @Override
    public boolean isVerified() {
        //prendo il percorso del desktop e lo converto in path
        String desktop=getDesktopPath();
        Path path = Paths.get(desktop);
        // Verifica l'esistenza del file
        boolean fileExists = checkFileExistenceRecursive(this.fileName, path);
        
        if(fileExists && !controll){
            controll=true;
            return true;
        }else if(!fileExists){
            System.out.println("il file è stato cancellato o non è presente");
            controll=false;
        }
        return false;
    }

    @Override
    public StringProperty triggerAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("file existence trigger: "+this.fileName);
        return p;
    }
    
    private String getDesktopPath() {
        // Ottieni l'istanza di FileSystemView
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        // Ottieni il percorso del desktop
        return fileSystemView.getHomeDirectory().getPath();
    }
    
    private boolean checkFileExistenceRecursive(String fileName, Path directory) {
        // Verifica l'esistenza del file nella directory corrente
        Path filePath = directory.resolve(fileName);
        if (Files.exists(filePath)) {
            return true;  // Il file esiste nella directory corrente
        }

        // Se il file non è presente nella directory corrente, esegui la ricerca ricorsiva nelle sottocartelle
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path subpath : directoryStream) {
                if (Files.isDirectory(subpath)) {
                    // Esegui la ricorsione nelle sottocartelle
                    if (checkFileExistenceRecursive(fileName, subpath)) {
                        return true;  // Il file è stato trovato nelle sottocartelle
                    }
                }
            }
        } catch (Exception e) {
            // Gestisci eventuali eccezioni durante la lettura delle directory
            e.printStackTrace();
        }
        // Il file non è stato trovato in questa directory o nelle sottocartelle
        return false;
    }
}
