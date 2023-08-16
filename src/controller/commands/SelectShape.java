package controller.commands;

import controller.ObserverSubject;
import controller.interfaces.ICommand;
import model.*;
import model.interfaces.IShape;

public class SelectShape extends ObserverSubject implements ICommand {
    private final ShapeList shapeList;
    private final Point startPoint;
    private final Point endPoint;
    ShapeAttributes shapeAttributes;

    int x;
    int y;
    int height;
    int width;

    public SelectShape(ShapeList shapeList, Point startPoint, Point endPoint) {
        this.shapeList = shapeList;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public SelectShape(ShapeList shapeList, ShapeAttributes shapeAttributes, Point startPoint, Point endPoint) {
        this.shapeList = shapeList;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeAttributes = shapeAttributes;
    }

    @Override
    public void execute() {
        for (IShape shape: shapeList.getMasterList()) {
            shape.setIsSelected(false);
        }
        shapeList.getSelectedList().clear();

        x = Math.min(startPoint.getX(), endPoint.getX());
        y = Math.min(startPoint.getY(), endPoint.getY());
        width = Math.abs(endPoint.getX() - startPoint.getX());
        height = Math.abs(endPoint.getY() - startPoint.getY());

        for (IShape shape: shapeList.getMasterList()) {
            if (collision(shape)) {
                shape.setIsSelected(true);
                shapeList.getSelectedList().add(shape);
            } else {
                shape.setIsSelected(false);
            }
        }
        notifyShapeListObservers();
    }

    public boolean collision(IShape shape){
        if(
                x < shape.getX() + shape.getWidth() &&
                        x + width > shape.getX() &&
                        y < shape.getY() + shape.getHeight() &&
                        y + height > shape.getY()
        ) {
            return true;
        } else {
            return false;
        }
    }

    private void notifyShapeListObservers(){
        for (var shapeListObserver : getShapeListObservers()){
            shapeListObserver.update();
        }
    }
}
