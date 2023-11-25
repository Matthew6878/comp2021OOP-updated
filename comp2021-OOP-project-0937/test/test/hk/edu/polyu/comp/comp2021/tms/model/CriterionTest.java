package test.hk.edu.polyu.comp.comp2021.tms.model;

import hk.edu.polyu.comp.comp2021.tms.model.Criterion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * It is a test to test the Criterion
 */
public class CriterionTest {

    private Criterion criterionUnderTest;

     /**
     * It sets up the situation for the test
     */
    @Before
    public void setUp() {
        criterionUnderTest = new Criterion("criterionName");
    }

     /**
     * It tests whether the getCriterionName() return the required result
     */
    @Test
    public void testCriterionNameGetterAndSetter() {
        final String criterionName = "criterionName";
        criterionUnderTest.setCriterionName(criterionName);
        assertEquals(criterionName, criterionUnderTest.getCriterionName());
    }
}
