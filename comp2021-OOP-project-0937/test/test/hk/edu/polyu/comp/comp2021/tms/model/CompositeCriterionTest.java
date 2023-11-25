package test.hk.edu.polyu.comp.comp2021.tms.model;

import hk.edu.polyu.comp.comp2021.tms.model.BasicCriterion;
import hk.edu.polyu.comp.comp2021.tms.model.CompositeCriterion;
import hk.edu.polyu.comp.comp2021.tms.model.Criterion;
import hk.edu.polyu.comp.comp2021.tms.model.Task;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *  It is a test to test the composite criterion
 */
public class CompositeCriterionTest {

    private CompositeCriterion compositeCriterionUnderTest;

    /**
     *  It set up the situation for the test
     */
    @Before
    public void setUp() {
        compositeCriterionUnderTest = new CompositeCriterion("criterionName", new Criterion("criterionName"),
                "operator", new Criterion("criterionName"));
        compositeCriterionUnderTest.getName2();
    }

    /**
     *  It tests whether the getCriterionName() return required result
     */
    @Test
    public void testCriterionNameGetterAndSetter() {
        final String criterionName = "criterionName";
        compositeCriterionUnderTest.setC3Name(criterionName);
        assertEquals(criterionName, compositeCriterionUnderTest.getCriterionName());
    }

    /**
     *  It tests whether the getName1() return required result
     */
    @Test
    public void testGetName1() {
        // Setup
        // Run the test
        final String result = compositeCriterionUnderTest.getName1();

        // Verify the results
        assertEquals("criterionName", result);
    }

    /**
     *  It tests whether the getOperator() return required result
     */
    @Test
    public void testOperatorGetterAndSetter() {
        final String operator = "operator";
        compositeCriterionUnderTest.setOperator(operator);
        assertEquals(operator, compositeCriterionUnderTest.getOperator());
    }

    /**
     *  It tests whether the getName2() return required result
     */
    @Test
    public void testGetName2() {
        // Setup
        // Run the test
        final String result = compositeCriterionUnderTest.getName2();

        // Verify the results
        assertEquals("criterionName", result);
    }

    /**
     *  It tests whether the setName1() run properly
     */
    @Test
    public void testSetName1() {
        final Criterion name1 = new Criterion("criterionName");
        compositeCriterionUnderTest.setName1(name1);
    }

    /**
     *  It tests whether tostring() return required result
     */
    @Test
    public void testToString() {
        // Setup
        // Run the test
        final String result = compositeCriterionUnderTest.toString();

        // Verify the results
        assertEquals("CC/null/criterionName/operator/criterionName", result);
    }

    /**
     *  It tests whether eval() return required result
     */
    @Test
    public void testEval() {
        // Setup
        final Task task = null;

        // Run the test
        final boolean result = compositeCriterionUnderTest.eval(task);

        // Verify the results
        assertFalse(result);
    }
}

