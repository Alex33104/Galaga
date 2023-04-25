package game;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class UserView extends Parent {
    private User user;
    private double dx = 7.5;

    public UserView(User user) {
        this.user = user;
    }
    public void shoot() {
        javafx.scene.shape.Rectangle bullet = new Rectangle();
        bullet.setY(user.getY());
        bullet.setX(dx);
    }
}
