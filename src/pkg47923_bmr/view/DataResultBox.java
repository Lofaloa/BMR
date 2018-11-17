package pkg47923_bmr.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pkg47923_bmr.model.Person;

/**
 * Represents the box the managing the
 *
 * @author g47923
 */
public class DataResultBox extends VBox {

    private final int WINDOW_HEIGHT = 200;
    private final int WINDOW_WIDTH = 500;

    private final Content content;
    private final Button submit;
    private final Button clear;

    private final Person user;

    public DataResultBox(Person user) {
        this.user = user;
        this.content = new Content();
        this.submit = new Button("Calculer mon BMR");
        this.clear = new Button("Clear");
        addSubmitEventHandler();
        addClearEventHandler();
        setBoxProperties();
        setComponentsProperties();
        addComponents();
    }

    /**
     * Sets this pane properties.
     */
    final void setBoxProperties() {
        setSpacing(15);
        setPadding(new Insets(0, 10, 0, 10));
    }

    private void addSubmitEventHandler() {
        submit.setOnAction((ActionEvent event) -> {
            try {
                user.setData(content.getGender().equals("Femme"),
                        content.getWeight(),
                        content.getSize(),
                        content.getAge(),
                        content.getLifeStyle());
            } catch (IllegalStateException | IllegalArgumentException ex) {
                Alert fail = new Alert(Alert.AlertType.WARNING);
                fail.setHeaderText("Valeur erronée!");
                fail.setContentText(ex.getMessage());
                fail.showAndWait();
            }
            event.consume();
        });
    }

    private void addClearEventHandler() {
        clear.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("clearing");
                content.clear();
            }
        });
    }

    /**
     * Sets the components properties of this pane.
     */
    private void setComponentsProperties() {
        submit.setMinWidth(600);
        clear.setMinWidth(600);
    }

    /**
     * Adds the components to this pane.
     */
    private void addComponents() {
        this.getChildren().addAll(content, submit, clear);
    }

    /**
     * Updates the content of this pane.
     */
    void update() {
        content.setBMR(user.getBmr());
        content.setCalories(user.getCalories());
    }

}
