package controller;

import model.Point;
import model.ShapeFactory;
import model.ShapeList;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.util.ArrayList;

public class SelectShape {
    private final ArrayList<IShape> selectedShapeList = new ArrayList<IShape>();
    private IShape selectionBox;

    public void selectShape(ApplicationState appState, ShapeList shapeList, Point startPoint, Point endPoint){
        selectedShapeList.clear();
        selectionBox = ShapeFactory.createRectangle(appState, startPoint, endPoint);

        int count = 0;

        for (IShape shape: shapeList.getList()) {
            if (collision(selectionBox, shape)) {
                selectedShapeList.add(shape);

                count++;
                System.out.println(count);
            }
        }
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

    public ArrayList<IShape> getList() {
        return selectedShapeList;
    }
}
