package test.hk.edu.polyu.comp.comp2021.tms.model;

import hk.edu.polyu.comp.comp2021.tms.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertFalse;

/**
 * It is a test of TMS
 */
public class TMSTest {

    private TMS tmsUnderTest;

    private TMS Storage = new TMS();

    /**
     * It sets up the situation for the test
     */
    @Before
    public void setUp() {
        tmsUnderTest = new TMS();
    }

    /**
     * It tests the CLI()
     */
    @Test
    public void testCLI() {
        // Setup
        // Run the test
        tmsUnderTest.CLI();

        // Verify the results

    }

    /**
     * It tests whether the CreateSimpleTask() run properly
     */
    @Test
    public void testCreateSimpleTask() {
        // Setup
        // Run the test
        tmsUnderTest.CreateSimpleTask("description", "description", 0.0, "description");

        // Verify the results
    }

    /**
     * It tests whether the CreateSimpleTask() run properly
     */
    @Test
    public void testCreateCompositeTask() {
        // Setup
        // Run the test
        tmsUnderTest.CreateCompositeTask("description", "description", "description");

        // Verify the results
    }

    /**
     * It tests whether the DeleteTask() run properly
     */
    @Test
    public void testDeleteTask() {
        // Setup
        // Run the test
        tmsUnderTest.DeleteTask("name");

        // Verify the results
    }

    /**
     * It tests whether the isPrimitive() run properly
     */
    @Test
    public void testIsPrimitive() {
        // Setup
        final Task task = null;

        // Run the test
        final boolean result = TMS.isPrimitive(task);

        // Verify the results
        assertFalse(result);
    }

    /**
     * It tests whether the Search() run properly
     */
    @Test
    public void testSearch() {
        // Setup
        final Criterion a = new Criterion("criterionName");

        // Run the test
        tmsUnderTest.search(a);

        // Verify the results
    }

    /**
     * It tests whether the identifyTC() run properly
     */
    @Test
    public void testIdentifyTC() {
        // Setup
        // Run the test
        tmsUnderTest.identifyTC("line");

        // Verify the results
    }

    /**
     * It tests whether the ChangeTaskProperty() run properly
     */
    @Test
    public void testChangeTaskProperty() {
        // Setup
        // Run the test
        tmsUnderTest.ChangeTaskProperty("name", "property", "description");

        // Verify the results
    }

    /**
     * It tests whether the DefineBasicCriterion() run properly
     */
    @Test
    public void testDefineBasicCriterion() {
        // Setup
        // Run the test
        tmsUnderTest.DefineBasicCriterion("criterionName", "property", "operator", "value");

        // Verify the results
    }

    /**
     * It tests whether the isValidBasicCriterion() run properly
     */
    @Test
    public void testIsValidBasicCriterion() {
        assertFalse(tmsUnderTest.isValidBasicCriterion("criterionName", "property", "operator", "value"));
    }

    /**
     * It tests whether the DefineNegatedCriterion() run properly
     */
    @Test
    public void testDefineNegatedCriterion() {
        // Setup
        // Run the test
        tmsUnderTest.DefineNegatedCriterion("criterionName", "name");

        // Verify the results
    }

    /**
     * It tests whether the DefineBinaryCriterion() run properly
     */
    @Test
    public void testDefineBinaryCriterion() {
        // Setup
        // Run the test
         Criterion test  ;
        tmsUnderTest.DefineBinaryCriterion("criterionName", "name1", "operator", "name2");

        // Verify the results
        //Assert.assertEquals("Invalid basic criterion parameters",getDefineBinaryCriterion() );
    }

    /**
     * It tests whether the findCriterion() run properly
     */
    @Test
    public void testFindCriterion() {
        // Setup
        // Run the test
        final Criterion result = tmsUnderTest.findCriterion("name");

        // Verify the results
        Assert.assertEquals(null, result);
    }
    
    /**
     * It tests whether the testStorePathWithTask() return the required result
     */
    @Test
    public void testStorePathWithTask() {
        // Arrange
        String path = "test_task.txt";
        final double a1 = 5.5;
        Task task = new SimpleTask("Sample task", "Sample task1",a1, "P1");

        // Act

        Storage.storePath(path, task);

        // Assert
        File file = new File(path);
        assertTrue(file.exists());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String content = reader.readLine();
            assertEquals("ST/Sample task/Sample task1/5.5/P1", content);
        } catch (IOException e) {
            Assert.fail("An exception occurred while reading the file.");
        }

        // Clean up
        file.delete();
    }
    
    /**
     * It tests whether the testStoreWithWithCriterion() return the required result
     */
    @Test
    public void testStorePathWithCriterion() {
        // Arrange
        String path = "test_criterion.txt";
        Criterion criterion = new BasicCriterion("Samplecriterion", "SC1", "C2", "T5");

        // Act
        Storage.storePath(path, criterion);

        // Assert
        File file = new File(path);
        assertTrue(file.exists());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String content = reader.readLine();
            assertEquals("BC/Samplecriterion/SC1/C2/T5", content);
        } catch (IOException e) {
            Assert.fail("An exception occurred while reading the file.");
        }

        // Clean up
        file.delete();
    }
    
    /**
     * It tests whether the testLoadPath() return the required result
     */
    @Test
    public void testLoadPath() {
        // Arrange
        String path = "test_load.txt";

        Task expectedTask;
        final double  y3  = 0.3 ;
        expectedTask = new SimpleTask("task2", "boilwater", y3 , ",");
        Criterion expectedCriterion = new BasicCriterion("s1", "duration" , ">", "0.1");

        // Prepare the file
        File file = new File(path);
        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(expectedTask.toString());
            writer.newLine();
            writer.write(expectedCriterion.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            Assert.fail("An exception occurred while preparing the file.");
        }

        // Act
        TMS Storage = new TMS();
        Storage.loadPath(path);
        Task actualTask = Storage.searchTask("task2");
        Criterion actualCriterion = Storage.findCriterion("s1");

        // Assert
        assertNotNull(actualTask);
        assertEquals(expectedTask.toString(), actualTask.toString());
        assertNotNull(actualCriterion);
        assertEquals(expectedCriterion.toString(), actualCriterion.toString());

        // Clean up
        file.delete();
    }
    
}
