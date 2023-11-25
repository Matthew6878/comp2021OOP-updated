package hk.edu.polyu.comp.comp2021.tms.model;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * It is a abstract class of a task with a name, description, and prerequisites.
 */
public abstract class Task {
    private String name;
    private String description;
    private String prerequisites;

    /**
     * It is a constructor of a Task with the specified name, description, and prerequisites.
     *
     * @param name          The name of the task.
     * @param description   The description of the task.
     * @param prerequisites The prerequisites of the task.
     */
    public Task(String name, String description, String prerequisites) {
        this.name = name;
        this.description = description;
        this.prerequisites = prerequisites;
    }

    /**
     * Returns the name of the task.
     *
     * @return The name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the task.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the prerequisites of the task.
     *
     * @return The prerequisites of the task.
     */
    public String getPrerequisites() {
        return prerequisites;
    }

    /**
     * Sets the name of the task.
     *
     * @param name The name of the task.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of the task.
     *
     * @param description The description of the task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the prerequisites of the task.
     *
     * @param prerequisites The prerequisites of the task.
     */
    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    /**
     * Nested class for validating task-related properties.
     */
    static class TaskValidator {

        /**
         * Checks if a task name is valid.
         *
         * @param taskName The task name to validate.
         * @return true if the task name is valid, false otherwise.
         */
        public static boolean isValidTaskName(String taskName) {

            if (taskName.length() > 8) {
                return false;
            }

            if (!Character.isLetter(taskName.charAt(0))) {
                return false;
            }

            for (int i = 1; i < taskName.length(); i++) {
                char currentChar = taskName.charAt(i);
                if (!Character.isLetterOrDigit(currentChar)) {
                    return false;
                }
            }

            return true;
        }

        /**
         * Checks if a description is valid.
         *
         * @param description The description to validate.
         * @return true if the description is valid, false otherwise.
         */
        public static boolean isValidDescription(String description) {
            if (description == null || description.isEmpty()) {
                return false;
            }

            for (int i = 1; i < description.length(); i++) {
                char currentChar = description.charAt(i);
                if (!Character.isLetterOrDigit(currentChar) && currentChar != '-') {
                    return false;
                }
            }

            return true;
        }

        /**
         * Checks if a duration is valid.
         *
         * @param duration The duration to validate.
         * @return true if the duration is valid, false otherwise.
         */
        public static boolean isValidDuration(double duration) {
            // Duration should be a positive real number
            return duration > 0;
        }

        /**
         * Checks if prerequisites are valid.
         *
         * @param prerequisites The prerequisites to validate.
         * @param definedTasks  The list of defined tasks.
         * @return true if the prerequisites are valid, false otherwise.
         */
        public static boolean isValidPrerequisites(String prerequisites, List<Task> definedTasks) {
            if (prerequisites.equals(",")) {
                return true;
            }
            if (prerequisites.length() == 1) {

            }
            Set<String> definedTaskNames = new HashSet<>();
            String[] taskNames = prerequisites.split(",");
            for (Task task : definedTasks) {
                definedTaskNames.add(task.getName());
            }

            for (String taskName : taskNames) {
                if (!definedTaskNames.contains(taskName)) {
                    return false; // Prerequisite task is not defined
                }
            }
            return true; // All prerequisites are satisfied
        }
    }
}

