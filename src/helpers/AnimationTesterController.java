package helpers;

import controllers.AnimatedBorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

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
        Button b = new Button("I am center");
        Random rnd = new Random();
        b.setOnAction(event -> {playAllAnimations(); root.setCenterCloseAnimation(AnimatedBorderPane.CloseTypes.values()[rnd.nextInt(AnimatedBorderPane.CloseTypes.values().length)]); root.setCenterDuration(2000);});

        root.setCenterAnimated(b,null);

        root.setTopAnimated(new Text("I am top"),null);
        root.setBottomAnimated(new Text("I am bottom"),null);
        root.setLeftAnimated(new Text("I am left"),null);
        root.setRightAnimated(new Text("I am right"),null);
    }

}
