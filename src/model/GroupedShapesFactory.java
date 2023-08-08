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



    public void getGroupedShapes(ShapeList shapeList){

        group = new GroupedShapes();

        System.out.println(shapeList.getMasterList());

        for (IShape shape : shapeList.getSelectedList()){
            shapeList.getMasterList().remove(shape);
            group.addIShape(shape);
        }

        shapeList.getMasterList().add(group);

        group.setGroupCoordinates();

        System.out.println("Children: " + group.getChildren());

        System.out.println("Selected: " + shapeList.getSelectedList());
        System.out.println("Master: " + shapeList.getMasterList());

        group.setIsSelected(true);
        System.out.println("Selected: " + shapeList.getSelectedList());

        groups.add(group);

        notifyShapeListObservers();
        CommandHistory.add(this);

//        for (IShape shape : shapeList.getMasterList()){
//            shape.getStartX();
//            shape.getStartY();
//            shape.getEndX();
//            shape.getEndY();
//        }
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
