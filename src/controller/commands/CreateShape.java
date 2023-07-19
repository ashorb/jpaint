package controller.commands;

import controller.interfaces.ICommand;
import model.Point;
import model.ShapeFactory;
import model.ShapeType;
import controller.interfaces.IUndoable;
import model.interfaces.IShape;
import model.ShapeList;
import model.persistence.ApplicationState;
import model.persistence.CommandHistory;

public class CreateShape implements ICommand, IUndoable {
    private IShape ishape;
    private static ShapeList list;
    private final ApplicationState appState;
    private final ShapeList shapeList;
    private final Point startPoint;
    private final Point endPoint;

    public CreateShape(ApplicationState appState, ShapeList shapeList, Point startPoint, Point endPoint) {
        this.appState = appState;
        this.shapeList = shapeList;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void execute() {
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
