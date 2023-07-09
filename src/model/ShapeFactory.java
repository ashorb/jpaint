package model;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

public class ShapeFactory {
    public static IShape chooseShape(ApplicationState appState, Point startPoint, Point endPoint){
        int startX = startPoint.getX();
        int startY = startPoint.getY();
        int endX = endPoint.getX();
        int endY = endPoint.getY();

        if (appState.getActiveShapeType().equals(ShapeType.RECTANGLE)) {
            return new Rectangle(appState, startX, startY, endX, endY);
        }
        else if (appState.getActiveShapeType().equals(ShapeType.ELLIPSE)) {
            return new Ellipse(appState, startX, startY, endX, endY);
        }
        else {
            return new Triangle(appState, startX, startY, endX, endY);
        }
    }

//    public static IShape createRectangle(int x, int y, int width, int height){
////        return new IShape(x, y, width, height);
//        return new Rectangle(x, y, width, height);
//    }

//    public static IShape createEllipse(int x, int y, int width, int height){
//        return new Ellipse(x, y, width, height);
//    }
//
//    public static IShape createTriangle(int x, int y, int width, int height){
//
//        return new Triangle(x, y, width, height);
//    }
}
