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
}
