package pkg47923_bmr.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pkg47923_bmr.model.BasalMetabolicRate;
import pkg47923_bmr.model.LifeStyle;

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
                double size = content.getSize();
                double weight = content.getWeight();
                int age = content.getAge();
                //String gender = content.getGender();
                //LifeStyle lifestyle = content.getLifeStyle();
                //double bmr = BasalMetabolicRate.BMR(gender.equals("Woman"),
                //        weight, size, age);
                //double calories = BasalMetabolicRate.calories(bmr, lifestyle);
                System.out.println(size);
                System.out.println(weight);
                System.out.println(age);
                //System.out.println(gender);
                content.getGender();
                //System.out.println(lifestyle);
                //content.setBMR(bmr);
                //content.setCalories(calories);
            }
        });
    }

    /**
     * Adds the components to this pane.
     */
    final void addComponents() {
        this.getChildren().addAll(content, submit);
    }

}
