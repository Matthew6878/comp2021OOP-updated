package hk.edu.polyu.comp.comp2021.tms.model;

/**
 * It is a composite task, which is a type of task that consists multiple subtasks.
 */
public class CompositeTask extends Task {
    private static final String label = "CT";
    /**
     * It is a constructor with the specified name, description, and prerequisites.
     *
     * @param name          The name of the composite task.
     * @param description   The description of the composite task.
     * @param prerequisites The prerequisites of the composite task.
     */
    public CompositeTask(String name, String description, String prerequisites) {
        super(name, description, prerequisites);
    }
    public String toString() {
        return label + '/' + getName() + '/' + getDescription() +
                '/' + getPrerequisites();
    }
}
