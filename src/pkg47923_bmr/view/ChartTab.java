package pkg47923_bmr.view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;

/**
 * Represents a tab that contains a line chart.
 *
 * @author g47923
 */
public class ChartTab extends Tab {

    private final NumberAxis xAxis;
    private final NumberAxis yAxis;
    private final LineChart<Number, Number> chart;
    private final XYChart.Series male;
    private final XYChart.Series female;

    /**
     * Initializes this tab of the given title with its axis named after the
     * given axis labels.
     *
     * @param title is the title of this tab.
     * @param xAxisLabel is the x axis name.
     * @param yAxisLabel is the y axis name.
     */
    public ChartTab(String title, String xAxisLabel, String yAxisLabel) {
        this.xAxis = new NumberAxis();
        this.yAxis = new NumberAxis();
        this.chart = new LineChart<>(xAxis, yAxis);
        this.male = new XYChart.Series<>();
        this.female = new XYChart.Series<>();
        addContent();
        setProperties(title, xAxisLabel, yAxisLabel);
    }

    /**
     * Sets the properties of this tab.
     *
     * @param title is this title tab.
     * @param xAxisLabel is this x axis name.
     * @param yAxisLabel is this y axis name.
     */
    private void setProperties(String title, String xAxisLabel, String yAxisLabel) {
        xAxis.setLabel(xAxisLabel);
        yAxis.setLabel(yAxisLabel);
        this.male.setName("Homme");
        this.female.setName("Femme");
        chart.setTitle(title);
        setText(title);
        setClosable(false);
    }

    /**
     * Adds a point in this tab chart at the given coordinates in the male line.
     *
     * @param x is the x coordinate of the new data.
     * @param y is the y coordinate of the new data.
     */
    void addMale(double x, double y) {
        male.getData().add(new XYChart.Data<>(x, y));
    }

    /**
     * Adds a point in this tab chart at the given coordinates in the female
     * line.
     *
     * @param x is the x coordinate of the new data.
     * @param y is the y coordinate of the new data.
     */
    void addFemale(double x, double y) {
        female.getData().add(new XYChart.Data<>(x, y));
    }

    private void addSeries() {
        chart.getData().addAll(male, female);
    }

    private void addContent() {
        addSeries();
        this.setContent(chart);
    }

}
