package game;

import javafx.fxml.FXML;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

import javax.swing.text.html.ImageView;
import java.awt.*;


public class GalagaController {
    @FXML
    private AnchorPane ship;
    @FXML
    private AnchorPane pane;

    @FXML
    public void initialize() {
        User captain = new User(25, 25);
    }

}
