package controller.commands;

import controller.ObserverSubject;
import controller.interfaces.ICommand;
import model.Point;
import model.interfaces.IShape;
import controller.interfaces.IUndoable;
import model.persistence.CommandHistory;

import java.util.ArrayList;

public class MoveShape extends ObserverSubject implements ICommand, IUndoable {
    private final ArrayList<IShape> movedShapeList = new ArrayList<IShape>();
    private final ArrayList<IShape> selectedShapeList;

    int deltaX;
    int deltaY;

    private final Point startPoint;
    private final Point endPoint;

    public MoveShape(ArrayList<IShape> selectedShapeList, Point startPoint, Point endPoint) {
        this.selectedShapeList = selectedShapeList;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void execute() {
        deltaX = endPoint.getX() - startPoint.getX();
        deltaY = endPoint.getY() - startPoint.getY();

        for (IShape shape : selectedShapeList) {
            shape.move(deltaX, deltaY);
            movedShapeList.add(shape);
        }
        CommandHistory.add(this);
        notifyShapeListObservers();
    }

    @Override
    public void undo() {
        for (IShape shape : movedShapeList) {
            shape.move(-deltaX, -deltaY);
        }
        notifyShapeListObservers();
    }

    @Override
    public void redo() {
        for (IShape shape : movedShapeList) {
            shape.move(deltaX, deltaY);
        }
        notifyShapeListObservers();
    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : getShapeListObservers()){
            shapeListObserver.update();
        }
    }
}
