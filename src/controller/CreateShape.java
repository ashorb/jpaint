package controller;
import view.gui.PaintCanvas;
import model.Shape;
import model.ShapeList;

import java.awt.*;

public class CreateShape {
    public static void createShape(PaintCanvas paintCanvas, ShapeList shapeList, int x, int y, int width, int height){
        Shape rect = new Shape(x, y, width, height);
        shapeList.add(rect);
        paintCanvas.repaint();

//        Graphics2D graphics2D = (Graphics2D) paintCanvas.getGraphics();
//
//        graphics2D.setColor(Color.GREEN);
//        graphics2D.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }
}
