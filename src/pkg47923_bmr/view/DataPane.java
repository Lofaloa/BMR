package pkg47923_bmr.view;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import pkg47923_bmr.model.LifeStyle;

/**
 * Contains the components managing user data.
 *
 * @author g47923
 */
public class DataPane extends GridPane {

    private final Label sizeLabel;
    private final TextField size;
    private final Label weightLabel;
    private final TextField weight;
    private final Label ageLabel;
    private final TextField age;
    private final Label sexeLabel;
    private final RadioButton female;
    private final RadioButton male;
    private final Label lifeStyleLabel;
    private final ComboBox<LifeStyle> lifestyle;

    /**
     * Initializes this pane with user controls for his/ her size, weight, age,
     * sex and lifestyle.
     */
    public DataPane() {
        this.sizeLabel = new Label("Size (cm)");
        this.size = new TextField();
        this.weightLabel = new Label("Weight (kg)");
        this.weight = new TextField();
        this.ageLabel = new Label("Age (years)");
        this.age = new TextField();
        this.sexeLabel = new Label("Sex");
        this.female = new RadioButton("Woman");
        this.male = new RadioButton("Man");
        this.lifeStyleLabel = new Label("Life style");
        this.lifestyle = new ComboBox<>();
        addComponents();
    }

    /**
     * Adds all the components to this pane.
     */
    final void addComponents() {
        this.add(sizeLabel, 1, 0);
        this.add(size, 2, 0);
        this.add(weightLabel, 1, 1);
        this.add(weight, 2, 1);
        this.add(ageLabel, 1, 2);
        this.add(age, 2, 2);
        this.add(sexeLabel, 1, 3);
        ToggleGroup sexe = new ToggleGroup();
        female.setToggleGroup(sexe);
        male.setToggleGroup(sexe);
        this.add(female, 2, 3);
        this.add(male, 3, 3);
        this.add(lifeStyleLabel, 1, 4);
        this.lifestyle.getItems().addAll(LifeStyle.EXTREMELY_ACTIVE,
                LifeStyle.VERY_ACTIVE,
                LifeStyle.ACTIVE,
                LifeStyle.NOT_MUCH_ACTIVE,
                LifeStyle.SEDENTARY);
    }

}
