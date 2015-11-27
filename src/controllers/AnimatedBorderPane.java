package controllers;

import com.sun.istack.internal.Nullable;
import helpers.AnimatedNode;
import helpers.AnimationHelper;
import javafx.animation.Interpolator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * Creates a border pane with some simple built-in animations for changing the contents of the different areas.
 * When using this class do NOT call setCenter, setTop, etc.. Instead call setCenterAnimated, setTopAnimated, etc..
 *
 * @author Niels Norberg
 */
public class AnimatedBorderPane extends BorderPane {

    private Object centerController;
    private Object topController;
    private Object leftController;
    private Object rightController;
    private Object bottomController;
    private OpenTypes centerOpenAnimation = OpenTypes.GrowIn;
    private CloseTypes centerCloseAnimation = CloseTypes.ShrinkOut;
    private OpenTypes topOpenAnimation = OpenTypes.SlideInFromTop;
    private CloseTypes topCloseAnimation = CloseTypes.SlideOutToTop;
    private OpenTypes leftOpenAnimation = OpenTypes.SlideInFromLeft;
    private CloseTypes leftCloseAnimation = CloseTypes.SlideOutToLeft;
    private OpenTypes rightOpenAnimation = OpenTypes.SlideInFromRight;
    private CloseTypes rightCloseAnimation = CloseTypes.SlideOutToRight;
    private OpenTypes bottomOpenAnimation = OpenTypes.SlideInFromBottom;
    private CloseTypes bottomCloseAnimation = CloseTypes.SlideOutToBottom;
    private Interpolator centerInterpolator;
    private Interpolator topInterpolator;
    private Interpolator leftInterpolator;
    private Interpolator rightInterpolator;
    private Interpolator bottomInterpolator;
    private int centerDuration = 250;
    private int topDuration = 250;
    private int leftDuration = 250;
    private int rightDuration = 250;
    private int bottomDuration = 250;

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

    //region gettersAndSetters

    public int getBottomDuration() {
        return bottomDuration;
    }

    public void setBottomDuration(int bottomDuration) {
        this.bottomDuration = bottomDuration;
    }

    public int getRightDuration() {
        return rightDuration;
    }

    public void setRightDuration(int rightDuration) {
        this.rightDuration = rightDuration;
    }

    public int getLeftDuration() {
        return leftDuration;
    }

    public void setLeftDuration(int leftDuration) {
        this.leftDuration = leftDuration;
    }

    public int getTopDuration() {
        return topDuration;
    }

    public void setTopDuration(int topDuration) {
        this.topDuration = topDuration;
    }

    public int getCenterDuration() {
        return centerDuration;
    }

    public void setCenterDuration(int centerDuration) {
        this.centerDuration = centerDuration;
    }

    public Interpolator getBottomInterpolator() {
        return bottomInterpolator;
    }

    public void setBottomInterpolator(Interpolator bottomInterpolator) {
        this.bottomInterpolator = bottomInterpolator;
    }

    public Interpolator getRightInterpolator() {
        return rightInterpolator;
    }

    public void setRightInterpolator(Interpolator rightInterpolator) {
        this.rightInterpolator = rightInterpolator;
    }

    public Interpolator getLeftInterpolator() {
        return leftInterpolator;
    }

    public void setLeftInterpolator(Interpolator leftInterpolator) {
        this.leftInterpolator = leftInterpolator;
    }

    public Interpolator getTopInterpolator() {
        return topInterpolator;
    }

    public void setTopInterpolator(Interpolator topInterpolator) {
        this.topInterpolator = topInterpolator;
    }

    public Interpolator getCenterInterpolator() {
        return centerInterpolator;
    }

    public void setCenterInterpolator(Interpolator centerInterpolator) {
        this.centerInterpolator = centerInterpolator;
    }

    public OpenTypes getCenterOpenAnimation() {
        return centerOpenAnimation;
    }

    public void setCenterOpenAnimation(OpenTypes centerOpenAnimation) {
        this.centerOpenAnimation = centerOpenAnimation;
    }

    public CloseTypes getCenterCloseAnimation() {
        return centerCloseAnimation;
    }

    public void setCenterCloseAnimation(CloseTypes centerCloseAnimation) {
        this.centerCloseAnimation = centerCloseAnimation;
    }

