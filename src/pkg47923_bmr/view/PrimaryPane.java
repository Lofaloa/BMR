package pkg47923_bmr.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pkg47923_bmr.model.BasalMetabolicRate;

/**
 *
 * @author g47923
 */
public class PrimaryPane extends VBox {

    private final SecondaryPane content;
    private final Button submit;

    public PrimaryPane() {
        this.content = new SecondaryPane();
        this.submit = new Button("Submit");
        setPaneProperties();
        setComponentsProperties();
        addComponents();
    }

    /**
     * Sets this pane properties.
     */
    final void setPaneProperties() {
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Sets the components properties of this pane.
     */
    final void setComponentsProperties() {
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    double bmr = bmr();
                    content.setBMR(bmr);
                    content.setCalories(calories(bmr));
                } catch (IllegalStateException | IllegalArgumentException ex) {
                    Alert fail = new Alert(Alert.AlertType.INFORMATION);
                    fail.setHeaderText("Failure");
                    fail.setContentText(ex.getMessage());
                    fail.showAndWait();
                }
            }
        });
    }

    /**
     * Gets the basal metabolic rate for the given data.
     *
     * @return the basal metabolic rate for the given data.
     */
    double bmr() {
        double size = content.getSize();
        double weight = content.getWeight();
        int age = content.getAge();
        String gender = content.getGender();
        return BasalMetabolicRate.BMR(gender.equals("Woman"), weight, size, age);
    }

    /**
     * Gets the calories needed for the given lifestyle based on the bmr.
     *
     * @param bmr is the basal metabolic rate of the user.
     * @return calories needed by the user.
     */
    double calories(double bmr) {
        return BasalMetabolicRate.calories(bmr, content.getLifeStyle());
    }

    /**
     * Adds the components to this pane.
     */
    final void addComponents() {
        this.getChildren().addAll(content, submit);
    }

}
