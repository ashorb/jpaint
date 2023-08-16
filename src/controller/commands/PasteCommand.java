package controller.commands;

import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import model.*;
import model.interfaces.IShape;
import model.persistence.CommandHistory;
import model.createshapes.GroupedShapes;
import model.createshapes.ShapeFactory;

import java.util.ArrayList;

public class PasteCommand implements ICommand, IUndoable {
    private final ShapeList shapeList;
    private final ArrayList<IShape> pastedShapeList = new ArrayList<>();
    private final Point startPoint = new Point();
    private final Point endPoint = new Point();
    int offset = 50;

    ShapeAttributes shapeAttributes;
    IShape shapeToPaste;


    public PasteCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        if (!(shapeList.getCopyList().isEmpty())) {
            for (IShape shape : shapeList.getCopyList()) {
                shapeToPaste = shape;

                startPoint.x = shapeToPaste.getStartX() + offset;
                startPoint.y = shapeToPaste.getStartY() + offset;
                endPoint.x = shapeToPaste.getEndX() + offset;
                endPoint.y = shapeToPaste.getEndY() + offset;

                if (shape.getIShapeType().equals("GROUP")) {
                    shapeToPaste = new GroupedShapes(startPoint, endPoint, offset);
                    createGroupToPaste(shape, shapeToPaste);
                    shapeToPaste.move(offset,offset);
                } else {
                    shapeAttributes = new ShapeAttributes(shape.getShapeType(), shape.getShapeShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor());

                    if (shape.getIShapeType().equals("RECTANGLE")) {
                        shapeToPaste = ShapeFactory.createRectangle(shapeAttributes, startPoint, endPoint);
                    } else if (shape.getIShapeType().equals("ELLIPSE")) {
                        shapeToPaste = ShapeFactory.createEllipse(shapeAttributes, startPoint, endPoint);
                    } else if (shape.getIShapeType().equals("TRIANGLE")) {
                        shapeToPaste = ShapeFactory.createTriangle(shapeAttributes, startPoint, endPoint);
                    }
                }
                pastedShapeList.add(shapeToPaste);
            }
            for (IShape shape : pastedShapeList) {
                shapeList.add(shape);
            }
            CommandHistory.add(this);
        }
    }

    public void createGroupToPaste(IShape shape, IShape shapeToPaste) {
        for (IShape s : shape.getChildren()) {
            createGroupToPasteRecursive(s, shapeToPaste);
        }
    }

    public void createGroupToPasteRecursive(IShape shape, IShape shapeToPaste) {
        if (shape.getIShapeType().equals("GROUP")) {
            for (IShape s : shape.getChildren()) {
                createGroupToPasteRecursive(s, shapeToPaste);
            }

        } else {
            startPoint.x = shape.getStartX() + offset;
            startPoint.y = shape.getStartY() + offset;
            endPoint.x = shape.getEndX() + offset;
            endPoint.y = shape.getEndY() + offset;

            shapeAttributes = new ShapeAttributes(shape.getShapeType(), shape.getShapeShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor());

            if (shape.getIShapeType().equals("RECTANGLE")) {
                shapeToPaste.getChildren().add(ShapeFactory.createRectangle(shapeAttributes, startPoint, endPoint));
            } else if (shape.getIShapeType().equals("ELLIPSE")) {
                shapeToPaste.getChildren().add(ShapeFactory.createEllipse(shapeAttributes, startPoint, endPoint));
            } else if (shape.getIShapeType().equals("TRIANGLE")) {
                shapeToPaste.getChildren().add(ShapeFactory.createTriangle(shapeAttributes, startPoint, endPoint));
            }
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