    public OpenTypes getTopOpenAnimation() {
        return topOpenAnimation;
    }

    public void setTopOpenAnimation(OpenTypes topOpenAnimation) {
        this.topOpenAnimation = topOpenAnimation;
    }

    public CloseTypes getTopCloseAnimation() {
        return topCloseAnimation;
    }

    public void setTopCloseAnimation(CloseTypes topCloseAnimation) {
        this.topCloseAnimation = topCloseAnimation;
    }

    public OpenTypes getLeftOpenAnimation() {
        return leftOpenAnimation;
    }

    public void setLeftOpenAnimation(OpenTypes leftOpenAnimation) {
        this.leftOpenAnimation = leftOpenAnimation;
    }

    public CloseTypes getLeftCloseAnimation() {
        return leftCloseAnimation;
    }

    public void setLeftCloseAnimation(CloseTypes leftCloseAnimation) {
        this.leftCloseAnimation = leftCloseAnimation;
    }

    public OpenTypes getRightOpenAnimation() {
        return rightOpenAnimation;
    }

    public void setRightOpenAnimation(OpenTypes rightOpenAnimation) {
        this.rightOpenAnimation = rightOpenAnimation;
    }

    public CloseTypes getRightCloseAnimation() {
        return rightCloseAnimation;
    }

    public void setRightCloseAnimation(CloseTypes rightCloseAnimation) {
        this.rightCloseAnimation = rightCloseAnimation;
    }

    public OpenTypes getBottomOpenAnimation() {
        return bottomOpenAnimation;
    }

    public void setBottomOpenAnimation(OpenTypes bottomOpenAnimation) {
        this.bottomOpenAnimation = bottomOpenAnimation;
    }

    public CloseTypes getBottomCloseAnimation() {
        return bottomCloseAnimation;
    }

    public void setBottomCloseAnimation(CloseTypes bottomCloseAnimation) {
        this.bottomCloseAnimation = bottomCloseAnimation;
    }
    //endregion

    private void animateBasedOnOpenType(Node node, OpenTypes openType, int Duration) {
        switch (openType) {
            case GrowIn:

                break;
            case SlideInFromRight:

                break;
            case SlideInFromTop:

                break;
            case SlideInFromBottom:

                break;
            case SlideInFromLeft:

                break;
        }
    }

    /**
     * Sets the center pane of the BorderPane.
     * Will automatically play any open animations assigned to the new node controller.
     * Will automatically play any close animations assigned to the old node controller.
     * If no animations is assigned to either of these it will default to a standard open/close animation.
     *
     * @param node       the new node to fill the center
     * @param controller the new controller
     */
    public void setCenterAnimated(@Nullable Node node, @Nullable Object controller) {
        if (getCenter() != null) {
            if (centerController != null && centerController instanceof AnimatedNode) {
                ((AnimatedNode) centerController).closeNode().setOnFinished(event -> {
                    setCenter(null);
                    centerController = null;
                    setCenterAnimated(node, controller);
                });
                return;
            } else {
                AnimationHelper.growOut(node).setOnFinished(event -> {
                    setCenter(null);
                    centerController = null;
                    setCenterAnimated(node, controller);
                });
                return;
            }
        }

        if (controller != null && controller instanceof AnimatedNode && node != null) {
            setCenter(node);
            centerController = controller;
            ((AnimatedNode) centerController).openNode();
        } else if (node != null) {
            setCenter(node);
            centerController = null;
            AnimationHelper.growIn(node);
        }
    }

    /**
     * Sets the top pane of the BorderPane.
     * Will automatically play any open animations assigned to the new node controller.
     * Will automatically play any close animations assigned to the old node controller.
     * If no animations is assigned to either of these it will default to a standard open/close animation.
     *
     * @param node       the new node to fill the center
     * @param controller the new controller
     */
    public void setTopAnimated(@Nullable Node node, @Nullable Object controller) {
        if (getTop() != null) {
            if (topController != null && topController instanceof AnimatedNode) {
                ((AnimatedNode) topController).closeNode().setOnFinished(event -> {
                    setTop(null);
                    topController = null;
                    setTopAnimated(node, controller);
                });
                return;
            } else {
                AnimationHelper.slideOutToTop(node).setOnFinished(event -> {
                    setTop(null);
                    topController = null;
                    setTopAnimated(node, controller);
                });
                return;
            }
        }

        if (controller != null && controller instanceof AnimatedNode && node != null) {
            setTop(node);
            topController = controller;
            ((AnimatedNode) topController).openNode();
        } else if (node != null) {
            setTop(node);
            topController = null;
            AnimationHelper.slideInFromTop(node);
        }
    }

