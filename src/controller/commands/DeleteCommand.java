package controller.commands;

import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import model.*;
import model.interfaces.IShape;
import model.persistence.CommandHistory;

import java.util.ArrayList;

public class DeleteCommand implements ICommand, IUndoable {
    private final ShapeList shapeList;
    private final ArrayList<IShape> deletedShapeList = new ArrayList<>();
    IShape shapeToDelete;


    public DeleteCommand(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        if (!(shapeList.getSelectedList().isEmpty())) {
            for (IShape shape : shapeList.getSelectedList()) {
                shapeList.remove(shape);

                shapeToDelete = shape;
                if(!(deletedShapeList.contains(shapeToDelete))) {
                    deletedShapeList.add(shapeToDelete);
                }
            }
            CommandHistory.add(this);
        }
    }

    @Override
    public void undo() {
        for (IShape shape : deletedShapeList) {
            if (!shapeList.getSelectedList().contains(shape)){
                shape.setIsSelected(false);
            }
            shapeList.add(shape);
        }
    }

    @Override
    public void redo() {
        for (IShape shape : deletedShapeList) {
            shapeList.remove(shape);
        }
    }

}
