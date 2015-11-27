package helpers;

import controllers.AnimatedBorderPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Created 11/27/15
 *
 * @author Niels Norberg
 */
public class AnimationTesterController {

    @FXML
    private AnimatedBorderPane root;

    @FXML
    void playAllAnimations() {
        root.setCenterAnimated(new Text("I am center"),null);
        root.setTopAnimated(new Text("I am top"),null);
        root.setBottomAnimated(new Text("I am bottom"),null);
        /*root.setLeftAnimated(new Text("I am left"),null);
        root.setRightAnimated(new Text("I am right"),null);*/
    }

}
