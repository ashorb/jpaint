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
//        xPoints = new int[]{shape.getStartX() - 20, shape.getEndX() + 20, shape.getStartX()};
//        yPoints = new int[]{shape.getStartY() - 20, shape.getEndY() + 20, shape.getEndY()};

        int centerX = (shape.getStartX() + shape.getEndX() + shape.getStartX()) / 3;
        int centerY = (shape.getStartY() + shape.getEndY() + shape.getEndY()) / 3;

//        xPoints = new int[]{centerX + (int)(1.2 * (shape.getStartX() - centerX)),
//                centerX + (int)(1.2 * (shape.getEndX() - centerX)),
//                centerX + (int)(1.2 * (shape.getStartX() - centerX))};
//        yPoints = new int[]{centerY + (int)(1.2 * (shape.getStartY() - centerY)),
//                centerY + (int)(1.2 * (shape.getEndY() - centerY)),
//                centerY + (int)(1.2 * (shape.getEndY() - centerY))};

        int startX = shape.getStartX();
        int startY = shape.getStartY();
        int endX = shape.getEndX();
        int endY = shape.getEndY();

        if (startX < endX && startY < endY) { //top-left to bottom-right
            xPoints = new int[]{shape.getStartX() - 5, shape.getEndX() + 10, shape.getStartX() - 5};
            yPoints = new int[]{shape.getStartY() - 10, shape.getEndY() + 5, shape.getEndY() + 5};
        }
        if (startX > endX && startY < endY) { //top-right to bottom left
            xPoints = new int[]{shape.getStartX() + 5, shape.getEndX() - 10, shape.getStartX() + 5};
            yPoints = new int[]{shape.getStartY() - 10, shape.getEndY() + 5, shape.getEndY() + 5};
        }
        if (startX > endX && startY > endY) { //bottom-right to top-left
            xPoints = new int[]{shape.getStartX() + 5, shape.getEndX() - 10, shape.getStartX() + 5};
            yPoints = new int[]{shape.getStartY() + 10, shape.getEndY() - 5, shape.getEndY() - 5};
        }
        if (startX < endX && startY > endY) { //bottom-left to top-right
            xPoints = new int[]{shape.getStartX() - 5, shape.getEndX() + 10, shape.getStartX() - 5};
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
