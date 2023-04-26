package game;

import javafx.fxml.FXML;

import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.util.Queue;


public class GalagaController {
    @FXML
    private AnchorPane ship;
    @FXML
    private AnchorPane pane;
    private Queue<User> u;
    private double ship_speed = 5.0;
    //Hey Chris this is just my attempt at animation for the bullets
    private Movement clock;
    private class Movement extends AnimationTimer {
        private long FRAMES_PER_SEC = 50L;
        private long INTERVAL = 1000000000L / FRAMES_PER_SEC;

        private long last = 0;

        @Override
        public void handle(long l) {

        }
    }

    @FXML
    public void initialize() {
        /*pane.setOnKeyPressed((KeyEvent k) -> {
            if (k.getCode() == KeyCode.A) {
                ship.setTranslateX(ship.getTranslateX() - ship_speed);
            }
            if (k.getCode() == KeyCode.D) {
                ship.setTranslateX(ship.getTranslateX() + ship_speed);
            }
            if (k.getCode() == KeyCode.Z) {

            }
        });*/
        // creating new user and using the ship anchor pane to do something with it
        User user = new User(90,120);
        UserView view = new UserView(user, ship);
        view.update();
    }
    //trying to link up the user class to some on-screen stuff
    @FXML
    private void setUser() {
        User user = new User(25, 25);
        UserView view = new UserView(user, ship);
        pane.setOnKeyPressed((KeyEvent k) -> {
            if (k.getCode() == KeyCode.A) {
            }
        });

    }

}
