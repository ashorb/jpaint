package controller.commands;

import controller.ObserverSubject;
import controller.interfaces.ICommand;
import model.Point;
import model.ShapeList;
import model.interfaces.IShape;
import controller.interfaces.IUndoable;
import model.persistence.CommandHistory;

import java.util.ArrayList;

public class MoveShape extends ObserverSubject implements ICommand, IUndoable {
    private final ArrayList<IShape> movedShapeList = new ArrayList<>();
    private final ShapeList shapeList;

    int deltaX;
    int deltaY;

    //flag that allows for only existing (non-deleted) shapes to be moved
    boolean movableShapesFlag;

    private final Point startPoint;
    private final Point endPoint;

    public MoveShape(ShapeList shapeList, Point startPoint, Point endPoint) {
        this.shapeList = shapeList;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void execute() {
        movableShapesFlag = false;

        deltaX = endPoint.getX() - startPoint.getX();
        deltaY = endPoint.getY() - startPoint.getY();

        for (IShape shape : shapeList.getSelectedList()) {
            if (shapeList.getMasterList().contains(shape)) { //check that shapes to be moved exist (not deleted)
                movableShapesFlag = true;
                shape.move(deltaX, deltaY);
                movedShapeList.add(shape);
            }
        }

        if (movableShapesFlag == true) { //if flag is true (shapes have not been deleted), add to CommandHistory and notify observers
            System.out.println("MOVE MASTER: " + shapeList.getMasterList());
            System.out.println("MOVE MOVED: " + movedShapeList);

            CommandHistory.add(this);
            notifyShapeListObservers();
        }
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
