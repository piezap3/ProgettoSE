/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettosegruppo15;

/**
 * Class responsible to load and save Rules from backup File
 * @author Marco
 */
public class FileDirector {
    private final String backupName;

    /**
     * Constructor for FileDirector
     * @param backupName: String for the name of the file
     */
    public FileDirector(String backupName) {
        this.backupName = backupName;
    }
    /**
     * Method that loads Rule list if backup file exists
     */
    public void loadRules() {
        
    }
    /**
     * Method that saves Rule list in backup file
     * Warning: overrides previous backup!
     */
    public void saveRules() {
        
    }
    
}
