package view;

import controller.CreateShape;
import controller.MoveShape;
import controller.SelectShape;
import model.Point;
import model.ShapeList;
import model.persistence.ApplicationState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickHandler extends MouseAdapter {

    private final ApplicationState appState;
    private final ShapeList shapeList;
    SelectShape selectedShapes = new SelectShape();
    private final Point startPoint = new Point();
    private final Point endPoint = new Point();

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



        switch (appState.getActiveMouseMode()){
            case SELECT:
                selectedShapes.selectShape(appState, shapeList, startPoint, endPoint);
                System.out.println(selectedShapes.getList());
                break;
            case MOVE:
                MoveShape move = new MoveShape(selectedShapes.getList(), shapeList.getShapeListObservers());
                move.moveShape(startPoint, endPoint);
                System.out.println(selectedShapes.getList());
                break;
            case DRAW:
                if(width != 0 && height != 0) {
                    CreateShape createNew = new CreateShape();
                    createNew.createShape(appState, shapeList, startPoint, endPoint);
                };
                break;
        }

        System.out.println("Released: x = " + endPoint.x + " y = " +  endPoint.y);
    }
}
