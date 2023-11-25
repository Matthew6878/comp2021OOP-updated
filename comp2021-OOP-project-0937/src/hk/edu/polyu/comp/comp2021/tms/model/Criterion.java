package hk.edu.polyu.comp.comp2021.tms.model;

/**
 * It is a criterion used for handling composite criteria.
 */
public class Criterion {
    // created for handling the composite criteria on 15/11/2023
    private String criterionName;
    /**
     * It is a constructor with the specified criterion name.
     *
     * @param criterionName The name of the criterion.
     */
    public Criterion(String criterionName){
        this.criterionName = criterionName;
    }

    /**
     * It returns the name of the criterion.
     *
     * @return The name of the criterion.
     */
    public String getCriterionName() {
        return criterionName;
    }

    /**
     * It sets the name of the criterion.
     *
     * @param criterionName The new name of the criterion.
     */
    public void setCriterionName(String criterionName) {
        this.criterionName = criterionName;
    }
}
