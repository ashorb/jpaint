package controller;

import model.Point;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.CommandHistory;
import view.interfaces.IShapeListObserver;

import java.util.ArrayList;
import java.util.List;

public class MoveShape implements IUndoable {
    private ArrayList<IShape> movedShapeList = new ArrayList<IShape>();
    private ArrayList<IShape> selectedShapeList;
    private List<IShapeListObserver> shapeListObservers;
    int deltaX;
    int deltaY;

    public MoveShape(ArrayList<IShape> selectedShapeList, List<IShapeListObserver> shapeListObservers) {
        this.selectedShapeList = selectedShapeList;
        this.shapeListObservers = shapeListObservers;
    }

    public void moveShape(Point startPoint, Point endPoint){
        deltaX = endPoint.getX() - startPoint.getX();
        deltaY = endPoint.getY() - startPoint.getY();

        System.out.println("here: " + selectedShapeList);

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
        for (var shapeListObserver : shapeListObservers){
            shapeListObserver.update();
        }
    }
}
