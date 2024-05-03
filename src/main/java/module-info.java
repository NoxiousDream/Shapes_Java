module shapes.shapes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens shapes.shapes to javafx.fxml;
    exports shapes.shapes;
    exports shapes.shapes.utils;
    opens shapes.shapes.utils to javafx.fxml;
}