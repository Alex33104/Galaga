package game;

import javafx.scene.Parent;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class UserView extends Parent {
    private User user;
    private Arc c;

    public UserView(User user) {
        this.user = user;
    }

}
