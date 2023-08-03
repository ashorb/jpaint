package controller.commands;

import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import model.*;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.persistence.CommandHistory;

import java.util.ArrayList;

public class PasteCommand implements ICommand, IUndoable {
    private final ShapeList shapeList;
    private final ArrayList<IShape> pastedShapeList = new ArrayList<>();
    private final Point startPoint = new Point();
    private final Point endPoint = new Point();

    IApplicationState appState;
    ShapeAttributes shapeAttributes;
    IShape shapeToPaste;


    public PasteCommand(IApplicationState appState, ShapeList shapeList) {
        this.shapeList = shapeList;
        this.appState = appState;
    }

    @Override
    public void execute() {
        if (!(shapeList.getCopyList().isEmpty())) {
            for (IShape shape : shapeList.getCopyList()) {
                int offset = 50;

                shapeAttributes = new ShapeAttributes(shape.getShapeType(), shape.getShapeShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor());
                shapeToPaste = shape;

                startPoint.x = shapeToPaste.getStartX() + offset;
                startPoint.y = shapeToPaste.getStartY() + offset;
                endPoint.x = shapeToPaste.getEndX() + offset;
                endPoint.y = shapeToPaste.getEndY() + offset;

                if (shape.getShapeType().equals(ShapeType.RECTANGLE)) {
                    shapeToPaste = ShapeFactory.createRectangle(appState, shapeAttributes, startPoint, endPoint);
                } else if (shape.getShapeType().equals(ShapeType.ELLIPSE)) {
                    shapeToPaste = ShapeFactory.createEllipse(appState, shapeAttributes, startPoint, endPoint);
                } else if (shape.getShapeType().equals(ShapeType.TRIANGLE)) {
                    shapeToPaste = ShapeFactory.createTriangle(appState, shapeAttributes, startPoint, endPoint);
                }

                pastedShapeList.add(shapeToPaste);
            }

            for (IShape shape : pastedShapeList) {
                shapeList.add(shape);
            }

            CommandHistory.add(this);
        }
    }

    @Override
    public void undo() {
        for (IShape shape : pastedShapeList) {
            shapeList.remove(shape);
        }
    }

    @Override
    public void redo() {
        for (IShape shape : pastedShapeList) {
            shapeList.add(shape);
        }
    }
}
