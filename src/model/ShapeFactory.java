package model;

import model.interfaces.IApplicationState;
import model.interfaces.IShape;

public class ShapeFactory {
    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;

    public static IShape createRectangle(IApplicationState appState, ShapeAttributes shapeAttributes, Point startPoint, Point endPoint){
        startX = startPoint.getX();
        startY = startPoint.getY();
        endX = endPoint.getX();
        endY = endPoint.getY();

        return new Rectangle(appState, shapeAttributes, startX, startY, endX, endY);
    }

    public static IShape createEllipse(IApplicationState appState,  ShapeAttributes shapeAttributes, Point startPoint, Point endPoint){
        startX = startPoint.getX();
        startY = startPoint.getY();
        endX = endPoint.getX();
        endY = endPoint.getY();

        return new Ellipse(appState, shapeAttributes, startX, startY, endX, endY);
    }

    public static IShape createTriangle(IApplicationState appState,  ShapeAttributes shapeAttributes, Point startPoint, Point endPoint){
        startX = startPoint.getX();
        startY = startPoint.getY();
        endX = endPoint.getX();
        endY = endPoint.getY();

        return new Triangle(appState, shapeAttributes, startX, startY, endX, endY);
    }
}
