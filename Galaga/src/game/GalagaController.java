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
    private Arc ship;
    @FXML
    private AnchorPane pane;
    final double ship_speed = 5.0;

    @FXML
    public void initialize() {
        User captain = new User(25, 25);
        pane.setOnKeyPressed((KeyEvent k) -> {
            if (k.getCode() == KeyCode.LEFT) {
                ship.setTranslateX(ship.getTranslateX() - ship_speed);
            }
            if (k.getCode() == KeyCode.RIGHT) {
                ship.setTranslateX(ship.getTranslateX() + ship_speed);
            }
            if (k.getCode() == KeyCode.UP) {
                ship.setTranslateY(ship.getTranslateY() - ship_speed);
            }
            if (k.getCode() == KeyCode.DOWN) {
                ship.setTranslateY(ship.getTranslateY() + ship_speed);
            }
        });
    }
    @FXML
    public void left() {
        ship.setTranslateX(ship.getTranslateX() - ship_speed);
    }
}
