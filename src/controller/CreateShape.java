package controller;
import model.interfaces.IUndoable;
import view.gui.PaintCanvas;
import model.Shape;
import model.ShapeList;
import model.persistence.CommandHistory;

import java.awt.*;

public class CreateShape implements IUndoable {
    private Shape shape;

    public void createShape(ShapeList shapeList, int x, int y, int width, int height){
        shape = new Shape(x, y, width, height);
        shapeList.add(shape);
        CommandHistory.add(this);

//        paintCanvas.repaint();
//        Graphics2D graphics2D = (Graphics2D) paintCanvas.getGraphics();
//
//        graphics2D.setColor(Color.GREEN);
//        graphics2D.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
