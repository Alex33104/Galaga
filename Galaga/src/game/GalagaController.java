package game;

import javafx.fxml.FXML;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

import javax.swing.text.html.ImageView;
import java.awt.*;


public class GalagaController {
    @FXML
    private AnchorPane ship;
    @FXML
    private BorderPane pane;
    final double ship_speed = 5.0;

    @FXML
    public void initialize() {
        User captain = new User(25, 25);
        UserView view = new UserView(captain);
        pane.setOnKeyPressed((KeyEvent k) -> {
            System.out.println("you're here");
            if (k.getCode() == KeyCode.A) {
                ship.setTranslateX(ship.getTranslateX() - ship_speed);
            }
            if (k.getCode() == KeyCode.D) {
                ship.setTranslateX(ship.getTranslateX() + ship_speed);
            }
            if (k.getCode() == KeyCode.W) {
                ship.setTranslateY(ship.getTranslateY() - ship_speed);
            }
            if (k.getCode() == KeyCode.S) {
                ship.setTranslateY(ship.getTranslateY() + ship_speed);
            }
        });
    }
    @FXML
    public void left() {
        ship.setTranslateX(ship.getTranslateX() - ship_speed);
    }
}
