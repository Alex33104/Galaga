package game;

import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class UserView extends Parent {
    private final User user;
    private final AnchorPane ship;


//tries to connect the controller to the view class, but it's harder than it looks
    public UserView(User user, AnchorPane ship) {
        this.user = user;
        this.ship = ship;
        ship.setTranslateX(user.getX());
        ship.setTranslateY(user.getY());
        ship.setPrefHeight(user.getH());
        ship.setPrefWidth(user.getW());


    }
// new update method to hopefully see if it'll work when it's time
    public void update() {
        ship.setTranslateX(user.getX());
        ship.setTranslateY(user.getY());
    }
    //new move and shoot method which is used in the controller
    public void moveShip(KeyEvent k) {
        if (k.getCode() == KeyCode.A) {
            ship.setTranslateX(ship.getTranslateX() - 5.0);
        }
        if (k.getCode() == KeyCode.D) {
            ship.setTranslateX(ship.getTranslateX() + 5.0);
        }
    }
}
