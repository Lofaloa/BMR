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
 *
 * @author g47923
 */
public class MainPane extends BorderPane implements Observer {

    private final MenuBar menuBar;
    private final DataResultBox data;
    private final DataRepresentation representation;

    private final Person user;

    public MainPane(Person user) {
        this.user = user;
        data = new DataResultBox(user);
        representation = new DataRepresentation();
        menuBar = new MenuBar();
        setMenu();
        addContent();
    }

    /**
     * Initializes the menu bar.
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

    final void addContent() {
        this.setTop(menuBar);
        this.setLeft(data);
        this.setRight(representation);
    }

    @Override
    public void update(Observable o, Object arg) {
        data.update();
        representation.addData(user.getBmr(),
                user.getWeight(), user.isWoman());
    }

}
