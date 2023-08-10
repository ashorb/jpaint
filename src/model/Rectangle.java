package model;

import model.drawing.PaintRectangle;
import model.drawing.ShapePainter;
import model.interfaces.IApplicationState;
import model.interfaces.IPaintStrategy;

import java.awt.*;

class Rectangle extends Shape {

    public Rectangle(IApplicationState appState, ShapeAttributes shapeAttributes, int startX, int startY, int endX, int endY) {
        super(appState, shapeAttributes, startX, startY, endX, endY);
    }

    @Override
    public void move(int deltaX, int deltaY){
        x = x + deltaX;
        y = y + deltaY;

        largestX += deltaX;
        largestY += deltaY;

        startX += deltaX;
        startY += deltaY;
        endX = endX + deltaX;
        endY = endY + deltaY;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        IPaintStrategy paintStrategy = new PaintRectangle();
        ShapePainter painter = new ShapePainter(paintStrategy);
        painter.paintShape(this, graphics2D);
    }

    @Override
    public void select(Graphics2D graphics2d) {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.MAGENTA);
        graphics2d.drawRect(getX() - 5, getY() - 5, getWidth() + 10, getHeight() + 10);
    }

    @Override
    public String getIShapeType() {
        return "RECTANGLE";
    }
}
