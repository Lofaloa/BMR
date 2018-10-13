package pkg47923_bmr.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Contains the result components.
 *
 * @author g47923
 */
public class ResultPane extends GridPane {

    private final Label BMRLabel;
    private final TextField BMR;
    private final Label caloriesLabel;
    private final TextField calories;

    /**
     * Initializes this pane with two empty text fields: one for the resulting
     * BMR, the second for the calculated amount of calories.
     */
    public ResultPane() {
        this.BMRLabel = new Label("BMR");
        this.BMR = new TextField();
        this.caloriesLabel = new Label("Calories");
        this.calories = new TextField();
        addComponents();
    }

    /**
     * Sets the BMR text to the given value.
     * 
     * @param value the value to set the BMR to.
     */
    public void setBMR(double value) {
        BMR.setText(Double.toString(value));
    }

    /**
     * Sets the calories text to the given value.
     * 
     * @param value the value to set the calories to.
     */
    public void setCalories(double value) {
        calories.setText(Double.toString(value));
    }

    /**
     * Adds the components to this pane.
     */
    final void addComponents() {
        this.add(BMRLabel, 1, 0);
        this.add(BMR, 2, 0);
        this.add(caloriesLabel, 1, 1);
        this.add(calories, 2, 1);
    }

}
