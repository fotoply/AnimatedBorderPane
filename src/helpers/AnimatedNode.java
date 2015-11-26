package helpers;

import javafx.animation.Transition;

/**
 * Used to indicate that a given node/pane in a JavaFX project has custom animations.
 * @author Niels Norberg
 */
public interface AnimatedNode {

    Transition openNode();

    Transition closeNode();

}
