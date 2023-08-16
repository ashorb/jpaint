package controller.commands;

import controller.ObserverSubject;
import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import model.createshapes.GroupedShapes;
import model.ShapeList;
import model.interfaces.IShape;
import model.persistence.CommandHistory;

import java.util.ArrayList;

public class GroupCommand extends ObserverSubject implements ICommand, IUndoable {
    public ArrayList<GroupedShapes> groups = new ArrayList<>();
    ShapeList shapeList;
    GroupedShapes group;

    public GroupCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    public void execute(){
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
        shapeList.getSelectedList().clear();
        for(IShape shape : shapeList.getMasterList()){
            shape.setIsSelected(false);
        }

        for (IShape group : groups) {
            if (shapeList.getMasterList().contains(group)) {
                for (IShape shape : group.getChildren()) {
                    if (!shapeList.getMasterList().contains(shape)) {
                        shapeList.add(shape);
                    }
                    shape.setIsSelected(true);
                    shapeList.getSelectedList().add(shape);
                }
                shapeList.remove(group);
            }
            group.setIsSelected(false);
            shapeList.getSelectedList().remove(group);
        }

        notifyShapeListObservers();
    }

    @Override
    public void redo() {
        shapeList.getSelectedList().clear();
        for(IShape shape : shapeList.getMasterList()){
            shape.setIsSelected(false);
        }

        for (IShape group : groups) {
            for (IShape child : group.getChildren()){
                    child.setIsSelected(false);
                if (shapeList.getMasterList().contains(child)){
                    shapeList.remove(child);
                }
            }
            group.setIsSelected(true);
            shapeList.add(group);
            shapeList.getSelectedList().add(group);
        }
        notifyShapeListObservers();
    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : getShapeListObservers()){
            shapeListObserver.update();
        }
    }
}
