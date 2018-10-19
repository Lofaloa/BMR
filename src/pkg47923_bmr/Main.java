package pkg47923_bmr;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import pkg47923_bmr.model.Model;
import pkg47923_bmr.view.MainBox;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Basal Metabolic Rate Calculator");
            Model model = new Model();
            MainBox main = new MainBox(model);
            model.addObserver(main);
            Scene scene = new Scene(main);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            Platform.exit();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
