package game;

import javafx.fxml.FXML;

import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import java.util.Random;

import java.util.Stack;


public class GalagaController {
    @FXML
    private AnchorPane target;
    @FXML
    private AnchorPane ship;
    @FXML
    private AnchorPane pane;
    @FXML
    private Rectangle bullet;
    private Stack<Double> location = new Stack<>();
    private boolean move = true;
    private double speed = 0;
    private Random rand = new Random();
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
                System.out.println(bullet.getTranslateX());
                if (difference() > 0 && difference() <= 25) {
                    if (bullet.getTranslateY() <= -500) {
                        location.push(rand.nextDouble(250) - 250);
                        target.setTranslateX(location.pop());
                        bullet.setTranslateX(ship.getTranslateX());
                        bullet.setTranslateY(ship.getTranslateY());
                        speed = 0;
                        clock.stop();
                        move = true;
                    }
                }
                if (bullet.getTranslateY() <= - 750) {
                    bullet.setTranslateX(ship.getTranslateX());
                    speed = 0;
                    clock.stop();
                    move = true;
                }
            }
        }
    }
    @FXML
    public void initialize() {
        // creating new user and using the ship anchor pane to do something with it
        User user = new User(90,120);
        UserView view = new UserView(user, ship);
        location.push(rand.nextDouble(250) - 250);
        target.setTranslateX(location.pop());
        pane.setOnKeyPressed((KeyEvent k) -> {
            if (k.getCode() == KeyCode.Z) {
                clock.start();
                move = false;
            }
            if (move) {
                if (k.getCode() == KeyCode.A) {
                    bullet.setTranslateX(bullet.getTranslateX() - 5);
                }
                if (k.getCode() == KeyCode.D) {
                    bullet.setTranslateX(bullet.getTranslateX() + 5);
                }
            }
            view.moveShip(k);
        });
        view.update();
        clock = new Movement();
    }
    @FXML
    public void shoot() {
        pane.setOnKeyPressed((KeyEvent k) -> {
            if (k.getCode() == KeyCode.Z) {
                clock.start();
            }
        });
    }
    public double difference() {
        return bullet.getTranslateX() - target.getTranslateX();
    }
}
