package pkg47923_bmr.view;

import java.text.DecimalFormat;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * Contains the result components.
 *
 * @author g47923
 */
public class ResultPane extends GridPane {

    private final Label title;
    private final Label BMRLabel;
    private final TextField BMR;
    private final Label caloriesLabel;
    private final TextField calories;

    /**
     * Initializes this pane with two empty text fields: one for the resulting
     * BMR, the second for the calculated amount of calories.
     */
    public ResultPane() {
        this.title = new Label("Résultats");
        this.BMRLabel = new Label("BMR");
        this.BMR = new TextField();
        this.caloriesLabel = new Label("Calories");
        this.calories = new TextField();
        setGridProperties();
        setComponentsProperties();
        addComponents();
    }

    /**
     * Sets the BMR text to the given value.
     *
     * @param value the value to set the BMR to.
     */
    public void setBMR(double value) {
        DecimalFormat df = new DecimalFormat("#.###");
        BMR.setText(df.format(value));
    }

    /**
     * Sets the calories text to the given value.
     *
     * @param value the value to set the calories to.
     */
    public void setCalories(double value) {
        DecimalFormat df = new DecimalFormat("#.###");
        calories.setText(df.format(value));
    }

    /**
     * Sets the properties of this grid.
     */
    final void setGridProperties() {
        this.setVgap(10);
        this.setHgap(10);
        this.setPadding(new Insets(10, 10, 10, 10));
    }

    /**
     * Sets the properties of this pane components.
     */
    final void setComponentsProperties() {
        this.title.setUnderline(true);
        this.title.setFont(new Font("Arial", 16));
        this.BMR.setEditable(false);
        this.calories.setEditable(false);
    }

    /**
     * Adds the components to this pane.
     */
    final void addComponents() {
        this.add(title, 1, 0);
        this.add(BMRLabel, 1, 1);
        this.add(BMR, 2, 1);
        this.add(caloriesLabel, 1, 2);
        this.add(calories, 2, 2);
    }

}
