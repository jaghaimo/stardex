module verche {
    requires java.base;
    requires java.desktop;
    requires java.logging;

    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;

    requires org.kordamp.iconli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.material;

    requires com.fasterxml.jackson.databind;

    exports verche;

    opens verche.model to javafx.base, com.fasterxml.jackson.databind;
    opens verche.service to com.fasterxml.jackson.databind;
}
