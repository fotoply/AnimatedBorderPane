package helpers;

import com.sun.istack.internal.NotNull;
import javafx.animation.*;
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
     * Initializer for a sliding and fading animation on a given node.
     * Should be called in the initialize() function.
     *
     * @param node the node to initialize
     */
    public static void initializeSlideFadeFromRight(Node node) {
        node.setTranslateX(node.prefWidth(-1));
        node.setOpacity(0);
    }

    /**
     * Initializer for playing a sliding animation on a given node.
     * Should be called in the initialize() function.
     *
     * @param node the node to initialize
     */
    public static void initializeSlideFromLeft(Node node) {
        node.setTranslateX(node.prefWidth(-1));
    }

    /**
     * Makes a given node slide in from the right.
     * Sliding and fading takes 300 milliseconds.
     *
     * @param node the node to play the animation on
     * @return the transition object for the slide animation
     */
    public static Transition slideInFromRight(Node node) {
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
    public static Transition slideInFromRight(Node node, int duration, Interpolator interpolator) {
        node.setOpacity(0);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setToX(0);
        translateTransition.setFromX(node.prefWidth(-1));
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
    public static Transition slideOutToRight(Node node) {
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
    public static Transition slideOutToRight(Node node, int duration, Interpolator interpolator) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setToX(node.prefWidth(-1));
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node slide in from the left. Sliding takes 250 milliseconds.
     *
     * @param node the node to play the animation on
     */
    public static Transition slideInFromLeft(Node node) {
        return slideInFromLeft(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide in from the left. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the trasition object
     */
    public static Transition slideInFromLeft(Node node, int duration, Interpolator interpolator) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setFromX(-node.prefWidth(-1));
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
    public static Transition slideOutToLeft(Node node) {
        return slideOutToLeft(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide out to the left. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the transition object
     */
    public static Transition slideOutToLeft(Node node, int duration, Interpolator interpolator) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setToX(-node.prefWidth(-1));
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
        //scaleTransition.setFromX(1);
        //scaleTransition.setFromY(1);
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
    public static Transition slideInFromTop(Node node) {
        return slideInFromTop(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide in from the top. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the trasition object
     */
    public static Transition slideInFromTop(Node node, int duration, Interpolator interpolator) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setFromY(-node.prefHeight(-1));
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
    public static Transition slideOutToTop(Node node) {
        return slideOutToTop(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide out of the top. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the transition object
     */
    public static Transition slideOutToTop(Node node, int duration, Interpolator interpolator) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        //translateTransition.setFromY(0);
        translateTransition.setToY(-node.prefHeight(-1));
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node slide in from the bottom. Sliding takes 250 milliseconds.
     *
     * @param node the node to play the animation on
     */
    public static Transition slideInFromBottom(Node node) {
        return slideInFromBottom(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide in from the bottom. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the trasition object
     */
    public static Transition slideInFromBottom(Node node, int duration, Interpolator interpolator) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setFromY(node.prefHeight(-1));
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
    public static Transition slideOutToBottom(Node node) {
        return slideOutToBottom(node, 250, Interpolator.EASE_BOTH);
    }

    /**
     * Makes a given node slide out of the bottom. Sliding takes duration in milliseconds.
     *
     * @param node     the node to play the animation on
     * @param duration the duration in milliseconds
     * @return the transition object
     */
    public static Transition slideOutToBottom(Node node, int duration, Interpolator interpolator) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setToY(node.prefHeight(-1));
        translateTransition.setInterpolator(interpolator);
        translateTransition.play();
        return translateTransition;
    }



}