    /**
     * Sets the left pane of the BorderPane.
     * Will automatically play any open animations assigned to the new node controller.
     * Will automatically play any close animations assigned to the old node controller.
     * If no animations is assigned to either of these it will default to a standard open/close animation.
     *
     * @param node       the new node to fill the center
     * @param controller the new controller
     */
    public void setLeftAnimated(@Nullable Node node, @Nullable Object controller) {
        if (getLeft() != null) {
            if (leftController != null && leftController instanceof AnimatedNode) {
                ((AnimatedNode) leftController).closeNode().setOnFinished(event -> {
                    setLeft(null);
                    leftController = null;
                    setLeftAnimated(node, controller);
                });
                return;
            } else {
                AnimationHelper.slideOutToLeft(node).setOnFinished(event -> {
                    setLeft(null);
                    leftController = null;
                    setLeftAnimated(node, controller);
                });
                return;
            }
        }

        if (controller != null && controller instanceof AnimatedNode && node != null) {
            setLeft(node);
            leftController = controller;
            ((AnimatedNode) leftController).openNode();
        } else if (node != null) {
            setLeft(node);
            leftController = null;
            AnimationHelper.slideInFromLeft(node);
        }
    }

    /**
     * Sets the right pane of the BorderPane.
     * Will automatically play any open animations assigned to the new node controller.
     * Will automatically play any close animations assigned to the old node controller.
     * If no animations is assigned to either of these it will default to a standard open/close animation.
     *
     * @param node       the new node to fill the center
     * @param controller the new controller
     */
    public void setRightAnimated(@Nullable Node node, @Nullable Object controller) {
        if (getRight() != null) {
            if (rightController != null && rightController instanceof AnimatedNode) {
                ((AnimatedNode) rightController).closeNode().setOnFinished(event -> {
                    setRight(null);
                    rightController = null;
                    setRightAnimated(node, controller);
                });
                return;
            } else {
                AnimationHelper.slideOutToRight(node).setOnFinished(event -> {
                    setRight(null);
                    rightController = null;
                    setRightAnimated(node, controller);
                });
                return;
            }
        }

        if (controller != null && controller instanceof AnimatedNode && node != null) {
            setRight(node);
            rightController = controller;
            ((AnimatedNode) rightController).openNode();
        } else if (node != null) {
            setRight(node);
            rightController = null;
            AnimationHelper.slideInFromRight(node);
        }
    }

    /**
     * Sets the bottom pane of the BorderPane.
     * Will automatically play any open animations assigned to the new node controller.
     * Will automatically play any close animations assigned to the old node controller.
     * If no animations is assigned to either of these it will default to a standard open/close animation.
     *
     * @param node       the new node to fill the center
     * @param controller the new controller
     */
    public void setBottomAnimated(@Nullable Node node, @Nullable Object controller) {
        if (getBottom() != null) {
            if (bottomController != null && bottomController instanceof AnimatedNode) {
                ((AnimatedNode) bottomController).closeNode().setOnFinished(event -> {
                    setBottom(null);
                    bottomController = null;
                    setBottomAnimated(node, controller);
                });
                return;
            } else {
                AnimationHelper.slideOutToBottom(node).setOnFinished(event -> {
                    setBottom(null);
                    bottomController = null;
                    setBottomAnimated(node, controller);
                });
                return;
            }
        }

        if (controller != null && controller instanceof AnimatedNode && node != null) {
            setBottom(node);
            bottomController = controller;
            ((AnimatedNode) bottomController).openNode();
        } else if (node != null) {
            setBottom(node);
            bottomController = null;
            AnimationHelper.slideInFromBottom(node);
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

    public enum OpenTypes {GrowIn, SlideInFromLeft, SlideInFromRight, SlideInFromTop, SlideInFromBottom}

    public enum CloseTypes {ShrinkOut, SlideOutToLeft, SlideOutToRight, SlideOutToTop, SlideOutToBottom}
}
