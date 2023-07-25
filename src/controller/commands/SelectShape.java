package controller.commands;

import controller.ObserverSubject;
import controller.interfaces.ICommand;
import model.Point;
import model.ShapeFactory;
import model.ShapeList;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

public class SelectShape extends ObserverSubject implements ICommand {
    private final ApplicationState appState;
    private final ShapeList shapeList;
    private final Point startPoint;
    private final Point endPoint;

    public SelectShape(ApplicationState appState, ShapeList shapeList, Point startPoint, Point endPoint) {
        this.appState = appState;
        this.shapeList = shapeList;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void execute() {
        for (IShape shape: shapeList.getList()) {
            shape.setIsSelected(false);
        }
        shapeList.getSelectedList().clear();
        IShape selectionBox = ShapeFactory.createRectangle(appState, startPoint, endPoint);

        for (IShape shape: shapeList.getList()) {
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
