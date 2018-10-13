package pkg47923_bmr.view;

import javafx.scene.layout.HBox;

/**
 * Contains the content.
 * 
 * @author g47923
 */
public class ContentPane extends HBox {
    
    private final DataPane data;
    private final ResultPane result;

    /**
     * Initializes this pane with content.
     */
    public ContentPane() {
        this.data = new DataPane();
        this.result = new ResultPane();
        addContent();
    }
    
    /**
     * Adds the content to this pane.
     */
    final void addContent() {
        this.getChildren().addAll(data, result);
    }
    
}
