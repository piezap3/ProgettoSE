/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Actions;

import java.io.Serializable;
import javafx.beans.property.StringProperty;

/**
 * Action interface
 * @author andrea
 */
public interface Action extends Serializable{
    public void exec();
    public StringProperty actionAttribute();
}
