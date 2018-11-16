package pkg47923_bmr.view;

import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

/**
 *
 * @author g47923
 */
public class ChartTab extends Tab {
    
    private final HBox chart;
    
    public ChartTab(String title, HBox chart) {
        this.chart = chart;
        this.setText(title);
    }
    
    final void addContent() {
        this.setContent(chart);
    }
    
}
