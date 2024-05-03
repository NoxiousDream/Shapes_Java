package shapes.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape {

    public Circle(double x, double y) {
        X = x;
        Y = y;
        Moving = false;
    }

    @Override
    public void Draw(GraphicsContext gc) {
        gc.fillOval(X - (0.5 * Radius), Y - (0.5 * Radius), Radius, Radius);
        gc.strokeOval(X - (0.5 * Radius), Y - (0.5 * Radius), Radius, Radius);
    }

    @Override
    public boolean IsInside(double xMouse, double yMouse) {
        return Math.pow(xMouse - X, 2) + Math.pow(yMouse - Y, 2) <= Math.pow(Radius, 2);
    }
}

