package helpers;/**
 * Created 11/27/15
 *
 * @author Niels Norberg
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AnimationTester extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AnimationTester.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
    }
}
