package hk.edu.polyu.comp.comp2021.tms.view;
import java.util.Scanner;

/**
 * The view class for the Task Management System (TMS).
 * This class handles the display of menus and user input.
 */
public class TMSView {

    /**
     * Displays the menu options for the TMS
     * which include various commands and their descriptions.
     */
    public void displayMenu() {
        System.out.println("Task Management System");
        System.out.println("1. createsimpletask name description duration prerequisites");
        System.out.println("2. createcompositetask name0 description name1,name2,...,namek");
        System.out.println("3. deletetask name");
        System.out.println("4. changetask name property newValue");
        System.out.println("5. PrintTask name");
        System.out.println("6. PrintAllTask");
        System.out.println("7. ReportDuration name");
        System.out.println("8. ReportEarliestFinishTime name");
        System.out.println("9. DefineBasicCriterion name1 property op value");
        System.out.println("10. DefineBinaryCriterion name1 name2 logicOp name3");
        System.out.println("11. DefineNegatedCriterion name1 name2");
        System.out.println("12. PrintAllCriteria");
        System.out.println("13. Search name");
        System.out.println("14. Store path");
        System.out.println("15. Load path");
        System.out.println("16. quit");
        System.out.println("Please type your code:");
    }

    /**
     * Retrieves user input from the console.
     *
     * @return the user input as a String
     */
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
