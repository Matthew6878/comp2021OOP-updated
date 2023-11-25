package hk.edu.polyu.comp.comp2021.tms.controller;
import hk.edu.polyu.comp.comp2021.tms.view.*;
import hk.edu.polyu.comp.comp2021.tms.model.*;
import java.io.*;
import java.util.*;

/**
 * The controller class for the Task Management System (TMS).
 * This class handles the interaction between the model and the view.
 */
public class TMSController {
    private TMS model;
    private TMSView view;
    private BufferedWriter out;

    /**
     * It is the constructor of TMSController with the specified model and view.
     *
     * @param model the TMS model
     * @param view  the TMS view
     */
    public TMSController(TMS model, TMSView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Initializes the TMS by displaying the menu and running the command line interface.
     */
    public void initialize() {
        view.displayMenu();//show available command
        model.CLI();//run command line interface
    }
}
