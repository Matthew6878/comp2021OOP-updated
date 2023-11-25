package test.hk.edu.polyu.comp.comp2021.tms.view;

import hk.edu.polyu.comp.comp2021.tms.view.TMSView;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

/**
 * It is a test for TMSView
 */
public class TMSViewTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private TMSView tmsViewUnderTest;

    /**
     * It sets up the situation for the test
     */
    @Before
    public void setUp() {
        //tmsViewUnderTest = new TMSView();
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    /**
     * It sets the systemIn and systemOut
     */
    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    /**
     * It tests whether DisplayMenu() run properly
     */
    @Test
    public void testDisplayMenu() {
        // Setup
        // Run the test
        TMSView tmsView = new TMSView();
        tmsView.displayMenu();
        // Verify the results
        String expectedOutput = "Task Management System\n" +
                "1. createsimpletask name description duration prerequisites\n" +
                "2. createcompositetask name0 description name1,name2,...,namek\n" +
                "3. deletetask name\n" +
                "4. changetask name property newValue\n" +
                "5. PrintTask name(not completed)\n" +
                "6. PrintAllTask(not completed)\n" +
                "7. ReportDuration name(not completed)\n" +
                "8. ReportEarliestFinishTime name(not completed)\n" +
                "9. DefineBasicCriterion name1 property op value\n" +
                "10. DefineNegatedCriterion name1 name2(not completed)\n" +
                "11. PrintAllCriteria(not completed)\n" +
                "12. Search name(not completed)\n" +
                "13. Store path(not validated)\n" +
                "14. Load path(not validated)\n" +
                "15. quit\n" +
                "Please type your code:\n";

        assertEquals(expectedOutput, testOut.toString());
    }

    /**
     * It tests whether getUserInput() run properly
     */
    @Test
    public void testGetUserInput() {
        String input = "User input example";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        TMSView tmsView = new TMSView();
        String userInput = tmsView.getUserInput();

        assertEquals(input, userInput);
    }
    }



