package hk.edu.polyu.comp.comp2021.tms.model;

/**
 * It is a class of simple task, which is a basic unit of work with a duration.
 */
public class SimpleTask extends Task {
    private static final String label = "ST";
    private double duration;

    /**
     * It is a constructor of the specified name, description, duration, and prerequisites.
     *
     * @param name          The name of the simple task.
     * @param description   The description of the simple task.
     * @param duration      The duration of the simple task.
     * @param prerequisites The prerequisites of the simple task.
     */
    public SimpleTask(String name, String description, double duration, String prerequisites) {
        super(name, description, prerequisites);
        this.duration = duration;
    }

    /**
     * Returns the duration of the simple task.
     *
     * @return The duration of the simple task.
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the simple task.
     *
     * @param duration The duration of the simple task.
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Returns a string representation of the SimpleTask object.
     *
     * @return A string representation of the SimpleTask object.
     */
    @Override
    public String toString() {
        return label + '/' + getName() + '/' + getDescription() + '/' + getDuration() +
                '/' + getPrerequisites();
    }
}
