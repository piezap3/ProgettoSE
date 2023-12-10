/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import javafx.scene.control.TableView;

/**
 *
 * @author Andrea
 */
public class TableObserver implements Observer{
    private TableView<?> mainTab;

    public TableObserver(TableView<?> mainTab) {
        this.mainTab = mainTab;
    }
    
    @Override
    public void update() {
        mainTab.refresh();
        System.out.println("Refresh");
    }
    
}
