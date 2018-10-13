package pkg47923_bmr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pkg47923_bmr.view.PrimaryPane;
import pkg47923_bmr.view.SecondaryPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Basal Metabolic Rate Calculator");
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(200);
        Scene scene = new Scene(new PrimaryPane());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
