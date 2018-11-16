package pkg47923_bmr;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pkg47923_bmr.model.Person;
import pkg47923_bmr.view.MainPane;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Basal Metabolic Rate Calculator");
            Person user = new Person();
            MainPane main = new MainPane(user);
            user.addObserver(main);
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
