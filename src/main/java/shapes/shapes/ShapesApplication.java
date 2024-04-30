package shapes.shapes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.io.IOException;

public class ShapesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ShapesApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1600, 900);
        Group root = new Group();
        Canvas canvas = new Canvas(800, 600);
        stage.setTitle("Shapes");
        root.getChildren().add(canvas);
        stage.setScene(scene);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}