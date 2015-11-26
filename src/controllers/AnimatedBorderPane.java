package controllers;

import helpers.AnimatedNode;
import helpers.AnimationHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * Creates a border pane with some simple built-in animations for changing the contents of the different areas.
 * When using this class do NOT call setCenter, setTop, etc.. Instead call setCenterAnimated, setTopAnimated, etc..
 * @author Niels Norberg
 */
public class AnimatedBorderPane extends BorderPane {

    @FXML
    BorderPane root;

    private Object centerController;
    private Object topController;
    private Object leftController;
    private Object rightController;
    private Object bottomController;

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

    public void setCenterAnimated(Node node, Object controller) {
        if(root.getCenter() != null) {
            if (centerController != null && centerController instanceof AnimatedNode) {
                ((AnimatedNode) centerController).closeNode().setOnFinished(event -> {
                    setCenter(null);
                    centerController = null;
                    setCenterAnimated(node, controller);
                });
            } else {
                AnimationHelper.growOut(node).setOnFinished(event -> {
                    setCenter(null);
                    centerController = null;
                    setCenterAnimated(node, controller);
                });
            }
        }

        if(controller != null && controller instanceof AnimatedNode && node != null) {
            setCenter(node);
            centerController = controller;
            ((AnimatedNode)centerController).openNode();
        } else if(node != null) {
            setCenter(node);
            centerController = null;
        }
    }


}
