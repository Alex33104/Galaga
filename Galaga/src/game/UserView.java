package game;

import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
        System.out.println(user.getH()); //should be 90
        ship.setPrefWidth(user.getW());
        System.out.println(user.getW()); //should be 120


    }
// new update method to hopefully see if it'll work when it's time
    public void update() {
        ship.setTranslateX(user.getX());
        System.out.println(user.getX()); // Should be 0
        ship.setTranslateY(user.getY());
        System.out.println(user.getY()); // Should be 0
    }
    //new move and shoot method which is used in the controller
    public void moveAndShoot(KeyEvent k) {
        if (k.getCode() == KeyCode.A) {
            ship.setTranslateX(ship.getTranslateX() - 5.0);
        }
        if (k.getCode() == KeyCode.D) {
            ship.setTranslateX(ship.getTranslateX() + 5.0);
        }
    }
}
