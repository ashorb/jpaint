package controller;
import model.interfaces.IUndoable;
import model.Shape;
import model.ShapeList;
import model.persistence.CommandHistory;

public class CreateShape implements IUndoable {
    private Shape shape;
    private ShapeList list;

    public void createShape(ShapeList shapeList, int x, int y, int width, int height){
        shape = new Shape(x, y, width, height);
        list = shapeList;
        list.add(shape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        list.remove();
    }

    @Override
    public void redo() {
        list.add(shape);
    }
}
