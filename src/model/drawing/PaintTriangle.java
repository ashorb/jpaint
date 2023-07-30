package model.drawing;

import model.interfaces.IPaintStrategy;
import model.interfaces.IShape;
import java.awt.*;

public class PaintTriangle implements IPaintStrategy {
    int[] xPoints;
    int[] yPoints;
    @Override
    public void drawFilledIn(IShape shape, Graphics2D graphics2d) {
        graphics2d.setColor(shape.getPrimaryColor().getColor());
        graphics2d.fillPolygon(shape.getXPoints(), shape.getYPoints(), 3);
    }

    @Override
    public void drawOutline(IShape shape, Graphics2D graphics2d) {
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shape.getSecondaryColor().getColor());
        graphics2d.drawPolygon(shape.getXPoints(), shape.getYPoints(), 3);
    }

    @Override
    public void drawFilledInOutline(IShape shape, Graphics2D graphics2d) {
        graphics2d.setColor(shape.getPrimaryColor().getColor());
        graphics2d.fillPolygon(shape.getXPoints(), shape.getYPoints(), 3);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(shape.getSecondaryColor().getColor());
        graphics2d.drawPolygon(shape.getXPoints(), shape.getYPoints(), 3);
    }

    @Override
    public void drawSelectionOutline(IShape shape, Graphics2D graphics2d) {
        int startX = shape.getStartX();
        int startY = shape.getStartY();
        int endX = shape.getEndX();
        int endY = shape.getEndY();

        if (startX < endX){ //draw from left to right
            xPoints = new int[]{shape.getStartX() - 5, shape.getEndX() + 10, shape.getStartX() - 5};
        }
        else{ //draw from right to left
            xPoints = new int[]{shape.getStartX() + 5, shape.getEndX() - 10, shape.getStartX() + 5};
        }
        if (startY < endY){ //draw from top to bottom
            yPoints = new int[]{shape.getStartY() - 10, shape.getEndY() + 5, shape.getEndY() + 5};
        }
        else{ //draw from bottom to top
            yPoints = new int[]{shape.getStartY() + 10, shape.getEndY() - 5, shape.getEndY() - 5};
        }

        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.MAGENTA);
        graphics2d.drawPolygon(xPoints, yPoints, 3);
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
