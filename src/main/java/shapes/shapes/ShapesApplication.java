package shapes.shapes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ShapesApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Button button = new Button("Settings");
        VBox vbox_button = new VBox(button);
        VBox.setMargin(button, new Insets(10, 10, 10, 10));
        button.setTextAlignment(TextAlignment.CENTER);
        Group root = new Group();
        Canvas canvas = new Canvas(800, 600);
        stage.setTitle("Shapes");
        root.getChildren().add(canvas);
        root.getChildren().add(vbox_button);

        stage.setScene(new Scene(root));
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        final Control control = new Control();


        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                e -> {
                    var a = control.IsInsideAny(e.getX(), e.getY());
                    if (a == -1) {
                        control.AddShape(e.getX(), e.getY());
                        Render(gc, canvas, control.getShapes());
                    } else {
                        control.getShapes().get(a).Moving = true;
                        control.getShapes().get(a).Xd = control.getShapes().get(a).X - e.getX();
                        control.getShapes().get(a).Yd = control.getShapes().get(a).Y - e.getY();
                    }
                }
        );
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
                e -> {
                    for (Shape shape : control.getShapes()) {
                        shape.Moving = false;
                    }
                });
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                e -> {
                    var update = false;
                    for (Shape shape : control.getShapes()) {
                        if (shape.Moving) {
                            shape.X = e.getX() + shape.Xd;
                            shape.Y = e.getY() + shape.Yd;
                            update = true;
                        }
                    }
                    if (update) {
                        Render(gc, canvas, control.getShapes());
                    }
                });


        stage.show();
    }

    public void Render(GraphicsContext gc, Canvas canvas, ArrayList<Shape> shapes) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.color(Shape.ShColor.r, Shape.ShColor.g, Shape.ShColor.b));
        gc.setStroke(Color.BLACK);

        for (Shape shape : shapes)
            shape.Draw(gc);

    }
}