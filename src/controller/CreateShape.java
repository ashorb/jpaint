package controller;

import model.Point;
import model.ShapeFactory;
import model.ShapeType;
import controller.interfaces.IUndoable;
import model.interfaces.IShape;
import model.ShapeList;
import model.persistence.ApplicationState;
import model.persistence.CommandHistory;

public class CreateShape implements IUndoable {
    private IShape ishape;
    private static ShapeList list;


    public void createShape(ApplicationState appState, ShapeList shapeList, Point startPoint, Point endPoint){

        if (appState.getActiveShapeType().equals(ShapeType.RECTANGLE)) {
            ishape = ShapeFactory.createRectangle(appState, startPoint, endPoint);
        }
        else if (appState.getActiveShapeType().equals(ShapeType.ELLIPSE)) {
            ishape = ShapeFactory.createEllipse(appState, startPoint, endPoint);
        }
        else if (appState.getActiveShapeType().equals(ShapeType.TRIANGLE)){
            ishape = ShapeFactory.createTriangle(appState, startPoint, endPoint);
        }

        list = shapeList;
        list.add(ishape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        list.remove();
    }

    @Override
    public void redo() {
        list.add(ishape);
    }
}
