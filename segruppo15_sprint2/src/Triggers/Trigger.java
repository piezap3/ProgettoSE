/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Triggers;

import java.io.Serializable;
import javafx.beans.property.StringProperty;

/**
 * Trigger interface
 * @author tti_a
 */
public interface Trigger extends Serializable{
    public boolean isVerified();
    public StringProperty triggerAttribute();
}
