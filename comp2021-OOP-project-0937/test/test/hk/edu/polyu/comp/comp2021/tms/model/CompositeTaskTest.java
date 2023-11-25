package test.hk.edu.polyu.comp.comp2021.tms.model;

import hk.edu.polyu.comp.comp2021.tms.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * It is a test to test the composite task
 */
public class CompositeTaskTest {

    private CompositeTask compositeTaskUnderTest;

    /**
     *  It set up the situation for the test
     */
    @Before
    public void setUp() {
        compositeTaskUnderTest = new CompositeTask("name", "description", "prerequisites");
    }

    /**
     *  It tests whether toString() return the required result
     */
    @Test
    public void testToString() {
        assertEquals("CT/name/description/prerequisites", compositeTaskUnderTest.toString());
    }
}
