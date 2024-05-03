package shapes.shapes;

import shapes.shapes.utils.ShapeType;

import java.util.ArrayList;

public class Control {
    private final ArrayList<Shape> Shapes = new ArrayList<Shape>();
    private final ShapeType ShapeType = shapes.shapes.utils.ShapeType.Circle;

    public ArrayList<Shape> getShapes() {
        return Shapes;
    }

    public int IsInsideAny(double x, double y) {
        for (int i = 0; i < Shapes.size(); i++) {
            Shape shape = Shapes.get(i);
            if (shape.IsInside(x, y)) {
                return i;
            }
        }
        return -1;



    }
    public void AddShape ( double x, double y){
        Shapes.add(Shape.newShape(x, y, ShapeType));
    }
}
