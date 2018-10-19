package pkg47923_bmr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import pkg47923_bmr.model.Model;
import pkg47923_bmr.view.MainBox;

public class Main extends Application {

    private final int WINDOW_HEIGHT = 200;
    private final int WINDOW_WIDTH = 500;

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Basal Metabolic Rate Calculator");
            primaryStage.setMinWidth(WINDOW_WIDTH);
            primaryStage.setMinHeight(WINDOW_HEIGHT);

            Model model = new Model();
            MainBox main = new MainBox(model);

            Scene scene = new Scene(main);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception ex) {
            Alert fail = new Alert(Alert.AlertType.INFORMATION);
            fail.setHeaderText("Failure");
            fail.setContentText(ex.getMessage());
            fail.showAndWait();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
