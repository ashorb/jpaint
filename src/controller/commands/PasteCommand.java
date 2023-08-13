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
    int offset = 50;

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

                shapeToPaste = shape;

                startPoint.x = shapeToPaste.getStartX() + offset;
                startPoint.y = shapeToPaste.getStartY() + offset;
                endPoint.x = shapeToPaste.getEndX() + offset;
                endPoint.y = shapeToPaste.getEndY() + offset;

//                System.out.println(shape + " " + shape.getPrimaryColor() + " " + shape.getSecondaryColor());
                if (shape.getIShapeType().equals("GROUP")) {
                    shapeToPaste = new GroupedShapes(startPoint, endPoint, offset);
                    createGroupToPaste(shape, shapeToPaste);
                    shapeToPaste.move(offset,offset);
                } else {
                    shapeAttributes = new ShapeAttributes(shape.getShapeType(), shape.getShapeShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor());

                    if (shape.getIShapeType().equals("RECTANGLE")) {
                        shapeToPaste = ShapeFactory.createRectangle(appState, shapeAttributes, startPoint, endPoint);
                    } else if (shape.getIShapeType().equals("ELLIPSE")) {
                        shapeToPaste = ShapeFactory.createEllipse(appState, shapeAttributes, startPoint, endPoint);
                    } else if (shape.getIShapeType().equals("TRIANGLE")) {
                        shapeToPaste = ShapeFactory.createTriangle(appState, shapeAttributes, startPoint, endPoint);
                    }
                }
                pastedShapeList.add(shapeToPaste);
            }
            for (IShape shape : pastedShapeList) {
                shapeList.add(shape);
            }
            System.out.println("pasted: " + pastedShapeList);
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
                System.out.println(shape + " " + shape.getPrimaryColor());
                shapeToPaste.getChildren().add(ShapeFactory.createRectangle(appState, shapeAttributes, startPoint, endPoint));
            } else if (shape.getIShapeType().equals("ELLIPSE")) {
                System.out.println(shape + " " + shape.getPrimaryColor());
                shapeToPaste.getChildren().add(ShapeFactory.createEllipse(appState, shapeAttributes, startPoint, endPoint));
            } else if (shape.getIShapeType().equals("TRIANGLE")) {
                System.out.println(shape + " " + shape.getPrimaryColor());
                shapeToPaste.getChildren().add(ShapeFactory.createTriangle(appState, shapeAttributes, startPoint, endPoint));
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
