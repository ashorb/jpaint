package view.gui;

import javax.swing.JComponent;
import java.awt.*;
//import model.Shape;
import model.ShapeList;
import model.ShapeType;
import model.drawing.PaintEllipse;
import model.drawing.PaintRectangle;
import model.drawing.PaintTriangle;
import model.drawing.ShapePainter;
import model.interfaces.IPaintStrategy;
import model.interfaces.IShape;

public class PaintCanvas extends JComponent {
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

        // Draw all shapes here

//        DrawShapes drawShapes = new DrawShapes(shapeList);
//        drawShapes.draw(graphics2d);

        for (IShape s : shapeList.getList()) {

            if (s.getShapeType().equals(ShapeType.RECTANGLE)) {
                paintStrategy = new PaintRectangle();
            } else if (s.getShapeType().equals(ShapeType.ELLIPSE)) {
                paintStrategy = new PaintEllipse();
            } else if (s.getShapeType().equals(ShapeType.TRIANGLE)) {
                paintStrategy = new PaintTriangle();
            }

//            paintStrategy.paintShape(s, graphics2d);

            painter = new ShapePainter(paintStrategy);
            painter.paintShape(s, graphics2d);
        }


//        for (IShape s : shapeList.getList()) {
////            graphics2d.setColor(Color.GREEN);
//            graphics2d.setStroke(new BasicStroke(5));
//            graphics2d.setColor(Color.BLUE);
//
//            if (s.getShapeType().equals(ShapeType.RECTANGLE)) {
//                graphics2d.drawRect(s.getX(), s.getY(), s.getWidth(), s.getHeight());
//            } else if (s.getShapeType().equals(ShapeType.ELLIPSE)) {
//                graphics2d.drawOval(s.getX(), s.getY(), s.getWidth(), s.getHeight());
//            } else if (s.getShapeType().equals(ShapeType.TRIANGLE)) {
//                graphics2d.drawPolygon(s.getXPoints(), s.getYPoints(), 3);
//            }
//        }


//        for (IShape s : shapeList.getList()) {
//            if (s.getShapeType().equals(ShapeType.RECTANGLE)) {
//                graphics2d.drawRect(s.getX(), s.getY(), s.getWidth(), s.getHeight());
//            } else if (s.getShapeType().equals(ShapeType.ELLIPSE)) {
//                graphics2d.drawOval(s.getX(), s.getY(), s.getWidth(), s.getHeight());
//            } else if (s.getShapeType().equals(ShapeType.TRIANGLE)) {
//                graphics2d.drawPolygon(s.getXPoints(), s.getYPoints(), 3);
////            }
//        }



//            graphics2d.drawOval(s.getX(), s.getY(), s.getWidth(), s.getHeight());
//            graphics2d.drawPolygon(s.getXPoints(), s.getYPoints(), 3);
//        }


//        For example purposes only; remove all lines below from your final project.
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);

//        graphics2d.fillOval(12, 13, 200, 400);
//        graphics2d.fillPolygon(new int[]{10, 40, 10},new int[]{20, 60, 60}, 3 );

//
//        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);

//        graphics2d.drawOval(12, 13, 200, 400);
//        graphics2d.drawPolygon(new int[]{10, 40, 10},new int[]{20, 60, 60}, 3 );
//
//        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);
    }
}
