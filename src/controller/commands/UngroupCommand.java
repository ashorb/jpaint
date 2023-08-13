package controller.commands;

import controller.ObserverSubject;
import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import model.ShapeList;
import model.interfaces.IShape;
import model.persistence.CommandHistory;

import java.util.ArrayList;

public class UngroupCommand extends ObserverSubject implements ICommand, IUndoable {

    public ArrayList<IShape> groups = new ArrayList<>();
    ShapeList shapeList;

    public UngroupCommand(ShapeList shapeList){
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        System.out.println("selected: " + shapeList.getSelectedList());

        for (IShape group : shapeList.getSelectedList()) {
            System.out.println(shapeList.getSelectedList() + " " + group.getIShapeType() + " " + group.getIsSelected());

            if (group.getIShapeType().equals("GROUP")) {
                groups.add(group);

                if (shapeList.getMasterList().contains(group)) {
                    shapeList.remove(group);
                }

                CommandHistory.add(this);
            }
        }

        shapeList.getSelectedList().clear();

        for (IShape group : groups) {
            shapeList.getSelectedList().remove(group);

            for (IShape shape : group.getChildren()) {
                if (!shapeList.getMasterList().contains(shape)) {
                    shapeList.add(shape);
                }
                shape.setIsSelected(true);
                shapeList.getSelectedList().add(shape);
            }
        }

        notifyShapeListObservers();
        System.out.println("selected after: " + shapeList.getSelectedList());
    }

    @Override
    public void undo() {
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
            notifyShapeListObservers();
        }
    }

    @Override
    public void redo() {
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
