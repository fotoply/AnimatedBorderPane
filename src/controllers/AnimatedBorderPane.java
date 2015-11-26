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

    /**
     * Sets the center pane of the BorderPane.
     * Will automatically play any open animations assigned to the new node controller.
     * Will automatically play any close animations assigned to the old node controller.
     * If no animations is assigned to either of these it will default to a standard open/close animation.
     * @param node the new node to fill the center
     * @param controller the new controller
     */
    public void setCenterAnimated(Node node, Object controller) {
        if(getCenter() != null) {
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
            AnimationHelper.growIn(node);
        }
    }

    public void setTopAnimated(Node node, Object controller) {
        if(getTop() != null) {
            if (topController != null && topController instanceof AnimatedNode) {
                ((AnimatedNode) topController).closeNode().setOnFinished(event -> {
                    setTop(null);
                    topController = null;
                    setTopAnimated(node, controller);
                });
            } else {
                AnimationHelper.slideOutToTop(node).setOnFinished(event -> {
                    setTop(null);
                    topController = null;
                    setTopAnimated(node, controller);
                });
            }
        }

        if(controller != null && controller instanceof AnimatedNode && node != null) {
            setTop(node);
            topController = controller;
            ((AnimatedNode)topController).openNode();
        } else if(node != null) {
            setTop(node);
            topController = null;
            AnimationHelper.slideInFromTop(node);
        }
    }


    public Object getCenterController() {
        return centerController;
    }

    public Object getTopController() {
        return topController;
    }

    public Object getLeftController() {
        return leftController;
    }

    public Object getRightController() {
        return rightController;
    }

    public Object getBottomController() {
        return bottomController;
    }
}
