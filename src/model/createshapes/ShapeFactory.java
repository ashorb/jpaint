package model.createshapes;

import model.Point;
import model.ShapeAttributes;
import model.interfaces.IShape;

public class ShapeFactory {
    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;

    public static IShape createRectangle(ShapeAttributes shapeAttributes, Point startPoint, Point endPoint){
        startX = startPoint.getX();
        startY = startPoint.getY();
        endX = endPoint.getX();
        endY = endPoint.getY();

        return new Rectangle(shapeAttributes, startX, startY, endX, endY);
    }

    public static IShape createEllipse(ShapeAttributes shapeAttributes, Point startPoint, Point endPoint){
        startX = startPoint.getX();
        startY = startPoint.getY();
        endX = endPoint.getX();
        endY = endPoint.getY();

        return new Ellipse(shapeAttributes, startX, startY, endX, endY);
    }

    public static IShape createTriangle(ShapeAttributes shapeAttributes, Point startPoint, Point endPoint){
        startX = startPoint.getX();
        startY = startPoint.getY();
        endX = endPoint.getX();
        endY = endPoint.getY();

        int[] xPoints = new int[]{startX, endX, startX};
        int[] yPoints = new int[]{startY, endY, endY};

        return new Triangle(shapeAttributes, startX, startY, endX, endY, xPoints, yPoints);
    }
}
