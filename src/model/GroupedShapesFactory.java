package model;

import controller.ObserverSubject;
import controller.interfaces.IUndoable;
import model.interfaces.IShape;
import model.persistence.CommandHistory;

import java.util.ArrayList;

public class GroupedShapesFactory extends ObserverSubject implements IUndoable {
    public ArrayList<GroupedShapes> groups = new ArrayList<>();
    ShapeList shapeList;
    GroupedShapes group;

    public GroupedShapesFactory(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    public void getGroupedShapes(){
        group = new GroupedShapes();

        for (IShape shape : shapeList.getSelectedList()){
            if (shapeList.getMasterList().contains(shape)) {
                shapeList.getMasterList().remove(shape);
                group.addIShape(shape);
            }
        }

        shapeList.getMasterList().add(group);
        groups.add(group);
        shapeList.getSelectedList().clear();
        group.setIsSelected(true);
        shapeList.getSelectedList().add(group);
        CommandHistory.add(this);
        notifyShapeListObservers();
    }

    @Override
    public void undo() {
        for (IShape group : groups) {
            System.out.println("children undo: " + group.getChildren());
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

    @Override
    public void redo() {
        for (IShape group : groups) {
            System.out.println("children redo: " + group.getChildren());
            for (IShape child : group.getChildren()){
                    child.setIsSelected(false);
                if (shapeList.getMasterList().contains(child)){
                    shapeList.remove(child);
                    notifyShapeListObservers();
                }
            }
            shapeList.add(group);
        }
        notifyShapeListObservers();
    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : getShapeListObservers()){
            shapeListObserver.update();
        }
    }
}
