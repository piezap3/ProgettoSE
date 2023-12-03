/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Actions;

import java.lang.reflect.Field;
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
public class ActionFactoryTest {
    
    public ActionFactoryTest() {
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
     * Test of create method, of class ActionFactory.
     */
    @Test
    public void testCreateMessageAction() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // create a message action with a sample string
        Action action = ActionFactory.create("Message", "Hello world");
        // check if the action is not null
        assertNotNull(action);
        // check if the action is an instance of MessageAction
        assertTrue(action instanceof MessageAction);
        
        Field stringaTest = MessageAction.class.getDeclaredField("message");
        stringaTest.setAccessible(true);
        String resut = (String) stringaTest.get(action);
        // check if the action has the correct string
        assertEquals("Hello world", resut);
    }
    
    @Test
    public void testCreateAudioAction() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        // create an audio action with a sample string
        Action action = ActionFactory.create("Audio", "sound.wav");
        // check if the action is not null
        assertNotNull(action);
        // check if the action is an instance of AudioAction
        assertTrue(action instanceof AudioAction);
        // check if the action has the correct string
        
        Field stringaTest = AudioAction.class.getDeclaredField("filePath");
        stringaTest.setAccessible(true);
        String resut = (String) stringaTest.get(action);
        assertEquals("sound.wav", resut);
    }
    
    @Test
    public void testDeleteFileFromDirectoryAction() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        // create a delete file from dirctory action with a sample string
        Action action = ActionFactory.create("Delete File", "test.txt");
        // check if the action is not null
        assertNotNull(action);
        // check if the action is an instance of DeleteFileFromDirectoryAction
        assertTrue(action instanceof DeleteFileFromDirectoryAction);
        // check if the action has the correct string
        
        Field stringaTest = DeleteFileFromDirectoryAction.class.getDeclaredField("filePath");
        stringaTest.setAccessible(true);
        String resut = (String) stringaTest.get(action);
        assertEquals("test.txt", resut);
    }
    
    @Test
    public void testMoveFileAction() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        // create a move filey action with a sample string
        Action action = ActionFactory.create("MoveFile", "test.txt");
        // check if the action is not null
        assertNotNull(action);
        // check if the action is an instance of MoveFileAction
        assertTrue(action instanceof MoveFileAction);
        // check if the action has the correct string
        
        Field stringaTest = MoveFileAction.class.getDeclaredField("filePath12");
        stringaTest.setAccessible(true);
        String resut = (String) stringaTest.get(action);
        assertEquals("test.txt", resut);
    }
    
    @Test
    public void testCopyFileAction() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        // create a copy file action with a sample string
        Action action = ActionFactory.create("CopyFile", "test.txt");
        // check if the action is not null
        assertNotNull(action);
        // check if the action is an instance of CopyFileAction
        assertTrue(action instanceof CopyFileAction);
        // check if the action has the correct string
        
        Field stringaTest = CopyFileAction.class.getDeclaredField("filePath12");
        stringaTest.setAccessible(true);
        String resut = (String) stringaTest.get(action);
        assertEquals("test.txt", resut);
    }
    
    @Test
    public void testWriteOnFileAction() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        // create a write on file action with a sample string
        Action action = ActionFactory.create("WriteOnFile", "test.txt");
        // check if the action is not null
        assertNotNull(action);
        // check if the action is an instance of WriteOnFileAction
        assertTrue(action instanceof WriteOnFileAction);
        // check if the action has the correct string
        
        Field stringaTest = WriteOnFileAction.class.getDeclaredField("filePathAndStringToAppend");
        stringaTest.setAccessible(true);
        String resut = (String) stringaTest.get(action);
        assertEquals("test.txt", resut);
    }
    
    @Test
    public void testCreateInvalidAction() {
        // create an action with an invalid type
        Action action = ActionFactory.create("Unknown", "test");
        // check if the action is null
        assertNull(action);
    }
    
}
