import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * A simple helper class which contains static methods for simple animations.
 * Most of the animations are made to fit different parts of a border pane based application.
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
     * @param node the node to initialize
     */
    public static void initializeSlideFromLeft(Node node) {
        node.setTranslateX(node.prefWidth(-1));
    }

    /**
     * Makes a given node slide in from the right. While sliding the object will also fade in.
     * Sliding and fading takes 300 milliseconds.
     * @param node the node to play the animation on
     * @return the transition object for the slide animation
     */
    public static Transition slideFadeInFromRight(Node node) {
        return slideFadeInFromRight(node,300);
    }

    /**
     * Makes a given node slide in from the right. While sliding the object will also fade in.
     * Sliding and fading takes the duration specified in milliseconds.
     * @param node the node to play the animation on
     * @return the transition object for the slide animation
     */
    public static Transition slideFadeInFromRight(Node node, int duration) {
        node.setOpacity(0);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setToX(0);

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(duration), node);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        fadeTransition.play();
        translateTransition.play();

        return translateTransition;
    }

    /**
     * Makes a given node slide out to the right. While sliding the object will also fade out.
     * Sliding and fading takes 150 milliseconds.
     * @param node the node to play the animation on
     * @return the transition object for the slide animation
     */
    public static Transition slideFadeOutToRight(Node node) {
        return slideFadeOutToRight(node,150);
    }

    /**
     * Makes a given node slide out to the right. While sliding the object will also fade out.
     * Sliding and fading takes duration in milliseconds.
     * @param node the node to play the animation on
     * @return the transition object for the slide animation
     */
    public static Transition slideFadeOutToRight(Node node, int duration) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setToX(node.prefWidth(-1));

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(duration), node);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.play();
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node slide in from the left. Sliding takes 250 milliseconds.
     * @param node the node to play the animation on
     */
    public static Transition slideInFromLeft(Node node) {
        return slideInFromLeft(node,250);
    }

    /**
     * Makes a given node slide in from the left. Sliding takes duration in milliseconds.
     * @param node the node to play the animation on
     */
    public static Transition slideInFromLeft(Node node, int duration) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setToX(0);
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node slide out to the left. Sliding takes 250 milliseconds.
     * @param node the node to play the animation on
     * @return the transition object
     */
    public static Transition slideOutToLeft(Node node) {
        return slideOutToLeft(node, 250);
    }

    /**
     * Makes a given node slide out to the left. Sliding takes duration in milliseconds.
     * @param node the node to play the animation on
     * @return the transition object
     */
    public static Transition slideOutToLeft(Node node, int duration) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(duration), node);
        translateTransition.setToX(-node.prefWidth(-1));
        translateTransition.play();
        return translateTransition;
    }

}
