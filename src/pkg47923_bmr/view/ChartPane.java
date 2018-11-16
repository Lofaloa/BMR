package pkg47923_bmr.view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

/**
 * Represents the pane containing a line chart.
 *
 * @author g47923
 */
public class ChartPane extends VBox {

    private final NumberAxis bmrAxis;
    private final NumberAxis weightAxis;
    private final LineChart<Number, Number> chart;
    private final XYChart.Series male;
    private final XYChart.Series female;

    public ChartPane() {
        this.bmrAxis = new NumberAxis();
        this.weightAxis = new NumberAxis();
        this.chart = new LineChart<>(weightAxis, bmrAxis);
        this.male = new XYChart.Series<>();
        this.male.setName("Homme");
        this.female = new XYChart.Series<>();
        this.female.setName("Femme");
        addContent();
        setProperties();
    }

    final void setProperties() {
        bmrAxis.setLabel("BMR");
        weightAxis.setLabel("Weight (kg)");
        chart.setTitle("BMR par rapport au poids (kg)");
    }

    void addMale(double bmr, double kg) {
        male.getData().add(new XYChart.Data<>(bmr, kg));
    }

    void addFemale(double bmr, double kg) {
        female.getData().add(new XYChart.Data<>(bmr, kg));
    }
    
    final void addSeries() {
        chart.getData().addAll(male, female);
    }
    
    final void addContent() {
        addSeries();
        this.getChildren().add(chart);
    }

}
