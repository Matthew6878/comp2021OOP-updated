package test.hk.edu.polyu.comp.comp2021.tms.model;

import hk.edu.polyu.comp.comp2021.tms.model.Task;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * It is a test for task
 */
public class TaskTest {

    private Task taskUnderTest;

    /**
     *  It sets up the situation for the test
     */
    @Before
    public void setUp() {
        taskUnderTest = new Task("name", "description", "prerequisites") {};
    }

    /**
     * It tests whether the getName() return the required result
     */
    @Test
    public void testNameGetterAndSetter() {
        final String name = "name";
        taskUnderTest.setName(name);
        assertEquals(name, taskUnderTest.getName());
    }

    /**
     * It tests whether the getDescription() return the required result
     */
    @Test
    public void testDescriptionGetterAndSetter() {
        final String description = "description";
        taskUnderTest.setDescription(description);
        assertEquals(description, taskUnderTest.getDescription());
    }

    /**
     * It tests whether the getPrerequisites() return the required result
     */
    @Test
    public void testPrerequisitesGetterAndSetter() {
        final String prerequisites = "prerequisites";
        taskUnderTest.setPrerequisites(prerequisites);
        assertEquals(prerequisites, taskUnderTest.getPrerequisites());
    }
}
