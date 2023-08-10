package model;

import controller.ObserverSubject;
import controller.commands.SelectShape;
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



    public void getGroupedShapes(ShapeList shapeList){

        group = new GroupedShapes();

        System.out.println(shapeList.getMasterList());

        for (IShape shape : shapeList.getSelectedList()){
            shapeList.getMasterList().remove(shape);
            group.addIShape(shape);
        }


        shapeList.getMasterList().add(group);

//        group.setGroupCoordinates();

//        System.out.println("Factory getGroupedShapes (children): " + group.getChildren());
//        System.out.println("Factory getGroupedShapes (Selected): " + shapeList.getSelectedList());
//        System.out.println("Factory getGroupedShapes (Master): " + shapeList.getMasterList());

        groups.add(group);

        shapeList.getSelectedList().clear();
        group.setIsSelected(true);
        shapeList.getSelectedList().add(group);

//        System.out.println("Factory getGroupedShapes (Selected): " + shapeList.getSelectedList());



        notifyShapeListObservers();
        CommandHistory.add(this);
    }


    @Override
    public void undo() {
        for (IShape group : groups) {
            shapeList.remove(group);
        }
    }

    @Override
    public void redo() {
        for (IShape group : groups) {
            shapeList.add(group);
        }
    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : getShapeListObservers()){
            shapeListObserver.update();
        }
    }
}
