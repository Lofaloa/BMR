package pkg47923_bmr.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import pkg47923_bmr.model.LifeStyle;
import pkg47923_bmr.model.Person;

/**
 *
 * @author g47923
 */
public class BMRViewController implements Initializable {

    private Person user;

    @FXML
    private TextField size;

    @FXML
    private TextField weight;

    @FXML
    private TextField age;

    @FXML
    private ToggleGroup gender;

    @FXML
    private ComboBox<LifeStyle> lifestyle;

    @FXML
    private TextField bmr;

    @FXML
    private TextField calories;

    public BMRViewController(Person user) {
        System.out.println("Constructor of bmr is run");
        this.user = user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void handleCalculate(ActionEvent event) {
        user.setData(gender.getSelectedToggle().equals("Femme"),
                        Double.parseDouble(weight.getText()),
                        Double.parseDouble(size.getText()),
                        Integer.parseInt(age.getText()),
                        lifestyle.getValue());
        bmr.setText(Double.toString(user.getBmr()));
        calories.setText(Double.toString(user.getCalories()));
    }

}
