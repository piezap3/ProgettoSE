/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.io.Serializable;

/**
 * Action Factory class
 * @author Marco
 */
public class ActionFactory implements Serializable{
    /**
     * Method to create the right Action.
     * @param type type of action
     * @param str string parameter of Action (Valid for:
     *      messageAction: message to print
     *      audioAction: audio file path
     * @return Action object. Null if invalid type
     */
    public static Action create(String type, String str) {
        switch (type) {
            case "Message":
                return new MessageAction(str);
            case "Audio":
                return new AudioAction(str);
            case "Delete File":
                return new DeleteFileFromDirectoryAction(str);
            case "MoveFile":
                return new MoveFileAction(str);
            case "CopyFile":
                return new CopyFileAction(str);
            case "WriteOnFile":
                return new WriteOnFileAction(str);
            case "ExternalProgram":
                return new ExternalProgramAction(str);
            default:
                return null;
        }
    }
}
