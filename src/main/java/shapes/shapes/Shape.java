package shapes.shapes;

import javafx.scene.canvas.GraphicsContext;
import shapes.shapes.utils.Color;
import shapes.shapes.utils.ShapeType;

public abstract class Shape {
    protected static double Radius = 40;
    public static Color ShColor = new Color();
    public double X, Y;
    public double Xd, Yd;
    protected boolean Moving;

    public static Shape newShape(double x, double y, ShapeType type) {
        return switch (type) {
            case Circle -> new Circle(x, y);
            case Triangle -> new Triangle(x, y);
            case Square -> new Square(x, y);
        };
    }

    public abstract void Draw(GraphicsContext gc);

    public abstract boolean IsInside(double xMouse, double yMouse);
}

