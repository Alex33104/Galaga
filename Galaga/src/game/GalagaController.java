package game;

import javafx.fxml.FXML;

import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Random;

import java.util.Stack;


public class GalagaController {
    @FXML
    private AnchorPane target;
    @FXML
    private AnchorPane ship;
    @FXML
    private Label hits;
    @FXML
    private Label total;
    private int hit = 0;
    private int tot = 0;
    @FXML
    private AnchorPane pane;
    @FXML
    private Rectangle bullet;
    private Stack<Double> location = new Stack<>();
    private boolean move = true;
    private double speed = 0;
    private Random rand = new Random();
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
                speed -= 40;
                if (difference() >= -5 && difference() <= 25) {
                    if (bullet.getTranslateY() <= -475) {
                        location.push(rand.nextDouble(250) - 250);
                        target.setTranslateX(location.pop());
                        bullet.setTranslateX(ship.getTranslateX());
                        bullet.setTranslateY(ship.getTranslateY());
                        speed = 0;
                        clock.stop();
                        move = true;
                        hit += 1;
                        tot += 1;
                        hits.setText("Hit " + hit + " targets");
                        total.setText("Fired " + tot + " bullets");

                    }
                }
                if (bullet.getTranslateY() <= - 750) {
                    bullet.setTranslateX(ship.getTranslateX());
                    speed = 0;
                    clock.stop();
                    move = true;
                    tot += 1;
                    total.setText("Fired " + tot + " bullets");
                }
            }
        }
    }
    @FXML
    public void initialize() {
        // creating new user and using the ship anchor pane to do something with it
        User user = new User(90,120);
        hits.setText("Hit " + hit + " targets");
        total.setText("Fired " + tot + " bullets");
        UserView view = new UserView(user, ship);
        location.push(rand.nextDouble(250));
        target.setTranslateX(location.pop());
        pane.setOnKeyPressed((KeyEvent k) -> {
            if (k.getCode() == KeyCode.Z) {
                String blaster = "/Users/alexanderpangelinan/Documents/GitHub/Galaga/Galaga/src/game/blaster-2-81267.mp3";
                Media hit = new Media(new File(blaster).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(hit);
                mediaPlayer.play();
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
