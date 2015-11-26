package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * Creates a border pane with some simple built-in animations for changing the contents of the different areas.
 * When using this class do NOT call setCenter, setTop, etc.. Instead call setCenterAnimated
 * @author Niels Norberg
 */
public class AnimatedBorderPane extends BorderPane {

    BorderPane root;

    public AnimatedBorderPane() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/fxml/AnimatedBorderPane.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
