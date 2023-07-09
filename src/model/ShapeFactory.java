package model;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

public class ShapeFactory {
    static int startX;
    static int startY;
    static int endX;
    static int endY;

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

//    public static IShape chooseShape(ApplicationState appState, Point startPoint, Point endPoint){
//        int startX = startPoint.getX();
//        int startY = startPoint.getY();
//        int endX = endPoint.getX();
//        int endY = endPoint.getY();
//
//        if (appState.getActiveShapeType().equals(ShapeType.RECTANGLE)) {
//            return new Rectangle(appState, startX, startY, endX, endY);
//        }
//        else if (appState.getActiveShapeType().equals(ShapeType.ELLIPSE)) {
//            return new Ellipse(appState, startX, startY, endX, endY);
//        }
//        else {
//            return new Triangle(appState, startX, startY, endX, endY);
//        }
//    }
    
}
