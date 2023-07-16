package controller;

import model.Point;
import model.interfaces.IShape;
import controller.interfaces.IUndoable;
import model.persistence.CommandHistory;
import controller.interfaces.IShapeListObserver;

import java.util.ArrayList;
import java.util.List;

public class MoveShape extends ObserverSubject implements IUndoable {
    private final ArrayList<IShape> movedShapeList = new ArrayList<IShape>();
    private final ArrayList<IShape> selectedShapeList;
//    private final List<IShapeListObserver> shapeListObservers;
    int deltaX;
    int deltaY;


    public MoveShape(ArrayList<IShape> selectedShapeList, List<IShapeListObserver> shapeListObservers) {
        this.selectedShapeList = selectedShapeList;
//        this.shapeListObservers = shapeListObservers;
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

//    private void notifyShapeListObservers(){
//        for (var shapeListObserver : shapeListObservers){
//            shapeListObserver.update();
//        }
//    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : getShapeListObservers()){
            shapeListObserver.update();
        }
    }
}
