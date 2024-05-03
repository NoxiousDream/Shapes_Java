package shapes.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class Triangle extends Shape {

    public Triangle(double x, double y) {
        X = x;
        Y = y;
        Moving = false;
    }

    @Override
    public void Draw(GraphicsContext gc) {

    }

    @Override
    public boolean IsInside(double xMouse, double yMouse) {

        var xcos = Math.sqrt(3) / 2 * Radius;
        var a = new Point((int) (X + xcos), (int) (Y + Radius * 0.5));
        var b = new Point((int)X, (int)(Y - Radius));
        var c = new Point((int) (X - xcos), (int) (Y + Radius * 0.5));
        var p = new Point((int)xMouse, (int)yMouse);

        var abc = TriangleArea(a, b, c);
        var abp = TriangleArea(a, b, p);
        var acp = TriangleArea(a, c, p);
        var bcp = TriangleArea(b, c, p);

        return Math.abs(abc - (abp + acp + bcp)) < 0.0001;
    }

    private static double TriangleArea(Point a, Point b, Point c)
    {
        return Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0);
    }
}
