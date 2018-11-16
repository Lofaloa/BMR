package pkg47923_bmr.view;

import javafx.scene.control.TabPane;

/**
 * Represents a box containing data representation.
 *
 * @author g47923
 */
public class ChartsPane extends TabPane {

    private final ChartTab bmrWeightChartTab;
    private final ChartTab caloriesWeightChartTab;

    public ChartsPane() {
        this.bmrWeightChartTab = new ChartTab("BMR par rapport au poids", 
                new BMRWeightChartBox());
        this.caloriesWeightChartTab = new ChartTab("Calories par rapport au poids",
                new CaloriesWeightChartBox());
        addContent();
    }
    
    void addDataToCharts(double bmr, double calories, double weight, boolean isFemale) {
        addDataToBMRWeightChart(bmr, weight, isFemale);
        addDataToCaloriesWeightChart(calories, weight, isFemale);
    }

    private void addDataToBMRWeightChart(double bmr, double weight, boolean isFemale) {
        if (isFemale) {
            bmrWeightChart.addFemale(bmr, weight);
        } else {
            bmrWeightChart.addMale(bmr, weight);
        }
    }

    private void addDataToCaloriesWeightChart(double calories, double weight, boolean isFemale) {
        if (isFemale) {
            caloriesWeightChart.addFemale(calories, weight);
        } else {
            caloriesWeightChart.addMale(calories, weight);
        }
    }

    final void addContent() {
        bmrWeightChartTab.setText("BMR par rapport au poids");
        bmrWeightChartTab.setContent(bmrWeightChart);
        caloriesWeightChartTab.setText("Calories par rapport au poids");
        caloriesWeightChartTab.setContent(caloriesWeightChart);
        this.getTabs().addAll(bmrWeightChartTab, caloriesWeightChartTab);
    }

}
