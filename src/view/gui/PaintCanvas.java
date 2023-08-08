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
    private static PaintCanvas paintCanvasInstance;
    private ShapeList shapeList;
    private IPaintStrategy paintStrategy;

//    public PaintCanvas(ShapeList shapeList) {
//        this.shapeList = shapeList;
//    }

    private PaintCanvas() {
    }

//    public Graphics2D graphics2D() {
//        return (Graphics2D)getGraphics();
//    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;
//        ShapePainter painter;

        for (IShape s : shapeList.getMasterList()) {
//            if (s.getShapeType().equals(ShapeType.RECTANGLE)) {
//                paintStrategy = new PaintRectangle();
//            } else if (s.getShapeType().equals(ShapeType.ELLIPSE)) {
//                paintStrategy = new PaintEllipse();
//            } else if (s.getShapeType().equals(ShapeType.TRIANGLE)) {
//                paintStrategy = new PaintTriangle();
//            }
//
//            painter = new ShapePainter(paintStrategy);
//            painter.paintShape(s, graphics2d);

//            s.draw(paintStrategy, graphics2d);
            s.draw(graphics2d);
            if (s.getIsSelected() == true){
                s.select(graphics2d);
            }
        }
    }

    @Override
    public void update() {
        this.repaint();
    }

    public void setShapeList(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    public static PaintCanvas getInstance() {
        if (paintCanvasInstance == null) {
            paintCanvasInstance = new PaintCanvas();
        }
        return paintCanvasInstance;
    }
}
