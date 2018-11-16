package pkg47923_bmr.view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;

/**
 * Represents a pane containing a line chart of calories vs weight.
 *
 * @author g47923
 */
public class CaloriesWeightChartTab extends Tab {

    private final NumberAxis caloriesAxis;
    private final NumberAxis weightAxis;
    private final LineChart<Number, Number> chart;
    private final XYChart.Series male;
    private final XYChart.Series female;

    public CaloriesWeightChartTab() {
        this.caloriesAxis = new NumberAxis();
        this.weightAxis = new NumberAxis();
        this.chart = new LineChart<>(weightAxis, caloriesAxis);
        this.male = new XYChart.Series<>();
        this.male.setName("Homme");
        this.female = new XYChart.Series<>();
        this.female.setName("Femme");
        addContent();
        setProperties();
    }

    final void setProperties() {
        caloriesAxis.setLabel("Calories");
        weightAxis.setLabel("Weight (kg)");
        chart.setTitle("Calories par rapport au poids (kg)");
        setText("Caloriespar rapport au poids");
    }

    void addMale(double calories, double kg) {
        male.getData().add(new XYChart.Data<>(calories, kg));
    }

    void addFemale(double calories, double kg) {
        female.getData().add(new XYChart.Data<>(calories, kg));
    }

    final void addSeries() {
        chart.getData().addAll(male, female);
    }

    final void addContent() {
        addSeries();
        this.setContent(chart);
    }

}
