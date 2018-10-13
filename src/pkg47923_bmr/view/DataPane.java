package pkg47923_bmr.view;

import javafx.geometry.Insets;
import javafx.scene.text.Font;
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

    private final Label title;
    private final Label sizeLabel;
    private final TextField size;
    private final Label weightLabel;
    private final TextField weight;
    private final Label ageLabel;
    private final TextField age;
    private final Label sexeLabel;
    private final ToggleGroup gender;
    private final RadioButton female;
    private final RadioButton male;
    private final Label lifeStyleLabel;
    private final ComboBox<LifeStyle> lifestyle;

    /**
     * Initializes this pane with user controls for his/ her size, weight, age,
     * sex and lifestyle.
     */
    public DataPane() {
        this.title = new Label("Datas");
        this.sizeLabel = new Label("Size (cm)");
        this.size = new TextField();
        this.weightLabel = new Label("Weight (kg)");
        this.weight = new TextField();
        this.ageLabel = new Label("Age (years)");
        this.age = new TextField();
        this.sexeLabel = new Label("Sex");
        this.gender = new ToggleGroup();
        this.female = new RadioButton("Woman");
        this.male = new RadioButton("Man");
        this.lifeStyleLabel = new Label("Life style");
        this.lifestyle = new ComboBox<>();
        setGridProperties();
        setComponentsProperties();
        addComponents();
    }

    /**
     * Gets the size typed by the user.
     *
     * @return the size typed by the user.
     */
    public double getSize() {
        if (size.getText().isEmpty()) {
            throw new IllegalStateException("Please insert your size.");
        }
        if (!size.getText().matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("The size should be a number.");
        }
        if (Double.parseDouble(size.getText()) < 50
                || 300 < Double.parseDouble(size.getText())) {
            throw new IllegalArgumentException("Please enter a valid"
                    + " size, it should be between 50 cm and 300 cm.");
        }
        return Double.parseDouble(size.getText());
    }

    /**
     * Gets the weight typed by the user.
     *
     * @return the weight typed by the user.
     */
    public double getWeight() {
        if (size.getText().isEmpty()) {
            throw new IllegalStateException("Please insert your weight.");
        }
        if (!size.getText().matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("The weight should be a number.");
        }
        if (Double.parseDouble(size.getText()) <= 1) {
            throw new IllegalArgumentException("The weight should be more than 1 kg.");
        }
        return Double.parseDouble(size.getText());
    }

    /**
     * Gets the weight typed by the user.
     *
     * @return the weight typed by the user.
     */
    public int getAge() {
        if (size.getText().isEmpty()) {
            throw new IllegalStateException("Please insert your age.");
        }
        if (!size.getText().matches("^\\d+$")) {
            throw new IllegalArgumentException("The age should be a number.");
        }
        if (Double.parseDouble(size.getText()) <= 1) {
            throw new IllegalArgumentException("The age should be more than 1");
        }
        return Integer.parseInt(age.getText());
    }

    /**
     * Gets the gender selected by the user.
     *
     * @return the gender selected by the user.
     */
    public String getGender() {
        RadioButton selectedGender = (RadioButton) gender.getSelectedToggle();
        return selectedGender.getText();
    }

    /**
     * Gets the life style selected by the user.
     *
     * @return the life style selected by the user.
     */
    public LifeStyle getLifeStyle() {
        if (lifestyle.getSelectionModel().isEmpty()) {
            throw new IllegalStateException("No lifestyle has been selected.");
        }
        return lifestyle.getValue();
    }

    /**
     * Sets the properties of this grid.
     */
    final void setGridProperties() {
        this.setPadding(new Insets(10, 10, 10, 10));
    }

    /**
     * Sets the properties for all this pane components.
     */
    final void setComponentsProperties() {
        this.title.setUnderline(true);
        this.title.setFont(new Font("Arial", 16));
        this.size.setPromptText("Enter your size...");
        this.weight.setPromptText("Enter your weight...");
        this.age.setPromptText("Enter your age...");
        this.female.setSelected(true);
        this.lifestyle.setPromptText("Choose your activity level...");
    }

    /**
     * Adds all the components to this pane.
     */
    final void addComponents() {
        this.add(title, 1, 0);
        this.add(sizeLabel, 1, 1);
        this.add(size, 2, 1);
        this.add(weightLabel, 1, 2);
        this.add(weight, 2, 2);
        this.add(ageLabel, 1, 3);
        this.add(age, 2, 3);
        this.add(sexeLabel, 1, 4);
        female.setToggleGroup(gender);
        male.setToggleGroup(gender);
        this.add(female, 2, 4);
        this.add(male, 3, 4);
        this.add(lifeStyleLabel, 1, 5);
        this.lifestyle.getItems().addAll(LifeStyle.EXTREMELY_ACTIVE,
                LifeStyle.VERY_ACTIVE,
                LifeStyle.ACTIVE,
                LifeStyle.NOT_MUCH_ACTIVE,
                LifeStyle.SEDENTARY);
        this.add(lifestyle, 2, 5);
    }

}
