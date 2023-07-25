package model.drawing;

import model.interfaces.IPaintStrategy;
import model.interfaces.IShape;
import java.awt.*;

public class PaintEllipse implements IPaintStrategy {
    @Override
    public void drawFilledIn(IShape shape, Graphics2D graphics2d) {
        graphics2d.setColor(shape.getPrimaryColor().getColor());
        graphics2d.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }

    @Override
    public void drawOutline(IShape shape, Graphics2D graphics2d) {
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shape.getSecondaryColor().getColor());
        graphics2d.drawOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }

    @Override
    public void drawFilledInOutline(IShape shape, Graphics2D graphics2d) {
        graphics2d.setColor(shape.getPrimaryColor().getColor());
        graphics2d.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shape.getSecondaryColor().getColor());
        graphics2d.drawOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }

    @Override
    public void drawSelectionOutline(IShape shape, Graphics2D graphics2d) {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.MAGENTA);
        graphics2d.drawOval(shape.getX() - 5, shape.getY() - 5, shape.getWidth() + 10, shape.getHeight() + 10);
    }

//    @Override
//    public void moveShape() {
//
//    }
//
//    @Override
//    public void pasteShape() {
//
//    }
//
//    @Override
//    public void deleteShape() {
//
//    }
}
