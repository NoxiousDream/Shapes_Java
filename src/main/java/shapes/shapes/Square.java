package shapes.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Square extends Shape {

    public Square(double x, double y) {
        X = x;
        Y = y;
        Moving = false;
    }

    @Override
    public void Draw(GraphicsContext gc) {

    }

    @Override
    public boolean IsInside(double xMouse, double yMouse) {
        return (Math.abs(X - xMouse) <= Radius / Math.sqrt(2)) && (Math.abs(Y - yMouse) <= Radius / Math.sqrt(2));
    }
}
