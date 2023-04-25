module Galaga {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    exports game;
    opens game;
}