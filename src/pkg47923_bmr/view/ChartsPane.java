package pkg47923_bmr.view;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.TabPane;
import pkg47923_bmr.model.Person;

/**
 * Represents a pane of tabs that contains 3 charts: BMR vs weight, calories vs
 * weight and BMR vs height.
 *
 * @author g47923
 */
public class ChartsPane extends TabPane implements Observer {

    private final ChartTab bmrWeightChartTab;
    private final ChartTab caloriesWeightChartTab;
    private final ChartTab bmrHeightChartTab;

    /**
     * Initializes this pane of charts.
     */
    public ChartsPane() {
        this.bmrWeightChartTab = new ChartTab("BMR par rapport au poids",
                "Poids (kg)", "BMR");
        this.caloriesWeightChartTab = new ChartTab("Calories par rapport au poids",
                "Poids (kg)", "Calories");
        this.bmrHeightChartTab = new ChartTab("BMR par rapport à la taille",
                "Taille (cm)", "BMR");
        addContent();
    }

    /**
     * Adds the given data to the different charts.
     *
     * @param bmr is the BMR of the new data.
     * @param calories is the calories of the new data.
     * @param weight is the weight of the new data.
     * @param height is the height of the new data.
     * @param isFemale true if the data should be added to the female line.
     */
    private void addDataToCharts(double bmr, double calories, double weight,
            double height, boolean isFemale) {
        addDataTo(bmrWeightChartTab, weight, bmr, isFemale);
        addDataTo(caloriesWeightChartTab, weight, calories, isFemale);
        addDataTo(bmrHeightChartTab, height, bmr, isFemale);
    }

    /**
     * Adds a new data to the given tab.
     *
     * @param tab is the tab that contains the chart to add the new data to.
     * @param x is the data of the x axis.
     * @param y is the data of the y axis.
     * @param isFemale true if the data should be added on the female line.
     */
    private void addDataTo(ChartTab tab, double x, double y, boolean isFemale) {
        if (isFemale) {
            tab.addFemale(x, y);
        } else {
            tab.addMale(x, y);
        }
    }

    private void addContent() {
        this.getTabs().addAll(bmrWeightChartTab, caloriesWeightChartTab,
                bmrHeightChartTab);
    }

    @Override
    public void update(Observable o, Object o1) {
        Person user = (Person) o;
        addDataToCharts(user.getBmr(), 
                user.getCalories(), 
                user.getWeight(),
                user.getHeight(),
                user.isFemale());
    }    
    
}
