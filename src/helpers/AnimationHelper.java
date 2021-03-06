package helpers;

import com.sun.istack.internal.NotNull;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * A simple helper class which contains static methods for simple animations.
 * Most of the animations are made to fit different parts of a border pane based application.
 *
 * @author Niels Norberg
 */
public class AnimationHelper {
    /**
     * Makes a given node slide in from the right.
     * Sliding and fading takes 300 milliseconds.
     *
     * @param node the node to play the animation on
     * @return the transition object for the slide animation
     */
    public static Transition slideInFromRight(@NotNull Node node) {
        return slideInFromRight(node, 300, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide in from the right.
     * Sliding and fading takes the duration specified in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the transition object for the slide animation
     */
    public static Transition slideInFromRight(@NotNull Node node, @NotNull int duration, @NotNull Interpolator interpolator) {

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setToX(0);
        translateTransition.setFromX(node.parentToLocal(node.getParent().prefWidth(-1), 0).getX() + 5);
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();

        return translateTransition;
    }

    /**
     * Makes a given node slide out to the right.
     * Sliding and fading takes 150 milliseconds.
     *
     * @param node the node to play the animation on
     * @return the transition object for the slide animation
     */
    public static Transition slideOutToRight(@NotNull Node node) {
        return slideOutToRight(node, 150, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide out to the right.
     * Sliding and fading takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the transition object for the slide animation
     */
    public static Transition slideOutToRight(@NotNull Node node, @NotNull int duration, @NotNull Interpolator interpolator) {

        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setFromX(0);
        translateTransition.setToX(node.parentToLocal(node.getParent().prefWidth(-1), 0).getX() + 5);
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node slide in from the left. Sliding takes 250 milliseconds.
     *
     * @param node the node to play the animation on
     */
    public static Transition slideInFromLeft(@NotNull Node node) {
        return slideInFromLeft(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide in from the left. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the trasition object
     */
    public static Transition slideInFromLeft(@NotNull Node node, @NotNull int duration, @NotNull Interpolator interpolator) {

        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setFromX(node.parentToLocal(0, 0).getX() - node.prefWidth(-1) - 5);
        translateTransition.setToX(0);
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node slide out to the left. Sliding takes 250 milliseconds.
     *
     * @param node the node to play the animation on
     * @return the transition object
     */
    public static Transition slideOutToLeft(@NotNull Node node) {
        return slideOutToLeft(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide out to the left. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the transition object
     */
    public static Transition slideOutToLeft(@NotNull Node node, @NotNull int duration, @NotNull Interpolator interpolator) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setToX(node.parentToLocal(0, 0).getX() - node.prefWidth(-1) - 5);
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node pop-in by scaling. The animation takes 250 milliseconds.
     *
     * @param node the node to play the animation on
     * @return the transition object
     */
    public static Transition growIn(@NotNull Node node) {
        return growIn(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node pop-in by scaling. The animation takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the transition object
     */
    public static Transition growIn(@NotNull Node node, @NotNull int duration, Interpolator interpolator) {
        ScaleTransition scaleTransition = new ScaleTransition(new Duration(duration), node);
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setInterpolator(interpolator);
        scaleTransition.play();

        return scaleTransition;
    }

    /**
     * Makes a given node pop-out by scaling. The animation takes 250 milliseconds.
     *
     * @param node the node to play the animation on
     * @return the transition object
     */
    public static Transition growOut(@NotNull Node node) {
        return growOut(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node pop-out by scaling. The animation takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the transition object
     */
    public static Transition growOut(@NotNull Node node, @NotNull int duration, Interpolator interpolator) {
        ScaleTransition scaleTransition = new ScaleTransition(new Duration(duration), node);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(0);
        scaleTransition.setToY(0);
        scaleTransition.setInterpolator(interpolator);
        scaleTransition.play();

        return scaleTransition;
    }

    /**
     * Makes a given node slide in from the top. Sliding takes 250 milliseconds.
     *
     * @param node the node to play the animation on
     */
    public static Transition slideInFromTop(@NotNull Node node) {
        return slideInFromTop(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide in from the top. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the trasition object
     */
    public static Transition slideInFromTop(@NotNull Node node, @NotNull int duration, @NotNull Interpolator interpolator) {

        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setFromY(node.parentToLocal(0, 0).getY() - node.prefHeight(-1) - 5);
        translateTransition.setToY(0);
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node slide out of the top. Sliding takes 250 milliseconds.
     *
     * @param node the node to play the animation on
     * @return the transition object
     */
    public static Transition slideOutToTop(@NotNull Node node) {
        return slideOutToTop(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide out of the top. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the transition object
     */
    public static Transition slideOutToTop(@NotNull Node node, @NotNull int duration, @NotNull Interpolator interpolator) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setToY(node.parentToLocal(0, 0).getY() - node.prefHeight(-1) - 5);
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node slide in from the bottom. Sliding takes 250 milliseconds.
     *
     * @param node the node to play the animation on
     */
    public static Transition slideInFromBottom(@NotNull Node node) {
        return slideInFromBottom(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide in from the bottom. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the trasition object
     */
    public static Transition slideInFromBottom(@NotNull Node node, @NotNull int duration, @NotNull Interpolator interpolator) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setFromY(node.parentToLocal(0, node.getParent().prefHeight(-1)).getY() + 5);
        translateTransition.setToY(0);
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node slide out of the bottom. Sliding takes 250 milliseconds.
     *
     * @param node the node to play the animation on
     * @return the transition object
     */
    public static Transition slideOutToBottom(@NotNull Node node) {
        return slideOutToBottom(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide out of the bottom. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the transition object
     */
    public static Transition slideOutToBottom(@NotNull Node node, @NotNull int duration, @NotNull Interpolator interpolator) {

        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setToY(node.parentToLocal(0, node.getParent().prefHeight(-1)).getY() + 5);
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();
        return translateTransition;
    }


}
