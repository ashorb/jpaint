package view.gui;

import javax.swing.JComponent;
import java.awt.*;
import model.ShapeList;
import model.ShapeType;
import model.drawing.PaintEllipse;
import model.drawing.PaintRectangle;
import model.drawing.PaintTriangle;
import model.drawing.ShapePainter;
import model.interfaces.IPaintStrategy;
import model.interfaces.IShape;
import controller.interfaces.IShapeListObserver;

public class PaintCanvas extends JComponent implements IShapeListObserver {
    private final ShapeList shapeList;
    private IPaintStrategy paintStrategy;

    public PaintCanvas(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

//    public Graphics2D graphics2D() {
//        return (Graphics2D)getGraphics();
//    }

    @Override
    public void paint(Graphics g) {

        Graphics2D graphics2d = (Graphics2D)g;
        ShapePainter painter;

        for (IShape s : shapeList.getList()) {

            if (s.getShapeType().equals(ShapeType.RECTANGLE)) {
                paintStrategy = new PaintRectangle();
            } else if (s.getShapeType().equals(ShapeType.ELLIPSE)) {
                paintStrategy = new PaintEllipse();
            } else if (s.getShapeType().equals(ShapeType.TRIANGLE)) {
                paintStrategy = new PaintTriangle();
            }

            painter = new ShapePainter(paintStrategy);
            painter.paintShape(s, graphics2d);
        }
    }

    @Override
    public void update() {
        this.repaint();
    }
}
