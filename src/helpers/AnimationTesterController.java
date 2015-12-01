package helpers;

import controllers.AnimatedBorderPane;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.Random;

/**
 * Created 11/27/15
 *
 * @author Niels Norberg
 */
public class AnimationTesterController implements AnimatedNode{

    @FXML
    private AnimatedBorderPane root;

    @FXML
    private void initialize() {
        root.setCenterCloseAnimation(AnimatedBorderPane.CloseTypes.ShrinkOut);
        root.setCenterOpenAnimation(AnimatedBorderPane.OpenTypes.SlideInFromLeft);

        //root.setLeftCloseAnimation(AnimatedBorderPane.CloseTypes.ShrinkOut);

        //root.setCenterAnimated(center,this);
        /*root.setLeftOpenAnimation(AnimatedBorderPane.OpenTypes.GrowIn);
        root.setLeftCloseAnimation(AnimatedBorderPane.CloseTypes.ShrinkOut);*/
    }

    @FXML
    private Label leftSide;

    @FXML
    private Label topSide;

    @FXML
    private Label rightSide;

    @FXML
    private Label center;

    @FXML
    void centerClicked() {
        root.setCenterAnimated(center,null);
        root.setLeftAnimated(leftSide,null);
    }

    @FXML
    void leftClicked() {
        root.setLeftAnimated(leftSide,null);
    }

    @FXML
    void rightClicked() {
        root.setRightAnimated(rightSide,null);
    }

    @FXML
    void topClicked() {
        root.setTopAnimated(topSide,null);
    }

    @Override
    public Transition openNode() {
        return AnimationHelper.slideInFromBottom(center, 400, Interpolator.EASE_BOTH);
    }

    @Override
    public Transition closeNode() {
        return AnimationHelper.slideOutToTop(center,400,Interpolator.EASE_BOTH);
    }
}
