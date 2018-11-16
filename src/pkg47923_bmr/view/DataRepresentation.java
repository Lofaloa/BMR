package pkg47923_bmr.view;

import javafx.scene.layout.VBox;

/**
 * Represents a box containing data representation.
 *
 * @author g47923
 */
public class DataRepresentation extends VBox {

    private final ChartPane chart;

    public DataRepresentation() {
        this.chart = new ChartPane();
        addContent();
    }

    void addData(double bmr, double weight, boolean isFemale) {
        if (isFemale) {
            chart.addFemale(bmr, weight);
        } else {
            chart.addMale(bmr, weight);
        }
    }

    final void addContent() {
        this.getChildren().add(chart);
    }

}
