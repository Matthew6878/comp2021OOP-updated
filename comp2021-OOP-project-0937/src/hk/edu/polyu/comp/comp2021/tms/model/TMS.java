package hk.edu.polyu.comp.comp2021.tms.model;


import java.util.*;
import java.io.*;

/**
 * It is the class of a Task Management System (TMS).
 */
public class TMS {
    private List<Task> taskList;
    private List<Criterion> CriterionList;

    /**
     * It is the constructor of a TMS object with an empty task list and criterion list.
     */
    public TMS() {
        taskList = new ArrayList<>();
        CriterionList = new ArrayList<>();
    }

    /**
     * It is a command line interface of the task management system
     */
    public void CLI() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                // ask user input the command
                if (scanner.hasNext()) {
                    String command = scanner.nextLine();
                    String[] arrofcommand = command.trim().split(" ");
                    // quit
                    switch (arrofcommand[0].toLowerCase()) {
                        case "quit":
                            //saveallTasks()
                            return;
                        case "createsimpletask":
                            try {
                                if (arrofcommand.length != 5) {
                                    throw new NoSuchElementException("Not correct number of elements provided for Createcompositetaskk command.");
                                }
                                // extract task details
                                String s_name = arrofcommand[1];
                                String s_description = arrofcommand[2];
                                double duration = Double.parseDouble(arrofcommand[3]);
                                String prerequisitesList = arrofcommand[4];
                                CreateSimpleTask(s_name, s_description, duration, prerequisitesList);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Error: Insufficient elements provided for CreateSimpleTask command.");
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Invalid duration provided for CreateSimpleTask command.");
                            }
                            break;
                        case "createcompositetask":
                            try {
                                if (arrofcommand.length != 4) {
                                    throw new NoSuchElementException("Not correct number of elements provided for Createcompositetaskk command.");
                                }
                                // extract task details
                                String c_name = arrofcommand[1];
                                String c_description = arrofcommand[2];
                                String subtaskList = arrofcommand[3];
                                CreateCompositeTask(c_name, c_description, subtaskList);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case "deletetask":
                            try {
                                if (arrofcommand.length != 2) {
                                    throw new NoSuchElementException("Not correct number of elements provided for DeleteTask command.");
                                }
                                DeleteTask(arrofcommand[1]);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case "changetask":
                            try {
                                if (arrofcommand.length != 4) {
                                    throw new NoSuchElementException("Not correct number of elements provided for ChangeTask command.");
                                }
                                String name = arrofcommand[1];
                                String property = arrofcommand[2];
                                String new_value = arrofcommand[3];
                                ChangeTaskProperty(name, property, new_value);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case "definebasiccriterion":
                            try {
                                if (arrofcommand.length != 5) {
                                    throw new NoSuchElementException("Not correct number of elements provided for DefineBasicCriterion command.");
                                }
                                String name = arrofcommand[1];
                                String property = arrofcommand[2];
                                String operator = arrofcommand[3];
                                String value = arrofcommand[4]; // changed it to String on 14/11/2023
                                DefineBasicCriterion(name, property, operator, value);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;

                        case "definenegatedcriterion":
                            try {
                                if (arrofcommand.length != 3) {
                                    throw new NoSuchElementException("Not correct number of elements provided for DefineNegatedCriterion command.");
                                }
                                String criterionName = arrofcommand[1];
                                String name = arrofcommand[2];
                                DefineNegatedCriterion(criterionName, name);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;

                        case "definebinarycriterion":
                            try {
                                if (arrofcommand.length != 5) {
                                    throw new NoSuchElementException("Not correct number of elements provided for DefinedBinaryCriterion command.");
                                }
                                String criterionName = arrofcommand[1];
                                String name1 = arrofcommand[2];
                                String operator = arrofcommand[3];
                                String name2 = arrofcommand[4];
                                DefineBinaryCriterion(criterionName, name1, operator, name2);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case "search":
                            try {
                                if (arrofcommand.length != 2) {
                                    throw new NoSuchElementException("Not correct number of elements provided for Search command.");
                                }
                                //add the missing method
                                String criterionName = arrofcommand[1];
                                Criterion criterion = null;
                                for (Criterion i : CriterionList) {
                                        String iCriterionName = i.getCriterionName();
                                        if (iCriterionName != null && iCriterionName.equals(criterionName)) {
                                            criterion = i;
                                            search(criterion);
                                        }
                                }
                                search(criterion);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case "store":
                            try {
                                if (arrofcommand.length != 2) {
                                    throw new NoSuchElementException("Not correct number of elements provided for Store command.");
                                }
                                String path = arrofcommand[1];
                                for (Task i : taskList)
                                    storePath(path, i);
                                for (Criterion i: CriterionList)
                                    storePath(path, i);
                                System.out.println("The tasks and criteria are stored in" + path);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case "reportearliestfinishtime":
                            try {
                                if (arrofcommand.length != 2) {
                                    throw new NoSuchElementException("Not correct number of elements provided for reportearliestfinishtime command.");
                                }
                                reportEarliestFinishTime(arrofcommand[1]);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case "reportduration":
                            try {
                                if (arrofcommand.length != 2) {
                                    throw new NoSuchElementException("Not correct number of elements provided for reportearliestfinishtime command.");
                                }
                                ReportDuration(arrofcommand[1]);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;    
                        case "load":
                            try {
                                if (arrofcommand.length != 2) {
                                    throw new NoSuchElementException("Not correct number of elements provided for Load command.");
                                }
                                loadPath(arrofcommand[1]);
                                System.out.println("The data of the file is loaded");
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case "printallcriteria":
                            try {
                                if (arrofcommand.length != 1) {
                                    throw new NoSuchElementException("Not correct number of elements provided for PrintAllCriteria command.");
                                }
                                printAllCriteria();
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case "printtask":
                            try {
                                if (arrofcommand.length != 2) {
                                    throw new NoSuchElementException("Not correct number of elements provided for printTask command.");
                                }
                                printTask(arrofcommand[1]);
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case "printalltask":
                            try {
                                if (arrofcommand.length != 1) {
                                    throw new NoSuchElementException("Not correct number of elements provided for printTask command.");
                                }
                                printAllTasks();
                            } catch (NoSuchElementException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("Invalid command");
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

    }
    /*public void saveallTasks() {
        try {
            fw = new File("task_record.txt");
            out = new BufferedWriter(new FileWriter(fw));
            for (Task task : taskList) {
                out.write(task.getName() + "," + task.getDescription() + ",");
                if (task instanceof SimpleTask) {
                    out.write(((SimpleTask) task).getDuration() + ",");
                }
                out.write(task.getPrerequisites().toString());
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }*/

    /**
     * Checks if a given name is unique among tasks and criteria.
     *
     * @param name the name to be checked for uniqueness
     * @return return true if the name is unique, false otherwise
     */
    public boolean isNameUnique(String name) {
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                return false; // Name is not unique
            }
        }
        for (Criterion c : CriterionList) {
            if (c.getCriterionName().equals(name)) {
                return false; // Name is not unique
            }
        }
        return true; // Name is unique
    }


    /**
     * Creates a simple task with the provided name, description, duration, and prerequisites.
     *
     * @param name          the name of the task
     * @param description   the description of the task
     * @param duration      the duration of the task
     * @param prerequisites the prerequisites of the task, separated by commas
     */
    public void CreateSimpleTask(String name, String description, double duration, String prerequisites) {
        if (isNameUnique(name)) {
            if (prerequisites.split(",").length < 2) {
                if (Task.TaskValidator.isValidTaskName(name) && Task.TaskValidator.isValidDescription(description) && Task.TaskValidator.isValidDuration(duration) && Task.TaskValidator.isValidPrerequisites(prerequisites, taskList)) {
                    SimpleTask task = new SimpleTask(name, description, duration, prerequisites);
                    taskList.add(task);
                    System.out.println("Simple task has been created.");
                } else {
                    System.out.println("Invalid task details. Please check the input.");
                }
            } else {
                System.out.println("Too many prerequisites. A simple task can have at most one prerequisite.");
            }
        } else {
            System.out.println("The name already exists. Please choose a different name.");
        }
    }

    /**
     * Creates a composite task with the provided name, description, and prerequisites.
     *
     * @param name          the name of the task
     * @param description   the description of the task
     * @param prerequisites the prerequisites of the task, separated by commas
     */
    public void CreateCompositeTask(String name, String description, String prerequisites) {
        if (isNameUnique(name)) {
            if (prerequisites.split(",").length >= 2) {
                if (Task.TaskValidator.isValidTaskName(name) && Task.TaskValidator.isValidDescription(description) && Task.TaskValidator.isValidPrerequisites(prerequisites, taskList)) {
                    CompositeTask task = new CompositeTask(name, description, prerequisites);
                    taskList.add(task);
                    System.out.println("Composite task has been created.");
                } else {
                    System.out.println("Invalid task details. Please check the input.");
                }
            } else {
                System.out.println("Not enough tasks for prerequisites. A composite task should have at least two prerequisites.");
            }
        } else {
            System.out.println("The name already exists. Please choose a different name.");
        }
    }

    /**
     * Deletes a task with the provided name from the task list.
     *
     * @param name the name of the task to be deleted
     */
    public void DeleteTask(String name) {
        Task taskToDelete = null;
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                taskToDelete = task;
                break;
            }
        }

        if (taskToDelete != null) {
            if (isPrerequisite(taskToDelete)) {
                System.out.println("Cannot delete task '" + name + "'. It is a prerequisite for another task.");
            } else {
                taskList.remove(taskToDelete);
                System.out.println("Task deleted: " + taskToDelete.getName());
            }
        } else {
            System.out.println("Task not found: " + name);
        }
    }

    /**
     * Checks if the passed task is a prerequisite task for any other task in the task list.
     *
     * @param task the task to check for being a prerequisite
     * @return return true if the task is a prerequisite for another task,false otherwise
     */
    public boolean isPrerequisite(Task task) {
        String[] subtasks = task.getPrerequisites().split(",");
        for (Task t : taskList) {
            String[] Prerequisite = t.getPrerequisites().split(",");
            for (String prerequisitename : Prerequisite) {
                if (prerequisitename.equals(task.getName())) {
                    return true;
                }
                for (String subtask : subtasks) {
                    if (prerequisitename.equals(subtask) && t != task) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    /**
     * Searches for tasks that match with the provided criterion and prints the results.
     *
     * @param a the criterion used for searching tasks
     * @throws RuntimeException if an exception occurs during evaluation
     */
    public void search(Criterion a) {
        // this function is updated on 18/11/2023
        List<String> result = new ArrayList<>();
        try {
            if (a instanceof BasicCriterion) {
                for (Task task : taskList) {
                    if (((BasicCriterion) a).eval(task)) {
                        result.add(task.getName());
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            if (a instanceof CompositeCriterion) {
                for (Task task : taskList) {
                    if (((CompositeCriterion) a).eval(task)) {
                        result.add(task.getName());
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("The required result:");
        System.out.println("------------------------------------");
        for (String i : result) {
            System.out.println(i);
            System.out.println("------------------------------------");
        }
        System.out.println("------------------------------------");
    }

    /**
     * Stores the string representation of a task in a file at the specified path.
     *
     * @param path the path where the file will be stored
     * @param task the task to be stored
     * @throws RuntimeException if an exception occurs during file creation or writing
     */
    public static void storePath(String path, Task task) {
        // this method only handle one task in one execution
        // updated on 14/11/2023
        File storage = new File(path);
        String content;
        if (task instanceof SimpleTask) {
            content = ((SimpleTask) task).toString();
        } else {
            content = ((CompositeTask) task).toString();
        }
        try {
            boolean created = storage.createNewFile();
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(storage));
            fileWriter.write(content);
            fileWriter.newLine();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stores the string representation of a criterion in a file at the specified path.
     *
     * @param path the path where the file will be stored
     * @param criterion the criterion to be stored
     * @throws RuntimeException if an exception occurs during file creation or writing
     */
    public static void storePath(String path, Criterion criterion) {
        // this method only handle one task in one execution
        File storage = new File(path);
        String content;
        if (criterion instanceof BasicCriterion) {
            content = ((BasicCriterion) criterion).toString();
        } else {
            content = ((CompositeCriterion) criterion).toString();
        }
        try {
            boolean created = storage.createNewFile();
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(storage));
            fileWriter.write(content);
            fileWriter.newLine();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Identifies the type of the task and criteria
     * and create the corresponding task and criteria based on the provided line of input.
     *
     * @param line the line of input to be processed
     */
    public void identifyTC(String line) {
        // updated on 14/11/2023
        List<String> record = new ArrayList<>(Arrays.asList(line.split("/")));
        if (record.get(0).equals("ST")) {
            if (record.size() == 5) {
                CreateSimpleTask(record.get(1), record.get(2), Double.parseDouble(record.get(3)), record.get(4));
            }
        } else if (record.get(0).equals("CT")) {
            if (record.size() == 4) {
                CreateCompositeTask(record.get(1), record.get(2), record.get(3));
            }
        } else if (record.get(0).equals("BC")) {
            if (record.size() == 5) {
                DefineBasicCriterion(record.get(1), record.get(2), record.get(3), record.get(4));
            }
        } else if (record.get(0).equals("CC")) {
            if (record.size() == 4) {
                DefineNegatedCriterion(record.get(1), record.get(2));
            }
            if (record.size() == 5) {
                DefineBinaryCriterion(record.get(1), record.get(2), record.get(3), record.get(4));
            }
        }
    }

    /**
     * Loads data from a file at the specified path and calls the appropriate methods to process each line.
     *
     * @param path the path of the file to be loaded
     * @throws RuntimeException if an exception occurs during file reading or method identification
     */
    public void loadPath(String path) {
        // this method will return a list that
        // store two list which store the task and criterion respectively
        // updated on 14/11/2023
        File storage = new File(path);

        try {
            boolean created = storage.createNewFile();
            BufferedReader fileReader = new BufferedReader(new FileReader(storage));
            String line = fileReader.readLine();
            if(line!= null){
                identifyTC(line);
            }

            while (line != null) {
                line = fileReader.readLine();
                if(line!=null){
                    identifyTC(line);
                }

            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e) {
            // Handle the null line error, e.g., log an error message or throw a specific exception
            e.printStackTrace();
        }
    }

    /**
     * Updates the specified property of a task with a new value.
     *
     * @param name     the name of the task to update
     * @param property the property of the task to update
     * @param newValue the new value to set for the property
     */
    public void ChangeTaskProperty(String name, String property, String newValue) {
        Task taskToUpdate = null;

        // Find the task to update by matching the name
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                taskToUpdate = task;
                break;
            }
        }
        // Check if the task to update exists
        if (taskToUpdate != null) {
            // Update properties based on task type
            try {
                if (taskToUpdate instanceof SimpleTask) {
                    SimpleTask simpleTask = (SimpleTask) taskToUpdate;

                    // Update properties for a simple task
                    switch (property) {
                        case "name":
                            if (Task.TaskValidator.isValidTaskName(newValue)) {
                                simpleTask.setName(newValue);
                                System.out.println("Task name has been changed");
                            } else {
                                System.out.println("Invalid task name: " + newValue);
                            }
                            break;
                        case "description":
                            if (Task.TaskValidator.isValidDescription(newValue)) {
                                simpleTask.setDescription(newValue);
                                System.out.println("Task description has been changed");
                            } else {
                                System.out.println("Invalid description: " + newValue);
                            }
                            break;
                        case "duration":
                            try {
                                double newDuration = Double.parseDouble(newValue);
                                if (Task.TaskValidator.isValidDuration(newDuration)) {
                                    simpleTask.setDuration(newDuration);
                                    System.out.println("Task duration has been changed");
                                } else {
                                    System.out.println("Invalid duration value: " + newValue);
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid duration value: " + newValue);
                            }
                            break;
                        case "prerequisites":
                            if (Task.TaskValidator.isValidPrerequisites(newValue, taskList)) {
                                simpleTask.setPrerequisites(newValue);
                                System.out.println("Task prerequisites have been changed");
                            } else {
                                System.out.println("Invalid prerequisites: " + newValue);
                            }
                            break;
                        default:
                            System.out.println("Invalid property for a simple task: " + property);
                            break;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (taskToUpdate instanceof CompositeTask) {
                    CompositeTask compositeTask = (CompositeTask) taskToUpdate;

                    // Update properties for a composite task
                    switch (property) {
                        case "name":
                            if (Task.TaskValidator.isValidTaskName(newValue)) {
                                compositeTask.setName(newValue);
                                System.out.println("Task name has been changed");
                            } else {
                                System.out.println("Invalid task name: " + newValue);
                            }
                            break;
                        case "description":
                            if (Task.TaskValidator.isValidDescription(newValue)) {
                                compositeTask.setDescription(newValue);
                                System.out.println("Task description has been changed");
                            } else {
                                System.out.println("Invalid description: " + newValue);
                            }
                            break;
                        case "prerequisites":
                            if (Task.TaskValidator.isValidPrerequisites(newValue, taskList)) {
                                compositeTask.setPrerequisites(newValue);
                                System.out.println("Task prerequisites have been changed");
                            } else {
                                System.out.println("Invalid prerequisites: " + newValue);
                            }
                            break;
                        default:
                            System.out.println("Invalid property for a composite task: " + property);
                            break;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Task not found: " + name);
        }
    }

    /**
     * Defines a basic criterion with the specified parameters.
     *
     * @param criterionName the name of the criterion
     * @param property      the property associated with the criterion
     * @param operator      the operator used for comparison
     * @param value         the value to compare against
     */
    public void DefineBasicCriterion(String criterionName, String property, String operator, String value) {
        // Validate the criterion parameters
        if (!isValidBasicCriterion(criterionName, property, operator, value)) {
            System.out.println("Invalid basic criterion parameters");
            return;
        }

        if (isNameUnique(criterionName)) {
            BasicCriterion criterion = new BasicCriterion(criterionName, property, operator, value);
            CriterionList.add(criterion);
            System.out.println("Basic criterion has been defined: " + criterionName);
        } else {
            System.out.println("The criterion name already exists: " + criterionName);
        }
    }

    /**
     * Validates the parameters of a basic criterion.
     *
     * @param criterionName the name of the criterion
     * @param property      the property associated with the criterion
     * @param operator      the operator used for comparison
     * @param value         the value to compare against
     * @return true if the criterion parameters are valid, false otherwise
     */
    public boolean isValidBasicCriterion(String criterionName, String property, String operator, String value) {
        // Validate criterion name
        if (!Task.TaskValidator.isValidTaskName(criterionName)) {
            return false;
        }

        switch (property) {
            case "name":
            case "description":
                // For name and description properties, operator must be "contains" and value must be in double quotes
                if (!operator.equals("contains") || !value.startsWith("\"") || !value.endsWith("\"")) {
                    return false;
                }
                break;
            case "duration":
                // For duration property, operator must be one of >, <, >=, <=, ==, !=
                // and value must be a valid real number
                if (!operator.equals(">") && !operator.equals("<") && !operator.equals(">=") && !operator.equals("<=") &&
                        !operator.equals("==") && !operator.equals("!=")) {
                    return false;
                }
                try {
                    Double.parseDouble(value);
                } catch (NumberFormatException e) {
                    return false;
                }
                break;
            case "prerequisites":
                // For prerequisites property, value must be a comma-separated list of task names
                String[] taskNames = value.split(",");
                for (String taskName : taskNames) {
                    if (!Task.TaskValidator.isValidTaskName(taskName.trim())) {
                        return false;
                    }
                }
                break;
            default:
                return false; // Invalid property
        }

        return true;
    }

    /**
     * Defines a negated criterion with the specified criterion name and reference to an existing criterion.
     *
     * @param criterionName the name of the negated criterion
     * @param name          the name of the existing criterion to negate
     */
    public void DefineNegatedCriterion(String criterionName, String name) {
        // Validate the criterion parameters
        if (!Task.TaskValidator.isValidTaskName(criterionName)) {
            System.out.println("Invalid negated criterion name");
            return;
        }
        Criterion c = findCriterion(name);
        if (c == null) {
            System.out.println("There does not exist the criterion:" + name);
            return;
        }
        if (isNameUnique(criterionName)) {
            CompositeCriterion criterion = new CompositeCriterion(criterionName, c);
            CriterionList.add(criterion);
            System.out.println("A negated criterion has been defined: " + criterionName);
        } else {
            System.out.println("The criterion name already exists: " + criterionName);
        }
    }

    /**
     * Defines a binary criterion with the specified criterion name, two criterion names, and an operator.
     *
     * @param criterionName the name of the binary criterion
     * @param name1         the name of the first criterion
     * @param operator      the operator used for comparison between the criteria
     * @param name2         the name of the second criterion
     */
    public void DefineBinaryCriterion(String criterionName, String name1, String operator, String name2) {
        if (!Task.TaskValidator.isValidTaskName(criterionName)) {
            System.out.println("Invalid binary criterion name");
            return;
        }
        Criterion c1 = findCriterion(name1);
        Criterion c2 = findCriterion(name2);
        if (c1 == null && c2 == null) {
            System.out.println("There does not exist the criterion:" + name1 + ',' + name2);
            return;
        } else if (c1 == null) {
            System.out.println("There does not exist the criterion:" + name1);
            return;
        } else if (c2 == null) {
            System.out.println("There does not exist the criterion:" + name2);
            return;
        }
        if (!Objects.equals(operator, "&&") && !Objects.equals(operator, "||")) {
            System.out.println("Invalid logical operator" + operator);
            return;
        }
        if (isNameUnique(criterionName)) {
            CompositeCriterion criterion = new CompositeCriterion(criterionName, c1, operator, c2);
            CriterionList.add(criterion);
            System.out.println("A binary criterion has been defined: " + criterionName);
        } else {
            System.out.println("The criterion name already exists: " + criterionName);
        }
    }

    /**
     * Finds a criterion with the specified name in the list of criteria.
     *
     * @param name the name of the criterion to find
     * @return the criterion with the specified name, or null if not found
     */
    public Criterion findCriterion(String name) {
        Criterion result = null;
        for (Criterion i : CriterionList) {
            if (i.getCriterionName().equals(name)) {
                result = i;
            }
        }
        return result;
    }

    /**
     * Prints the details of a specific task identified by its name.
     *
     * @param taskName the name of the task to be printed
     */
    public void printTask(String taskName) {
        for (Task task : taskList) {
            if (task.getName().equals(taskName)) {
                System.out.println("Name: " + task.getName());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Prerequisites: " + task.getPrerequisites());
                return;
            }
        }
        System.out.println("Task not found.");
    }

    /**
     * Prints the details of all tasks in the task list.
     */
    public void printAllTasks() {
        for (Task task : taskList) {
            System.out.println("Name: " + task.getName());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Prerequisites: " + task.getPrerequisites());
            System.out.println();
        }
    }
    /**
     * Prints the basic criterion object by concatenating its property, operator, and value.
     *
     * @param i The BasicCriterion object to be printed.
     */
    public void printBasicCriteria(BasicCriterion i){
        System.out.print(i.getProperty()+i.getOperator() + i.getValue());
    }

    /**
     * Prints the composite criterion object recursively by printing its sub-criteria and operators.
     *
     * @param i The CompositeCriterion object to be printed.
     */
    public void printCompositeCriteria(CompositeCriterion i){
        try {
            if(i.getc1() instanceof BasicCriterion){
                BasicCriterion c1 = (BasicCriterion) i.getc1();
                printBasicCriteria(c1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            if(i.getc1() instanceof CompositeCriterion){
                CompositeCriterion c1 = (CompositeCriterion) i.getc1();
                printCompositeCriteria(c1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.print(i.getOperator());
        if (!(i.getOperator().equals("!"))){
            try {
                if(i.getc2() instanceof BasicCriterion){
                    BasicCriterion c2 = (BasicCriterion) i.getc2();
                    printBasicCriteria(c2);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if(i.getc2() instanceof CompositeCriterion){
                    CompositeCriterion c2 = (CompositeCriterion) i.getc2();
                    printCompositeCriteria(c2);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return;
    }

    /**
     * Prints all criteria objects in the CriterionList.
     */
    public void printAllCriteria(){
        for (Criterion i : CriterionList){
            try {
                if (i instanceof BasicCriterion){
                    BasicCriterion BC = (BasicCriterion) i;
                    printBasicCriteria(BC);
                    System.out.println();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (i instanceof CompositeCriterion){
                    CompositeCriterion CC = (CompositeCriterion) i;
                    printCompositeCriteria(CC);
                    System.out.println();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    /**
     * Retrieves the list of tasks.
     *
     * @return The list of tasks.
     */
    public List<Task> getTaskList() {
        return taskList;
    }

    /**
     * Reports the earliest finish time for a given task.
     *
     * @param taskName The name of the task to report the earliest finish time for.
     */
    public void reportEarliestFinishTime(String taskName) {
        Task exist = null;
        for (Task task : taskList) {
            if (task.getName().equals(taskName)) {
                exist = task;
                break;
            }
        }
        if (exist == null) {
            System.out.println("Task not found!");
            return;
        }

        double earliestFinishTime = calculateEarliestFinishTime(exist);
        System.out.println("Earliest finish time of " + taskName + ": " + earliestFinishTime);
    }

    /**
     * Searches for a task by name.
     *
     * @param name The name of the task to search for.
     * @return The found task, or null if not found.
     */
    public Task searchTask(String name) {
        Task exist = null;
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                exist = task;
                break;
            }
        }
        return exist;
    }

    /**
     * Calculates the earliest finish time for a given task.
     *
     * @param task The task to calculate the earliest finish time for.
     * @return The earliest finish time of the task.
     */
    public double calculateEarliestFinishTime(Task task) {
        double prerequisiteFinishTime = 0;
        String[] prerequisites = task.getPrerequisites().split(",");

        for (String prerequisite : prerequisites) {
            Task findTask = searchTask(prerequisite);
            double prerequisiteEarliestFinishTime = 0;
            try {
                SimpleTask simpleTask = (SimpleTask) findTask;
                prerequisiteEarliestFinishTime = simpleTask.getDuration();
            } catch (ClassCastException e) {
                // Handle the error appropriately, such as logging or throwing an exception.
            }
            prerequisiteFinishTime = Math.max(prerequisiteFinishTime, prerequisiteEarliestFinishTime);
        }

        try {
            if (task instanceof SimpleTask) {
                return prerequisiteFinishTime + ((SimpleTask) task).getDuration();
            } else {
                return prerequisiteFinishTime;
            }
        } catch (ClassCastException e) {
            System.out.println("Error: Failed to cast to SimpleTask.");
            // Handle the error appropriately, such as logging or throwing an exception.
            return prerequisiteFinishTime;
        }
    }
    /**
     * Reports the duration of a task.
     *
     * @param taskName the name of the task
     */
    public void ReportDuration(String taskName){
        Task exist = null;
        for (Task task : taskList) {
            if (task.getName().equals(taskName)) {
                exist = task;
                break;
            }
        }
        if (exist == null) {
            System.out.println("Task not found!");
            return;
        }

        double duration= calculateEarliestFinishTime(exist);
        System.out.println("The duration of " + taskName + " is " + duration);

    }
    /**
     * Checks if a given Task is a primitive task.
     * @param task The Task object to be checked
     * @return true if the Task is an instance of SimpleTask (primitive task), false otherwise.
     */
    public static boolean isPrimitive(Task task){
        return task instanceof SimpleTask; // this function is updated on 14/11/2023
    }
}
