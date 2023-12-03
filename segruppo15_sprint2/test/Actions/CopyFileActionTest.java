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
public class CopyFileActionTest {
    
    public CopyFileActionTest() {
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
     * Test of exec method, of class CopyFileAction.
     */
    @Test
    public void testExec() {
        CopyFileAction action = new CopyFileAction("C:\\Users\\Andrea\\Desktop\\SE\\test.txt//C:\\Users\\Andrea\\Desktop");
        
        action.exec();
        
        assertTrue(true);
        
    }

    /**
     * Test of actionAttribute method, of class CopyFileAction.
     */
    @Test
    public void testActionAttribute() {
        String filePath = "C:\\Users\\Andrea\\Desktop\\SE\\test.txt//C:\\Users\\Andrea\\Desktop";
        
        CopyFileAction action = new CopyFileAction(filePath);
        String paths[] = filePath.split("//");
        
        StringProperty attribute = action.actionAttribute();
        
        assertEquals("Copy file: " +paths[0]+" Directory: "+paths[1],attribute.get());
    }
    
}
