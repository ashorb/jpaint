package model;

import controller.ObserverSubject;
import model.interfaces.IShape;

public class GroupedShapesFactory extends ObserverSubject {

    public void getGroupedShapes(ShapeList shapeList){
        GroupedShapes group = new GroupedShapes();

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
        notifyShapeListObservers();

//        for (IShape shape : shapeList.getMasterList()){
//            shape.getStartX();
//            shape.getStartY();
//            shape.getEndX();
//            shape.getEndY();
//        }
    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : getShapeListObservers()){
            shapeListObserver.update();
        }
    }
}
