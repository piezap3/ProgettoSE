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
public class DeleteFileFromDirectoryActionTest {
    
    public DeleteFileFromDirectoryActionTest() {
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
     * Test of exec method, of class DeleteFileFromDirectoryAction.
     */
    @Test
    public void testExec() {
        DeleteFileFromDirectoryAction action = new DeleteFileFromDirectoryAction("C:\\Users\\Andrea\\Desktop\\test.txt");
        
        action.exec();
        
        assertTrue(true);
    }

    /**
     * Test of actionAttribute method, of class DeleteFileFromDirectoryAction.
     */
    @Test
    public void testActionAttribute() {
        String filePath = "C:\\Users\\Andrea\\Desktop\\test.txt";
        
        DeleteFileFromDirectoryAction action = new DeleteFileFromDirectoryAction(filePath);
        
        StringProperty attribute = action.actionAttribute();
        
        assertEquals("Delete File Action: "+filePath,attribute.get());
    }
    
}
