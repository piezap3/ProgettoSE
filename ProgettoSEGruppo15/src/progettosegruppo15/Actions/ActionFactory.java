/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segruppo15.Actions;

/**
 * Action Factory class
 * @author Marco
 */
public class ActionFactory {
    public static Action create(String type, String str) {
        switch (type) {
            case "Message":
                return new MessageAction(str);
            case "Audio":
                return new AudioAction(str);
            default:
                return null;
        }
    }
}
