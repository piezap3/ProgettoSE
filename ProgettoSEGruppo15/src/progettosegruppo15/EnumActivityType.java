/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettosegruppo15;

/**
 * Activity Type for Rules. Each type will make the rule behave differently after firing.
 * @author Marco
 */
public enum EnumActivityType {
    /**
     * Normal Firing. The rule will follow it's normal routine after firing
     */
    NORMAL_FIRING,
    /**
     * Fire Once. The rule will become inactive after firing
     */
    FIRE_ONCE,
    /**
     * Sleep after Firing. The rule will go in sleep mode after firing.
     */
    SLEEP_AFTER_FIRING
}
