package pkg47923_bmr.view;

import javafx.scene.control.TabPane;

/**
 * Represents a box containing data representation.
 *
 * @author g47923
 */
public class ChartsPane extends TabPane {

    private final BMRWeightChartTab bmrWeightChartTab;
    private final CaloriesWeightChartTab caloriesWeightChartTab;

    public ChartsPane() {
        this.bmrWeightChartTab = new BMRWeightChartTab();
        this.caloriesWeightChartTab = new CaloriesWeightChartTab();
        addContent();
    }

    void addDataToCharts(double bmr, double calories, double weight, boolean isFemale) {
        addDataToBMRWeightChart(bmr, weight, isFemale);
        addDataToCaloriesWeightChart(calories, weight, isFemale);
    }

    private void addDataToBMRWeightChart(double bmr, double weight, boolean isFemale) {
        if (isFemale) {
            bmrWeightChartTab.addFemale(bmr, weight);
        } else {
            bmrWeightChartTab.addMale(bmr, weight);
        }
    }

    private void addDataToCaloriesWeightChart(double calories, double weight, boolean isFemale) {
        if (isFemale) {
            caloriesWeightChartTab.addFemale(calories, weight);
        } else {
            caloriesWeightChartTab.addMale(calories, weight);
        }
    }

    final void addContent() {
        this.getTabs().addAll(bmrWeightChartTab, caloriesWeightChartTab);
    }

}
