package controller.commands;

import controller.ObserverSubject;
import controller.interfaces.ICommand;
import model.*;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;

public class SelectShape extends ObserverSubject implements ICommand {
    private final IApplicationState appState;
    private final ShapeList shapeList;
    private final Point startPoint;
    private final Point endPoint;
    ShapeAttributes shapeAttributes;


    public SelectShape(IApplicationState appState, ShapeList shapeList, ShapeAttributes shapeAttributes, Point startPoint, Point endPoint) {
        this.appState = appState;
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

        IShape selectionBox = ShapeFactory.createRectangle(appState, shapeAttributes, startPoint, endPoint);

        for (IShape shape: shapeList.getMasterList()) {
            if (collision(selectionBox, shape)) {
                shape.setIsSelected(true);
                shapeList.getSelectedList().add(shape);
            }
        }
        notifyShapeListObservers();
    }

    public boolean collision(IShape selectionBox, IShape shape){
        if(
                selectionBox.getX() < shape.getX() + shape.getWidth() &&
                        selectionBox.getX() + selectionBox.getWidth() > shape.getX() &&
                        selectionBox.getY() < shape.getY() + shape.getHeight() &&
                        selectionBox.getY() + selectionBox.getHeight() > shape.getY()
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
