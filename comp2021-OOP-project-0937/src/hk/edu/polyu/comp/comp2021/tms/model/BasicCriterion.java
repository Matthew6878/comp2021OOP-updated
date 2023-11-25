package hk.edu.polyu.comp.comp2021.tms.model;

/**
 * The BasicCriterion class is an implementation of the Criterion class.
 * This basic criterion is used to filter or
 * assess tasks according to particular attributes and circumstances.
 */
public class BasicCriterion extends Criterion{
    private static final String label = "BC";
    private String criterionName;
    private String property;
    private String operator;
    private String value; // converted to string on 14/11/2023 for handle the property such as name

    /**
     * It is the constructor of the BasicCriterion
     * @param criterionName it is the name of the criterion
     * @param property it is the property of the criterion
     * @param operator it is the operator of the criterion
     * @param value it is the value of the criterion
     */
    public BasicCriterion(String criterionName, String property, String operator, String value) {
        super(criterionName);
        this.property = property;
        this.operator = operator;
        this.value = value;
    }




    /**
     * It returns the property of the criterion.
     *
     * @return The property of the criterion.
     */
    public String getProperty() {
        return property;
    }

    /**
     * It returns the operator of the criterion.
     *
     * @return The operator of the criterion.
     */
    public String getOperator() {
        return operator;
    }

    /**
     * It returns the value of the criterion.
     *
     * @return The value of the criterion.
     */
    public String getValue() {
        return value;
    }

    public String toString() {
        return label + '/' + getCriterionName() + '/' + property + '/' + operator +
                '/' + value;
    }
    /**
     * Evaluates the criterion according to a given Task object.
     *
     * @param task The Task object to evaluate the criterion against.
     * @return true if the task is satisfied by the criterion, false otherwise.
     * @throws IllegalStateException if the property value is unexpected.
     */
    public boolean eval(Task task) {
        // this is updated on 14/11/2023
        if (task == null){return false;}
        if (task instanceof SimpleTask) {
            SimpleTask simpletask = (SimpleTask) task;
            if (property == "name") {
                return simpletask.getName().contains(value);
            } else if (property == "description") {
                return simpletask.getDescription().contains(value);
            } else if (property == "duration") {
                if (operator == ">") {
                    return simpletask.getDuration() > Double.parseDouble(value);
                } else if (operator == "<") {
                    return simpletask.getDuration() < Double.parseDouble(value);
                } else if (operator == ">=") {
                    return simpletask.getDuration() >= Double.parseDouble(value);
                } else if (operator == "<=") {
                    return simpletask.getDuration() <= Double.parseDouble(value);
                } else if (operator == "==") {
                    return simpletask.getDuration() == Double.parseDouble(value);
                } else if (operator == "!=") {
                    return simpletask.getDuration() != Double.parseDouble(value);
                }
            } else if (property == "prerequisites") {
                return simpletask.getPrerequisites().contains(value);
            } else if(property == "isPrimitive"){return true;}
            else {
                throw new IllegalStateException("Unexpected value: " + property);
            }
        }  else {
            CompositeTask compositetask = (CompositeTask) task;
            if (property == "name"){
                    return compositetask.getName().contains(value);
            } else if (property == "description") {
                return compositetask.getDescription().contains(value);
            } else if (property == "subtasks") {
                return compositetask.getPrerequisites().contains(value);
            } else if(property == "isPrimitive"){return false;}
            else{
                throw new IllegalStateException("Unexpected value: " + property);
            }
        }
        return false;
    }
    /**
     * It sets the value of the property in the basic criterion.
     *
     * @param property It is the new value for the property
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * It sets the value of the operator in the basic criterion.
     *
     * @param operator It is the new value for the operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * It sets the value of the value in the basic criterion.
     *
     * @param value It is the new value for the value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * It sets the name of  the basic criterion.
     *
     * @param criterionName It is the new name for the criterion
     */

    public void setC1Name(String criterionName) {
        this.criterionName = criterionName;
    }

    /**
     * It returns the name of the criterion.
     *
     * @return The name of the criterion.
     */
    public String getBasicCriterionName() {
        return criterionName;
    }
}
