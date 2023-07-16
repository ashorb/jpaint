package model;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

public class ShapeFactory {
    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;

    public static IShape createRectangle(ApplicationState appState, Point startPoint, Point endPoint){
        startX = startPoint.getX();
        startY = startPoint.getY();
        endX = endPoint.getX();
        endY = endPoint.getY();

        return new Rectangle(appState, startX, startY, endX, endY);
    }

    public static IShape createEllipse(ApplicationState appState, Point startPoint, Point endPoint){
        startX = startPoint.getX();
        startY = startPoint.getY();
        endX = endPoint.getX();
        endY = endPoint.getY();

        return new Ellipse(appState, startX, startY, endX, endY);
    }

    public static IShape createTriangle(ApplicationState appState, Point startPoint, Point endPoint){
        startX = startPoint.getX();
        startY = startPoint.getY();
        endX = endPoint.getX();
        endY = endPoint.getY();

        return new Triangle(appState, startX, startY, endX, endY);
    }
}
