package pkg47923_bmr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Basal Metabolic Rate Calculator");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);

        VBox root = new VBox();
        HBox hb = new HBox();
        hb.getChildren().add(leftGridPane());

        root.getChildren().add(hb);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane leftGridPane() {
        GridPane left = new GridPane();

        Label label = new Label("Taille (cm)");
        TextField tf = new TextField();
        left.add(label, 1, 0);
        left.add(tf, 2, 0);

        Label label1 = new Label("Poids (kg)");
        TextField tf1 = new TextField();
        left.add(label1, 1, 1);
        left.add(tf1, 2, 1);

        Label label2 = new Label("Age (années)");
        TextField tf2 = new TextField();
        left.add(label2, 1, 2);
        left.add(tf2, 2, 2);

        
        Label label3 = new Label("Sexe");
        ToggleGroup sexe = new ToggleGroup();
        RadioButton female = new RadioButton("Woman");
        RadioButton male = new RadioButton("Man");
        female.setToggleGroup(sexe);
        male.setToggleGroup(sexe);
        left.add(label3, 1, 3);
        left.add(male, 2, 3);
        left.add(female, 3, 3);
        
        return left;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
