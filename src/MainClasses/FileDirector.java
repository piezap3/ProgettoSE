/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class that manages save/load from backup file
 * @author zappu
 */
public class FileDirector {
public void saveRules(ObservableList<Rule> list){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("lista.dat"))) {
       outputStream.writeObject(new ArrayList<>(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public  ObservableList<Rule> loadRules() {
        ObservableList<Rule> list=FXCollections.observableArrayList();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("lista.dat"))) {
        List<Rule> readList = (List<Rule>) inputStream.readObject();
        list.setAll(readList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File not found. Returning empty list!");
        }
        return list;
    };  
}
