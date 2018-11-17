package pkg47923_bmr.view;

import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import pkg47923_bmr.model.Person;

/**
 * Represents the main layout of this window.
 *
 * @author g47923
 */
public class MainPane extends BorderPane implements Observer {

    private final MenuBar menuBar;
    private final DataResultBox data;
    private final ChartsPane representation;
    private final Person user;

    /**
     * Initializes this main pane with a user.
     *
     * @param user is the user to represent.
     */
    public MainPane(Person user) {
        this.user = user;
        this.data = new DataResultBox(user);
        this.representation = new ChartsPane();
        this.menuBar = new MenuBar();
        setMenu();
        addContent();
    }

    /**
     * Initializes the menu bar with a "<i>File</i>" menu. The unique menu
     * allows the user to quit this program.
     */
    final void setMenu() {
        Menu file = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        file.getItems().add(exit);
        menuBar.getMenus().add(file);
    }

    /**
     * Adds content to this pane. This pane contains a menu bar, the data and
     * its representation.
     */
    final void addContent() {
        this.setTop(menuBar);
        this.setLeft(data);
        this.setRight(representation);
    }

    @Override
    public void update(Observable o, Object arg) {
        data.update();
        representation.addDataToCharts(user.getBmr(),
                                       user.getCalories(),
                                       user.getWeight(),
                                       user.getHeight(),
                                       user.isFemale());
    }

}
