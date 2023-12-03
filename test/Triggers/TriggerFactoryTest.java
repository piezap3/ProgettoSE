package Triggers;

import java.lang.reflect.Field;
import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for TriggerFactory
 */
public class TriggerFactoryTest {

    @Test
    public void testGetTriggerTimeOfDay() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // create a time of day trigger with a sample time
        Trigger trigger = TriggerFactory.getTrigger("TimeOfDay", "12:00:00");
        // check if the trigger is not null
        assertNotNull(trigger);
        // check if the trigger is an instance of TriggerTimeOfDay
        assertTrue(trigger instanceof TriggerTimeOfDay);
        Field timeField = TriggerTimeOfDay.class.getDeclaredField("time");
        timeField.setAccessible(true);
        LocalTime resut = (LocalTime) timeField.get(trigger);
        assertEquals(LocalTime.parse("12:00:00"), resut);
    }

    @Test
    public void testGetTriggerInvalidType() {
        // create a trigger with an invalid type
        Trigger trigger = TriggerFactory.getTrigger("Unknown", "12:00:00");
        // check if the trigger is null
        assertNull(trigger);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTriggerNullTime() {
        // create a trigger with a null time
        Trigger trigger = TriggerFactory.getTrigger("TimeOfDay", null);
        // expect an exception to be thrown
    }
}
