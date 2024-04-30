package shapes.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    protected static int Radius;
    protected double X;
    protected double Y;
    protected boolean Moving;
    protected Color Colour;

    public static Shape newShape(int x, int y, ShapeType type) {
        return switch (type) {
            case Circle -> new Circle(x, y);
            case Triangle -> new Triangle(x, y);
            case Square -> new Square(x, y);
        };
    }

    public abstract void Draw(GraphicsContext gc);

    public abstract boolean IsInside(int xMouse, int yMouse);
}

