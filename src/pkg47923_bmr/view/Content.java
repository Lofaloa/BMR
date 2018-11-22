package pkg47923_bmr.view;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.HBox;
import pkg47923_bmr.model.LifeStyle;
import pkg47923_bmr.model.Person;

/**
 * Contains the content.
 *
 * @author g47923
 */
class Content extends HBox implements Observer {

    private final DataPane data;
    private final ResultPane result;

    /**
     * Initializes this pane with content.
     */
    public Content() {
        this.data = new DataPane();
        this.result = new ResultPane();
        
        addContent();
    }

    /**
     * Gets the size given by the user.
     *
     * @return the size given by the user.
     */
    double getSize() {
        return data.getSize();
    }

    /**
     * Gets the weight given by the user.
     *
     * @return the weight given by the user.
     */
    double getWeight() {
        return data.getWeight();
    }

    /**
     * Gets the age given by the user.
     *
     * @return the age given by the user.
     */
    int getAge() {
        return data.getAge();
    }

    /**
     * Gets the gender selected by the user.
     *
     * @return the gender selected by the user.
     */
    String getGender() {
        return data.getGender();
    }

    /**
     * Gets the life style selected by the user.
     *
     * @return the life style selected by the user.
     */
    LifeStyle getLifeStyle() {
        return data.getLifeStyle();
    }

    /**
     * Sets the BMR to the given value.
     *
     * @param value is the value to set the BMR to.
     */
    void setBMR(double value) {
        result.setBMR(value);
    }

    /**
     * Sets calories to the given value.
     *
     * @param value is the value to set the calories to.
     */
    void setCalories(double value) {
        result.setCalories(value);
    }

    /**
     * Adds the content to this pane.
     */
    final void addContent() {
        this.getChildren().addAll(data, result);
    }
    
    /**
     * Clears the content of the window.
     */
    void clear() {
        data.clear();
        result.clear();
    }

    @Override
    public void update(Observable o, Object o1) {
        Person user = (Person) o;
        result.setBMR(user.getBmr());
        result.setCalories(user.getCalories());
    }

}
