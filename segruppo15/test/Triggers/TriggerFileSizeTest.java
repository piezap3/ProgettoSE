/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Triggers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        triggerFileSize = new TriggerFileSize("C:\\Users\\zappu\\Desktop\\car1\\file.txt//1000");
    }
    
    @Test
    public void testIsVerified() {
        assertTrue(triggerFileSize.isVerified());
    }
    
    @Test
    public void testTriggerAttribute() {
        StringProperty expected = new SimpleStringProperty("Size of:file < 1000 byte");
        assertEquals(expected, triggerFileSize.triggerAttribute());
    }
    
}
