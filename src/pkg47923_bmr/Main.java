package pkg47923_bmr;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pkg47923_bmr.model.Person;
import pkg47923_bmr.view.BMRViewController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
// -------------- Vue procédurale ---------------
//        try {
//            primaryStage.setTitle("Basal Metabolic Rate Calculator");
//            Person user = new Person();
//            MainPane main = new MainPane(user);
//            Scene scene = new Scene(main);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//            Platform.exit();
//        }

// ------------- Vue FXML -------------
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("BMRView.fxml"));
            loader.setController(new BMRViewController(new Person()));
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
