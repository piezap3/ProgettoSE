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
public class MoveFileActionTest {
    
    public MoveFileActionTest() {
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
     * Test of exec method, of class MoveFileAction.
     */
    @Test
    public void testExec() {
        MoveFileAction action = new MoveFileAction("C:\\Users\\Andrea\\Desktop\\test2.txt//C:\\Users\\Andrea\\Desktop\\SE");
        
        action.exec();
        
        assertTrue(true);
    }

    /**
     * Test of actionAttribute method, of class MoveFileAction.
     */
    @Test
    public void testActionAttribute() {
        String filePathAndDir = "C:\\Users\\Andrea\\Desktop\\test2.txt//C:\\Users\\Andrea\\Desktop\\SE";
        String divStr[] = filePathAndDir.split("//");
        
        MoveFileAction action = new MoveFileAction(filePathAndDir);
        
        StringProperty attribute = action.actionAttribute();
        
        assertEquals("Move File: "+divStr[0]+" Directory: "+divStr[1],attribute.get());
    }
    
}
