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
    }

    @Override
    public boolean IsInside(int xMouse, int yMouse) {
        return Math.pow(xMouse - X, 2) + Math.pow(yMouse - Y, 2) <= Math.pow(Radius, 2);
    }
}

