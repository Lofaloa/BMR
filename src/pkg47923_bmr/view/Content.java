package pkg47923_bmr.view;

import javafx.scene.layout.HBox;
import pkg47923_bmr.model.LifeStyle;

/**
 * Contains the content.
 *
 * @author g47923
 */
public class Content extends HBox {

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
    public double getSize() {
        return data.getSize();
    }

    /**
     * Gets the weight given by the user.
     *
     * @return the weight given by the user.
     */
    public double getWeight() {
        return data.getWeight();
    }

    /**
     * Gets the age given by the user.
     *
     * @return the age given by the user.
     */
    public int getAge() {
        return data.getAge();
    }

    /**
     * Gets the gender selected by the user.
     *
     * @return the gender selected by the user.
     */
    public String getGender() {
        return data.getGender();
    }

    /**
     * Gets the life style selected by the user.
     *
     * @return the life style selected by the user.
     */
    public LifeStyle getLifeStyle() {
        return data.getLifeStyle();
    }

    /**
     * Sets the BMR to the given value.
     *
     * @param value is the value to set the BMR to.
     */
    public void setBMR(double value) {
        result.setBMR(value);
    }

    /**
     * Sets calories to the given value.
     *
     * @param value is the value to set the calories to.
     */
    public void setCalories(double value) {
        result.setCalories(value);
    }

    /**
     * Adds the content to this pane.
     */
    final void addContent() {
        this.getChildren().addAll(data, result);
    }

}
