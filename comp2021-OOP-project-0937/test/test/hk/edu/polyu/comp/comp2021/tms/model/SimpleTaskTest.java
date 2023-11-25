package test.hk.edu.polyu.comp.comp2021.tms.model;

import hk.edu.polyu.comp.comp2021.tms.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * It is a test of simple task
 */
public class SimpleTaskTest {

    private SimpleTask simpleTaskUnderTest;

    /**
     * It sets up the situation for the test
     */
    @Before
    public void setUp() {
        simpleTaskUnderTest = new SimpleTask("name", "description", 0.0, "prerequisites");
    }

    /**
     * It tests whether the getDuration() return the required result
     */
    @Test
    public void testDurationGetterAndSetter() {
        final double duration = 0.0;
        final double t1 = 0.0001;
        simpleTaskUnderTest.setDuration(duration);
        assertEquals(duration, simpleTaskUnderTest.getDuration(), t1);
    }

    /**
     * It tests whether the ToString() return the required result
     */
    @Test
    public void testToString() {
        assertEquals("ST/name/description/0.0/prerequisites", simpleTaskUnderTest.toString());
    }
}
