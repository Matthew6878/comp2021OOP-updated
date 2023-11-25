package test.hk.edu.polyu.comp.comp2021.tms.model;

import hk.edu.polyu.comp.comp2021.tms.model.BasicCriterion;
import hk.edu.polyu.comp.comp2021.tms.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *  It is a test for testing the BasicCriterion
 */
public class BasicCriterionTest {

    private BasicCriterion basicCriterionUnderTest;

    /**
     * It set up the situation for the test
     */
    @Before
    public void setUp() {
        basicCriterionUnderTest = new BasicCriterion("criterionName", "property", "operator", "value");
    }

    /**
     * It tests whether the getBasicCriterionName() return the required result
     */
    @Test
    public void testCriterionNameGetterAndSetter() {
        final String criterionName = "criterionName";
        basicCriterionUnderTest.setC1Name(criterionName);
        assertEquals(criterionName, basicCriterionUnderTest.getBasicCriterionName());
    }

    /**
     * It tests whether the getProperty() return the required result
     */
    @Test
    public void testPropertyGetterAndSetter() {
        final String property = "property";
        basicCriterionUnderTest.setProperty(property);
        assertEquals(property, basicCriterionUnderTest.getProperty());
    }

    /**
     * It tests whether the getOperator() return the required result
     */
    @Test
    public void testOperatorGetterAndSetter() {
        final String operator = "operator";
        basicCriterionUnderTest.setOperator(operator);
        assertEquals(operator, basicCriterionUnderTest.getOperator());
    }

    /**
     * It tests whether the getValue() return the required result
     */
    @Test
    public void testValueGetterAndSetter() {
        final String value = "value";
        basicCriterionUnderTest.setValue(value);
        assertEquals(value, basicCriterionUnderTest.getValue());
    }

    /**
     * It tests whether the toString() return the required result
     */
    @Test
    public void testToString() {
        assertEquals("BC/test/property/operator/value", basicCriterionUnderTest.toString());
    }

    /**
     * It tests whether the eval() return the required result
     */
    @Test
    public void testEval() {
        // Setup

        final Task task = null;

        // Run the test
        final boolean result = basicCriterionUnderTest.eval(task);

        // Verify the results
        assertFalse(result);
    }
}
