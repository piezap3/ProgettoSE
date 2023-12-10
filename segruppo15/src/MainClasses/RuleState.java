/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MainClasses;

import java.io.Serializable;

/**
 *
 * @author tti_a
 */
public interface RuleState extends Serializable{
    void fire();
    void update();
}
