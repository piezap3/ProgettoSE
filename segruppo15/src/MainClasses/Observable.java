/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MainClasses;

/**
 *
 * @author Andrea
 */
public interface Observable {
    void subscribeObserver(Observer observer);
    void notifyObservers();
}
