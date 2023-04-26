package game;

import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class UserView extends Parent {
    private User user;
    private AnchorPane ship;

//tries to connect the controller to the view class, but it's harder than it looks
    public UserView(User user, AnchorPane ship) {
        this.user = user;
        this.ship = ship;
        AnchorPane finalShip = ship;
        ship.setOnKeyPressed((KeyEvent k) -> {
                    if (k.getCode() == KeyCode.A) {
                        System.out.println("hello");
                        finalShip.setTranslateX(finalShip.getTranslateX() - 1);
                    }
                    if (k.getCode() == KeyCode.D) {
                        finalShip.setTranslateX(finalShip.getTranslateX() + 1);
                    }
                });

        ship = new AnchorPane();
        ship.setScaleX(user.getX());
        ship.setScaleY(user.getY());
        ship.setPrefHeight(user.getH());
        System.out.println(user.getH()); //should be 90
        ship.setPrefWidth(user.getW());
        System.out.println(user.getW()); //should be 120


    }
// supposed to create a new bullet and shoot it in a straight line
    public void shoot() {
        System.out.println("hello");
        Rectangle bullet = new Rectangle();
        bullet.setY(user.getY());
        bullet.setX(user.getX());
        bullet.setFill(Color.BLACK);
        bullet.setStroke(Color.RED);
        getChildren().add(bullet);
    }
// new update method to hopefully see if it'll work when it's time
    public void update() {
        ship.setTranslateX(user.getX());
        System.out.println(user.getX()); // Should be 0
        ship.setTranslateY(user.getY());
        System.out.println(user.getY()); // Should be 0
    }
}
