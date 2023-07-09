package view;

import controller.CreateShape;
import model.Point;
import model.ShapeList;
import model.persistence.ApplicationState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickHandler extends MouseAdapter {

    private final ApplicationState appState;
    private final ShapeList shapeList;
    Point startPoint = new Point();
    Point endPoint = new Point();

    public ClickHandler(ApplicationState appState, ShapeList shapeList) {
        this.shapeList = shapeList;
        this.appState = appState;
    }

    @Override
    public void mousePressed(MouseEvent e) { //location when mouse pressed
        startPoint.x = e.getX();
        startPoint.y = e.getY();

        System.out.println("Pressed:  x = " + startPoint.x +  " y = " +  startPoint.y);
    }

    @Override
    public void mouseReleased(MouseEvent e) { //location when mouse released
        endPoint.x = e.getX();
        endPoint.y = e.getY();
        int width;
        int height;

        width = Math.abs(endPoint.getX() - startPoint.getX());
        height = Math.abs(endPoint.getY() - startPoint.getY());

        if(width != 0 && height != 0) {
            CreateShape createNew = new CreateShape();
            createNew.createShape(appState, shapeList, startPoint, endPoint);
        }

        System.out.println("Released: x = " + endPoint.x + " y = " +  endPoint.y);
//        System.out.println("height: " + height + " width: " +  width);
    }
}
