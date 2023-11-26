package Actions;

import java.lang.reflect.Field;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for ActionFactory
 */
public class ActionFactoryTest {

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
    public void testCreateInvalidAction() {
        // create an action with an invalid type
        Action action = ActionFactory.create("Unknown", "test");
        // check if the action is null
        assertNull(action);
    }
}
