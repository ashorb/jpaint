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


    private final ArrayList<IShape> pastedShapeList = new ArrayList<IShape>();

//    public ArrayList<IShape> getPastedShapeList() {
//        return pastedShapeList;
//    }

    //    private int startX;
//    private int endX;
    private final Point startPoint = new Point();
    private final Point endPoint = new Point();
//    ICommand command;
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
//                startPoint.x = shape.getStartX() + offset;
//                startPoint.y = shape.getStartY() + offset;
//                endPoint.x = shape.getEndX() + offset;
//                endPoint.y = shape.getEndY() + offset;

                shapeAttributes = new ShapeAttributes(shape.getShapeType(), shape.getShapeShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor());

                shapeToPaste = shape;
//                ishape.paste();

                startPoint.x = shapeToPaste.getStartX() + offset;
                startPoint.y = shapeToPaste.getStartY() + offset;
                endPoint.x = shapeToPaste.getEndX() + offset;
                endPoint.y = shapeToPaste.getEndY() + offset;

//                ShapeType shapeType = shape.getShapeType();
//                System.out.println(shapeType);

//                command = new CreateShape(appState, shapeList, shapeAttributes, startPoint, endPoint);
//                command.execute();
//                pastedShapeList.add(shape);

                if (shape.getShapeType().equals(ShapeType.RECTANGLE)) {
                    shapeToPaste = ShapeFactory.createRectangle(appState, shapeAttributes, startPoint, endPoint);
                }
                else if (shape.getShapeType().equals(ShapeType.ELLIPSE)) {
                    shapeToPaste = ShapeFactory.createEllipse(appState, shapeAttributes, startPoint, endPoint);
                }
                else if (shape.getShapeType().equals(ShapeType.TRIANGLE)){
                    shapeToPaste = ShapeFactory.createTriangle(appState, shapeAttributes, startPoint, endPoint);
                }

//                shapeList.add(ishape);


//                shapeList.getSelectedList().add(shape);

                pastedShapeList.add(shapeToPaste);
//                CommandHistory.add(this);

//                startX = shape.getStartX() + 20;
//                endX = shape.getEndX() + 20;

//                shape.move(50,50);

//                shapeList.add(shape);
            }

            for (IShape shape : pastedShapeList){
//                if (!shapeList.getMasterList().contains(shape)){
                    shapeList.add(shape);
//                }
            }

            CommandHistory.add(this);

//            command = new SelectShape(appState, shapeList, startPoint, endPoint);
//            command.execute();
//
//            command = new CopyCommand(shapeList);
//            command.execute();
        }

//        for (IShape shape : shapeList.getMasterList()){
//            if (!shapeList.getSelectedList().contains(shape)){
//                shapeList.getSelectedList().add(shape);
//                startPoint.x = shape.getStartX() + offset;
//                startPoint.y = shape.getStartY() + offset;
//                endPoint.x = shape.getEndX() + offset;
//                endPoint.y = shape.getEndY() + offset;
//                command = new SelectShape(appState, shapeList, startPoint, endPoint);
//            }
//        }

        System.out.println();
        System.out.println("master list: " + shapeList.getMasterList());
        System.out.println("selected list: " + shapeList.getSelectedList());
        System.out.println("copy list: " + shapeList.getCopyList());
        System.out.println("pasted list: " + pastedShapeList);
    }

    @Override
    public void undo() {
//        shapeList.removePasted(pastedShapeList);

        for (IShape shape : pastedShapeList) {
            shapeList.remove(shape);
        }

        System.out.println();
        System.out.println("UNDO master list: " + shapeList.getMasterList());
        System.out.println("UNDO selected list: " + shapeList.getSelectedList());
        System.out.println("UNDO copy list: " + shapeList.getCopyList());
        System.out.println("UNDO pasted list: " + pastedShapeList);

//        pastedShapeList.clear();
//        shapeList.remove();


//        for (IShape shape : pastedShapeList) {
//            shapeList.removePasted();
//        }
//
//        for(IShape shape : pastedShapeList) {
//            if (shapeList.getMasterList().contains(shape)) {
//                shapeList.getMasterList().remove(shape);
//            }
//        }
    }

    @Override
    public void redo() {
        for (IShape shape : pastedShapeList) {
            shapeList.add(shape);
        }

        System.out.println();
        System.out.println("REDO master list: " + shapeList.getMasterList());
        System.out.println("REDO selected list: " + shapeList.getSelectedList());
        System.out.println("REDO copy list: " + shapeList.getCopyList());
        System.out.println("REDO pasted list: " + pastedShapeList);
    }
}
