package controller.commands;

import controller.ObserverSubject;
import controller.interfaces.IUndoable;
import model.GroupedShapes;
import model.ShapeList;
import model.interfaces.IShape;
import model.persistence.CommandHistory;

import java.util.ArrayList;

public class UngroupShapes extends ObserverSubject implements IUndoable {

    public ArrayList<IShape> groups = new ArrayList<>();
    ShapeList shapeList;

    public UngroupShapes(ShapeList shapeList){
        this.shapeList = shapeList;
    }

    public void ungroupShapes() {
        for (IShape group : shapeList.getSelectedList()) {
            if (group.getIShapeType().equals("GROUP")) {
                groups.add(group);

                System.out.println("children undo: " + group.getChildren());

                if (shapeList.getMasterList().contains(group)) {
                    for (IShape shape : group.getChildren()) {
                        if (!shapeList.getMasterList().contains(shape)) {
                            shapeList.add(shape);
                            notifyShapeListObservers();
                        }
                    }
                    shapeList.remove(group);
                    CommandHistory.add(this);
                    notifyShapeListObservers();
                }
            }
        }
    }

    @Override
    public void undo() {
        for (IShape group : groups) {
            for (IShape child : group.getChildren()){
                child.setIsSelected(false);
                if (shapeList.getMasterList().contains(child)){
                    shapeList.remove(child);
                    notifyShapeListObservers();
                }
            }
            shapeList.add(group);
        }
    }

    @Override
    public void redo() {
        for (IShape group : groups) {
            if (shapeList.getMasterList().contains(group)) {
                for (IShape shape : group.getChildren()) {
                    if (!shapeList.getMasterList().contains(shape)) {
                        shapeList.add(shape);
                        notifyShapeListObservers();
                    }
                }
                shapeList.remove(group);
                notifyShapeListObservers();
            }
        }
    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : getShapeListObservers()){
            shapeListObserver.update();
        }
    }
}
