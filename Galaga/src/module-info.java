module Galaga {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires javafx.media;
    exports game;
    opens game;
}