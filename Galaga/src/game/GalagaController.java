package game;

import javafx.fxml.FXML;

import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.Queue;


public class GalagaController {
    @FXML
    private AnchorPane ship;
    @FXML
    private AnchorPane pane;
    @FXML
    private Rectangle bullet;
    private Queue<User> u;
    private double speed = 0;
    private final double ship_speed = 5.0;
    //Hey Chris this is just my attempt at animation for the bullets
    private Movement clock;
    private class Movement extends AnimationTimer {
        private long FRAMES_PER_SEC = 50L;
        private long INTERVAL = 1000000000L / FRAMES_PER_SEC;

        private long last = 0;

        @Override
        public void handle(long now) {
            if (now - last > INTERVAL) {
                bullet.setTranslateY(speed);
                last = now;
                speed -= 5;
            }
        }
    }
    @FXML
    public void initialize() {
        // creating new user and using the ship anchor pane to do something with it
        User user = new User(90,120);
        UserView view = new UserView(user, ship);
        pane.setOnKeyPressed((KeyEvent k) -> {
            view.moveAndShoot(k);
        });
        view.update();
        clock = new Movement();
        clock.start();
    }
}
