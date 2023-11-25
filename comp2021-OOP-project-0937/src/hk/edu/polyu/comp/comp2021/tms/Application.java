package hk.edu.polyu.comp.comp2021.tms;
import hk.edu.polyu.comp.comp2021.tms.controller.*;
import hk.edu.polyu.comp.comp2021.tms.model.*;
import hk.edu.polyu.comp.comp2021.tms.view.*;

/**
 * The Application will be the starter of the TMS
 */
public class Application {
    /** It is the main method initializes and runs the
     TMS application.
     *
     * @param args the command line will be passed in to it*/
    public static void main(String[] args){
        TMS tms = new TMS();
        // Initialize and run the system
        TMSView view = new TMSView();

        TMSController tmsController = new TMSController(tms,view);
        tmsController.initialize();
    }

}

