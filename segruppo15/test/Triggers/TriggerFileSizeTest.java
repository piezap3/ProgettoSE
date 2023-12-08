/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Triggers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zappu
 */
public class TriggerFileSizeTest {
    
    private TriggerFileSize triggerFileSize;
    
    @Before
    public void setUp() {
        triggerFileSize = new TriggerFileSize("lib\\file.txt//1000");
    }
    
    @Test
    public void testIsVerified() {
        assertTrue(triggerFileSize.isVerified());
    }
    
    @Test
    public void testTriggerAttribute() {
        System.out.println("triggerAttribute");
        // the trigger attribute should be a string property with the file name and size condition
        String expResult = "Size of:" + "file.txt" + " < 1000 byte";
        String result = triggerFileSize.triggerAttribute().get();
        assertEquals(expResult, result);
    }
    
}
