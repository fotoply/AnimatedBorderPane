package helpers;

import controllers.AnimatedBorderPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        b.setOnAction(event -> {
            root.setCenterOpenAnimation(AnimatedBorderPane.OpenTypes.values()[rnd.nextInt(AnimatedBorderPane.OpenTypes.values().length)]);
            System.out.println(root.getCenterOpenAnimation());
            root.setCenterCloseAnimation(AnimatedBorderPane.CloseTypes.values()[rnd.nextInt(AnimatedBorderPane.CloseTypes.values().length)]);
            System.out.println(root.getCenterCloseAnimation());
            root.setCenterDuration(2000);
            playAllAnimations();
        });


        root.setCenterAnimated(b, null);
        root.setTopAnimated(new Text("I am top"), null);
        root.setBottomAnimated(new Text("I am bottom"), null);
        root.setLeftAnimated(new Text("I am left"), null);
        root.setRightAnimated(new Text("I am right"), null);
    }

}
