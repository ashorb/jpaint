package controller.commands;

import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import model.*;
import model.interfaces.IShape;
import model.persistence.CommandHistory;

import java.util.ArrayList;

public class DeleteCommand implements ICommand, IUndoable {
    private final ShapeList shapeList;
    private final ArrayList<IShape> deletedShapeList = new ArrayList<IShape>();
    IShape shapeToDelete;


    public DeleteCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        if (!(shapeList.getSelectedList().isEmpty())) {
            for (IShape shape : shapeList.getSelectedList()) {
                shapeToDelete = shape;
                deletedShapeList.add(shapeToDelete);
            }
            for (IShape shape : deletedShapeList){
                    shapeList.remove(shape);
            }
            CommandHistory.add(this);
        }
        System.out.println();
        System.out.println("master list: " + shapeList.getMasterList());
        System.out.println("selected list: " + shapeList.getSelectedList());
        System.out.println("copy list: " + shapeList.getCopyList());
        System.out.println("deleted list: " + deletedShapeList);
    }

    @Override
    public void undo() {
        for (IShape shape : deletedShapeList) {
            shapeList.add(shape);
        }

        System.out.println();
        System.out.println("UNDO master list: " + shapeList.getMasterList());
        System.out.println("UNDO selected list: " + shapeList.getSelectedList());
        System.out.println("UNDO copy list: " + shapeList.getCopyList());
        System.out.println("UNDO deleted list: " + deletedShapeList);
    }

    @Override
    public void redo() {
        for (IShape shape : deletedShapeList) {
            shapeList.remove(shape);
        }

        System.out.println();
        System.out.println("REDO master list: " + shapeList.getMasterList());
        System.out.println("REDO selected list: " + shapeList.getSelectedList());
        System.out.println("REDO copy list: " + shapeList.getCopyList());
        System.out.println("REDO deleted list: " + deletedShapeList);
    }

}
