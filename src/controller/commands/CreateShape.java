package controller.commands;

import controller.interfaces.ICommand;
import model.*;
import controller.interfaces.IUndoable;
import model.interfaces.IShape;
import model.persistence.CommandHistory;
import model.createshapes.ShapeFactory;

public class CreateShape implements ICommand, IUndoable {
    private IShape ishape;
    private static ShapeList list;
    private final ShapeList shapeList;
    private final Point startPoint;
    private final Point endPoint;
    private final ShapeType shapeType;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ShapeShadingType shadingType;
    ShapeAttributes shapeAttributes;


    public CreateShape(ShapeList shapeList, ShapeAttributes shapeAttributes, Point startPoint, Point endPoint) {
        this.shapeList = shapeList;

        this.shapeType = shapeAttributes.getShapeType();
        this.shadingType = shapeAttributes.getShapeShadingType();
        this.primaryColor = shapeAttributes.getPrimaryColor();
        this.secondaryColor = shapeAttributes.getSecondaryColor();

        this.shapeAttributes = shapeAttributes;

        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void execute() {
        if (shapeType.equals(ShapeType.RECTANGLE)) {
            ishape = ShapeFactory.createRectangle(shapeAttributes, startPoint, endPoint);
        }
        else if (shapeType.equals(ShapeType.ELLIPSE)) {
            ishape = ShapeFactory.createEllipse(shapeAttributes, startPoint, endPoint);
        }
        else if (shapeType.equals(ShapeType.TRIANGLE)){
            ishape = ShapeFactory.createTriangle(shapeAttributes, startPoint, endPoint);
        }

        list = shapeList;
        list.add(ishape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        list.remove(ishape);
    }

    @Override
    public void redo() {
        list.add(ishape);
    }

}
