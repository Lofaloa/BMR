package pkg47923_bmr.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import pkg47923_bmr.model.LifeStyle;

/**
 * Contains the components managing user data.
 *
 * @author g47923
 */
class DataPane extends GridPane {

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
        this.title = new Label("Données");
        this.sizeLabel = new Label("Taille (cm)");
        this.size = new TextField();
        this.weightLabel = new Label("Poids (kg)");
        this.weight = new TextField();
        this.ageLabel = new Label("Âge");
        this.age = new TextField();
        this.sexeLabel = new Label("Genre");
        this.gender = new ToggleGroup();
        this.female = new RadioButton("Femme");
        this.male = new RadioButton("Homme");
        this.lifeStyleLabel = new Label("Style de vie");
        this.lifestyle = new ComboBox<>();
        setGridProperties();
        setComponentsProperties();
        addComponents();
        setHandlers();
    }

    /**
     * Gets the size typed by the user.
     *
     * @return the size typed by the user.
     */
    double getSize() {
        if (size.getText().isEmpty()) {
            throw new IllegalStateException("Taille nécessaire");
        }
        if (!size.getText().matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("La taille doit être une donnée "
                    + "numérique");
        }
        if (Double.parseDouble(size.getText()) < 50
                || 300 < Double.parseDouble(size.getText())) {
            throw new IllegalArgumentException("Taille invalide, doit être "
                    + "comprise entre 50 et 300 cm.");
        }
        return Double.parseDouble(size.getText());
    }

    /**
     * Gets the weight typed by the user.
     *
     * @return the weight typed by the user.
     */
    double getWeight() {
        System.out.println();
        if (weight.getText().isEmpty()) {
            throw new IllegalStateException("Poids nécessaire.");
        }
        if (!weight.getText().matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("Le poids doit être une valeur "
                    + "numérique.");
        }
        if (Double.parseDouble(weight.getText()) <= 1) {
            throw new IllegalArgumentException("Poids invalide, doit être"
                    + " supérieur à 1 kg.");
        }
        return Double.parseDouble(weight.getText());
    }

    /**
     * Gets the weight typed by the user.
     *
     * @return the weight typed by the user.
     */
    int getAge() {
        if (size.getText().isEmpty()) {
            throw new IllegalStateException("Âge nécessaire.");
        }
        if (!size.getText().matches("^\\d+$")) {
            throw new IllegalArgumentException("L'âge doit être une valeur "
                    + "numérique.");
        }
        if (Double.parseDouble(size.getText()) <= 1) {
            throw new IllegalArgumentException("Âge invalide, doit être supérieur"
                    + " ou égal à 1 an.");
        }
        return Integer.parseInt(age.getText());
    }

    /**
     * Gets the gender selected by the user.
     *
     * @return the gender selected by the user.
     */
    String getGender() {
        RadioButton selectedGender = (RadioButton) gender.getSelectedToggle();
        return selectedGender.getText();
    }

    /**
     * Gets the life style selected by the user.
     *
     * @return the life style selected by the user.
     */
    LifeStyle getLifeStyle() {
        if (lifestyle.getSelectionModel().isEmpty()) {
            throw new IllegalStateException("Style de vie nécessaire.");
        }
        return lifestyle.getValue();
    }

    /**
     * Clears the data.
     */
    void clear() {
        size.clear();
        weight.clear();
        age.clear();
        gender.selectToggle(female);
        lifestyle.valueProperty().set(null);
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
     * Sets the properties for all this pane components.
     */
    final void setComponentsProperties() {
        this.title.setUnderline(true);
        this.title.setFont(new Font("Arial", 16));
        this.size.setPromptText("Taille en centimètres...");
        this.weight.setPromptText("Poids en kilogrammes...");
        this.age.setPromptText("Âge...");
        this.female.setSelected(true);
        this.lifestyle.setPromptText("Choix du style de vie...");
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
        this.add(male, 2, 5);
        this.add(lifeStyleLabel, 1, 6);
        this.lifestyle.getItems().addAll(LifeStyle.EXTREMELY_ACTIVE,
                LifeStyle.VERY_ACTIVE,
                LifeStyle.ACTIVE,
                LifeStyle.NOT_MUCH_ACTIVE,
                LifeStyle.SEDENTARY);
        this.add(lifestyle, 2, 6);
    }

    /**
     * Sets this pane text fields handler.
     */
    final void setHandlers() {
        age.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!Character.isDigit(event.getCharacter().charAt(0))) {
                    event.consume();
                }
            }
        });
        weight.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!Character.isDigit(event.getCharacter().charAt(0))) {
                    event.consume();
                }
            }
        });
        size.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!Character.isDigit(event.getCharacter().charAt(0))) {
                    event.consume();
                }
            }
        });

    }

}
