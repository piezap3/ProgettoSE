/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Actions;

import javafx.beans.property.StringProperty;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class WriteOnFileActionTest {
    
    public WriteOnFileActionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actionAttribute method, of class WriteOnFileAction.
     */
    @Test
    public void testActionAttribute() {
        String filePathAndStringToAppend = "lib/file.txt//ciao";
        String divStr[] = filePathAndStringToAppend.split("//");
        
        WriteOnFileAction action = new WriteOnFileAction(filePathAndStringToAppend);
        
        StringProperty attribute = action.actionAttribute();
        
        assertEquals("Write: "+divStr[1]+" On File: "+divStr[0],attribute.get());
    }

    /**
     * Test of exec method, of class WriteOnFileAction.
     */
    @Test
    public void testExec() {
        WriteOnFileAction action = new WriteOnFileAction("lib/filedascrivere.txt//ciao");
        
        action.exec();
        
        assertTrue(true);
    }

    /**
     * Test of appendTextToFile method, of class WriteOnFileAction.
     */
    @Test
    public void testAppendTextToFile() {
        String file = "lib/filedascrivere.txt//ciao";
        WriteOnFileAction action = new WriteOnFileAction(file);
        String fileWrite[] = file.split("//");
        WriteOnFileAction.appendTextToFile(fileWrite[0], fileWrite[1]);
        String ExistingText = "ciao";
        String ExpectedText = ExistingText + fileWrite[1];
        
        assertEquals(ExpectedText, "ciaociao");
    }

    /**
     * Test of checkIfTextFile method, of class WriteOnFileAction.
     */
    @Test
    public void testCheckIfTextFile() {
        String file = "lib/filedascrivere.txt";
        
        boolean result = WriteOnFileAction.checkIfTextFile(file);
        
        assertEquals(result, true);
    }
    
}
