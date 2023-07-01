package view.gui;

import javax.swing.JComponent;
import java.awt.*;
import model.Shape;
import model.ShapeList;

public class PaintCanvas extends JComponent {
    public ShapeList shapeList;
    public PaintCanvas(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

//    public Graphics2D graphics2D() {
//        return (Graphics2D)getGraphics();
//    }

    @Override
    public void paint(Graphics g) {

        Graphics2D graphics2d = (Graphics2D)g;

        // Draw all shapes here
        // For example purposes only; remove all lines below from your final project.

        for (Shape s : shapeList.getList()) {
            graphics2d.setColor(Color.GREEN);
            graphics2d.fillRect(s.getX(), s.getY(), s.getWidth(), s.getHeight());
        }

//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);
//
//        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);
//
//        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);
    }
}
