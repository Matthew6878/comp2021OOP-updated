package hk.edu.polyu.comp.comp2021.tms.model;

import java.util.Objects;
/**
 * The CompositeCriterion class is an implementation of the Criterion class.
 * This composite criterion is used to filter or
 * assess tasks according to particular attributes and circumstances.
 */
public class CompositeCriterion extends Criterion{ // this class is updated on 14/11/2023
    private static final String label = "CC";
    private String criterionName;
    private Criterion name1;
    private String operator;
    private Criterion name2;

    /**
     * It is the constructor of the negated criterion
     * @param criterionName it is the name of the criteria
     * @param name1 it is the name of the  criteria which is negated
     */
    public CompositeCriterion(String criterionName, Criterion name1) {
        // this constructor will be used to handle the negated criterion
        super(criterionName);
        this.name1 = name1;
        this.operator = "!";
    }

    /**
     * Constructs a CompositeCriterion with a binary criterion.
     *
     * @param criterionName The name of the composite criterion.
     * @param name1 The first criterion.
     * @param operator The operator to apply between the two criteria.
     * @param name2 The second criterion.
     */
    public CompositeCriterion(String criterionName, Criterion name1, String operator, Criterion name2) {
        // this constructor will be used to handle the binary criterion
        super(criterionName);
        this.name1 = name1;
        this.operator = operator;
        this.name2 = name2;
    }


     /**
     * It returns the criterion1.
     *
     * @return The criterion1.
     */
    public Criterion getc1(){return name1;}

    /**
     * It returns the criterion2.
     *
     * @return The criterion2.
     */
    public Criterion getc2(){return name2;}

    /**
     * It returns the operator of the criterion.
     *
     * @return The operator of the criterion.
     */
    public String getOperator() {
        return operator;
    }
    
    /**
     * Returns a string representation of the CompositeCriterion object.
     *
     * @return A string representation of the CompositeCriterion object.
     */
    @Override
    public String toString() {
        if (name2 == null){
            return label + '/'+ criterionName + '/' + name1.getCriterionName() +
                    '/' + operator;
        }
        return label + '/' + criterionName + '/' + name1.getCriterionName() +
                '/' + operator + '/' + name2.getCriterionName();
    }

    /**
     * Evaluates the criterion according to a given Task object.
     * @param task It can be simple task or composite task
     * @return return true if the task fulfill the criteria, false otherwise
     */
    public boolean eval(Task task){
        if (task == null){return false;}
        if (operator.equals("!")){
            try {
                if (name1 instanceof BasicCriterion) {
                    return !((BasicCriterion) name1).eval(task);
                }
                else {
                    return !(((CompositeCriterion) name1).eval(task));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else if (operator.equals("||")) {
            try {
                if (name1 instanceof BasicCriterion && name2 instanceof BasicCriterion){
                    return ((BasicCriterion)name1).eval(task) || ((BasicCriterion)name2).eval(task);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (name1 instanceof CompositeCriterion && name2 instanceof CompositeCriterion) {
                    return ((CompositeCriterion)name1).eval(task) || ((CompositeCriterion)name2).eval(task);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (name1 instanceof BasicCriterion){
                    return ((BasicCriterion)name1).eval(task) || ((CompositeCriterion)name2).eval(task);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (name1 instanceof CompositeCriterion){
                    return ((CompositeCriterion)name1).eval(task) || ((BasicCriterion)name2).eval(task);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else if (operator.equals("&&")) {
            try {
                if (name1 instanceof BasicCriterion && name2 instanceof BasicCriterion){
                    return ((BasicCriterion)name1).eval(task) && ((BasicCriterion)name2).eval(task);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (name1 instanceof CompositeCriterion && name2 instanceof CompositeCriterion) {
                    return ((CompositeCriterion)name1).eval(task) && ((CompositeCriterion)name2).eval(task);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (name1 instanceof BasicCriterion){
                    return ((BasicCriterion)name1).eval(task) && ((CompositeCriterion)name2).eval(task);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                if (name1 instanceof CompositeCriterion){
                    return ((CompositeCriterion)name1).eval(task) && ((BasicCriterion)name2).eval(task);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    /**
     * It returns the name of the criterion 1.
     *
     * @return The name of the criterion 1.
     */
    public String getName1() {
        return name1.getCriterionName();
    }

    /**
     * It set the name of the composite criterion.
     *
     * @param criterionName The new name for the composite criterion.
     */

    public void setC3Name(String criterionName) {
        this.criterionName = criterionName;
    }

    /**
     * It returns the name of the criterion 2.
     *
     * @return The name of the criterion 2.
     */
    public String getName2() {
        return name2.getCriterionName();
    }

    /**
     * It set the operator for the composite criterion.
     *
     * @param operator The new operator for the composite criterion.
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * It set the criterion 1.
     *
     * @param name1 The new criterion 1 for the composite criterion.
     */
    public void setName1(Criterion name1) {
        this.name1 = name1;
    }
}
